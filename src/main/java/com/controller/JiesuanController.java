
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 结算
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiesuan")
public class JiesuanController {
    private static final Logger logger = LoggerFactory.getLogger(JiesuanController.class);

    private static final String TABLE_NAME = "jiesuan";

    @Autowired
    private JiesuanService jiesuanService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChujiguanliService chujiguanliService;//初级管理
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private JiedaiService jiedaiService;//接待
    @Autowired
    private YingdiService yingdiService;//营地
    @Autowired
    private YingdiOrderService yingdiOrderService;//营地预约
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("初级管理".equals(role))
            params.put("chujiguanliId",request.getSession().getAttribute("userId"));
        params.put("jiesuanDeleteStart",1);params.put("jiesuanDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jiesuanService.queryPage(params);

        //字典表数据转换
        List<JiesuanView> list =(List<JiesuanView>)page.getList();
        for(JiesuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiesuanEntity jiesuan = jiesuanService.selectById(id);
        if(jiesuan !=null){
            //entity转view
            JiesuanView view = new JiesuanView();
            BeanUtils.copyProperties( jiesuan , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiesuan.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 接待
            //级联表
            JiedaiEntity jiedai = jiedaiService.selectById(jiesuan.getJiedaiId());
            if(jiedai != null){
            BeanUtils.copyProperties( jiedai , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJiedaiId(jiedai.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiesuanEntity jiesuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiesuan:{}",this.getClass().getName(),jiesuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jiesuan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiesuanEntity> queryWrapper = new EntityWrapper<JiesuanEntity>()
            .eq("jiedai_id", jiesuan.getJiedaiId())
            .eq("yonghu_id", jiesuan.getYonghuId())
            .eq("jiesuan_name", jiesuan.getJiesuanName())
            .eq("jiesuan_zhuangtai_types", jiesuan.getJiesuanZhuangtaiTypes())
            .eq("jiesuan_delete", jiesuan.getJiesuanDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiesuanEntity jiesuanEntity = jiesuanService.selectOne(queryWrapper);
        if(jiesuanEntity==null){
            jiesuan.setJiesuanDelete(1);
            jiesuan.setInsertTime(new Date());
            jiesuan.setCreateTime(new Date());
            jiesuanService.insert(jiesuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiesuanEntity jiesuan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiesuan:{}",this.getClass().getName(),jiesuan.toString());
        JiesuanEntity oldJiesuanEntity = jiesuanService.selectById(jiesuan.getId());//查询原先数据
        JiedaiEntity jiedaiEntity = jiedaiService.selectById(oldJiesuanEntity.getJiedaiId());
        YingdiEntity yingdiEntity = yingdiService.selectById(jiedaiEntity.getYingdiId());
        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jiesuan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jiesuan.getJiesuanPhoto()) || "null".equals(jiesuan.getJiesuanPhoto())){
                jiesuan.setJiesuanPhoto(null);
        }
            jiesuan.setJiesuanZhuangtaiTypes(2);
            jiedaiEntity.setJiedaiZhuangtaiTypes(2);
            yingdiEntity.setYingdiZhuangtaiTypes(2);

            jiedaiService.updateById(jiedaiEntity);
            yingdiService.updateById(yingdiEntity);
            jiesuanService.updateById(jiesuan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiesuanEntity> oldJiesuanList =jiesuanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JiesuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiesuanEntity jiesuanEntity = new JiesuanEntity();
            jiesuanEntity.setId(id);
            jiesuanEntity.setJiesuanDelete(2);
            list.add(jiesuanEntity);
        }
        if(list != null && list.size() >0){
            jiesuanService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JiesuanEntity> jiesuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiesuanEntity jiesuanEntity = new JiesuanEntity();
//                            jiesuanEntity.setJiedaiId(Integer.valueOf(data.get(0)));   //营地 要改的
//                            jiesuanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jiesuanEntity.setJiesuanName(data.get(0));                    //结算名称 要改的
//                            jiesuanEntity.setJiesuanUuidNumber(data.get(0));                    //结算编号 要改的
//                            jiesuanEntity.setJiesuanPhoto("");//详情和图片
//                            jiesuanEntity.setJiesuanNewMoney(data.get(0));                    //价格 要改的
//                            jiesuanEntity.setJiesuanZhuangtaiTypes(Integer.valueOf(data.get(0)));   //结算状态 要改的
//                            jiesuanEntity.setJiesuanContent("");//详情和图片
//                            jiesuanEntity.setJiesuanDelete(1);//逻辑删除字段
//                            jiesuanEntity.setInsertTime(date);//时间
//                            jiesuanEntity.setCreateTime(date);//时间
                            jiesuanList.add(jiesuanEntity);


                            //把要查询是否重复的字段放入map中
                                //结算编号
                                if(seachFields.containsKey("jiesuanUuidNumber")){
                                    List<String> jiesuanUuidNumber = seachFields.get("jiesuanUuidNumber");
                                    jiesuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiesuanUuidNumber = new ArrayList<>();
                                    jiesuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiesuanUuidNumber",jiesuanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //结算编号
                        List<JiesuanEntity> jiesuanEntities_jiesuanUuidNumber = jiesuanService.selectList(new EntityWrapper<JiesuanEntity>().in("jiesuan_uuid_number", seachFields.get("jiesuanUuidNumber")).eq("jiesuan_delete", 1));
                        if(jiesuanEntities_jiesuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiesuanEntity s:jiesuanEntities_jiesuanUuidNumber){
                                repeatFields.add(s.getJiesuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [结算编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiesuanService.insertBatch(jiesuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jiesuanService.queryPage(params);

        //字典表数据转换
        List<JiesuanView> list =(List<JiesuanView>)page.getList();
        for(JiesuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiesuanEntity jiesuan = jiesuanService.selectById(id);
            if(jiesuan !=null){


                //entity转view
                JiesuanView view = new JiesuanView();
                BeanUtils.copyProperties( jiesuan , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiesuan.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    JiedaiEntity jiedai = jiedaiService.selectById(jiesuan.getJiedaiId());
                if(jiedai != null){
                    BeanUtils.copyProperties( jiedai , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJiedaiId(jiedai.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JiesuanEntity jiesuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiesuan:{}",this.getClass().getName(),jiesuan.toString());
        Wrapper<JiesuanEntity> queryWrapper = new EntityWrapper<JiesuanEntity>()
            .eq("jiedai_id", jiesuan.getJiedaiId())
            .eq("yonghu_id", jiesuan.getYonghuId())
            .eq("jiesuan_name", jiesuan.getJiesuanName())
            .eq("jiesuan_uuid_number", jiesuan.getJiesuanUuidNumber())
            .eq("jiesuan_zhuangtai_types", jiesuan.getJiesuanZhuangtaiTypes())
            .eq("jiesuan_delete", jiesuan.getJiesuanDelete())
//            .notIn("jiesuan_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiesuanEntity jiesuanEntity = jiesuanService.selectOne(queryWrapper);
        if(jiesuanEntity==null){
            jiesuan.setJiesuanDelete(1);
            jiesuan.setInsertTime(new Date());
            jiesuan.setCreateTime(new Date());
        jiesuanService.insert(jiesuan);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

