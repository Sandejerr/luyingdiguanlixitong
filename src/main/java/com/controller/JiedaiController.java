
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
 * 接待
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiedai")
public class JiedaiController {
    private static final Logger logger = LoggerFactory.getLogger(JiedaiController.class);

    private static final String TABLE_NAME = "jiedai";

    @Autowired
    private JiedaiService jiedaiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChujiguanliService chujiguanliService;//初级管理
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private JiesuanService jiesuanService;//结算
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
        params.put("jiedaiDeleteStart",1);params.put("jiedaiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jiedaiService.queryPage(params);

        //字典表数据转换
        List<JiedaiView> list =(List<JiedaiView>)page.getList();
        for(JiedaiView c:list){
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
        JiedaiEntity jiedai = jiedaiService.selectById(id);
        if(jiedai !=null){
            //entity转view
            JiedaiView view = new JiedaiView();
            BeanUtils.copyProperties( jiedai , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jiedai.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 营地
            //级联表
            YingdiEntity yingdi = yingdiService.selectById(jiedai.getYingdiId());
            if(yingdi != null){
            BeanUtils.copyProperties( yingdi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYingdiId(yingdi.getId());
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
    public R save(@RequestBody JiedaiEntity jiedai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiedai:{}",this.getClass().getName(),jiedai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            jiedai.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiedaiEntity> queryWrapper = new EntityWrapper<JiedaiEntity>()
            .eq("yingdi_id", jiedai.getYingdiId())
            .eq("yonghu_id", jiedai.getYonghuId())
            .eq("jiedai_name", jiedai.getJiedaiName())
            .eq("jiedai_types", jiedai.getJiedaiTypes())
            .eq("jiedai_zhuangtai_types", jiedai.getJiedaiZhuangtaiTypes())
            .eq("jiedai_delete", jiedai.getJiedaiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiedaiEntity jiedaiEntity = jiedaiService.selectOne(queryWrapper);
        if(jiedaiEntity==null){
            jiedai.setJiedaiDelete(1);
            jiedai.setInsertTime(new Date());
            jiedai.setCreateTime(new Date());
            jiedaiService.insert(jiedai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiedaiEntity jiedai, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jiedai:{}",this.getClass().getName(),jiedai.toString());
        JiedaiEntity oldJiedaiEntity = jiedaiService.selectById(jiedai.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            jiedai.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jiedai.getJiedaiPhoto()) || "null".equals(jiedai.getJiedaiPhoto())){
                jiedai.setJiedaiPhoto(null);
        }

            jiedaiService.updateById(jiedai);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JiedaiEntity> oldJiedaiList =jiedaiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JiedaiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiedaiEntity jiedaiEntity = new JiedaiEntity();
            jiedaiEntity.setId(id);
            jiedaiEntity.setJiedaiDelete(2);
            list.add(jiedaiEntity);
        }
        if(list != null && list.size() >0){
            jiedaiService.updateBatchById(list);
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
            List<JiedaiEntity> jiedaiList = new ArrayList<>();//上传的东西
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
                            JiedaiEntity jiedaiEntity = new JiedaiEntity();
//                            jiedaiEntity.setYingdiId(Integer.valueOf(data.get(0)));   //营地 要改的
//                            jiedaiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jiedaiEntity.setJiedaiName(data.get(0));                    //接待名称 要改的
//                            jiedaiEntity.setJiedaiUuidNumber(data.get(0));                    //接待编号 要改的
//                            jiedaiEntity.setJiedaiPhoto("");//详情和图片
//                            jiedaiEntity.setJiedaiTypes(Integer.valueOf(data.get(0)));   //接待类型 要改的
//                            jiedaiEntity.setJiedaiNewMoney(data.get(0));                    //价格 要改的
//                            jiedaiEntity.setJiedaiZhuangtaiTypes(Integer.valueOf(data.get(0)));   //接待状态 要改的
//                            jiedaiEntity.setJiedaiContent("");//详情和图片
//                            jiedaiEntity.setJiedaiDelete(1);//逻辑删除字段
//                            jiedaiEntity.setInsertTime(date);//时间
//                            jiedaiEntity.setCreateTime(date);//时间
                            jiedaiList.add(jiedaiEntity);


                            //把要查询是否重复的字段放入map中
                                //接待编号
                                if(seachFields.containsKey("jiedaiUuidNumber")){
                                    List<String> jiedaiUuidNumber = seachFields.get("jiedaiUuidNumber");
                                    jiedaiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiedaiUuidNumber = new ArrayList<>();
                                    jiedaiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiedaiUuidNumber",jiedaiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //接待编号
                        List<JiedaiEntity> jiedaiEntities_jiedaiUuidNumber = jiedaiService.selectList(new EntityWrapper<JiedaiEntity>().in("jiedai_uuid_number", seachFields.get("jiedaiUuidNumber")).eq("jiedai_delete", 1));
                        if(jiedaiEntities_jiedaiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiedaiEntity s:jiedaiEntities_jiedaiUuidNumber){
                                repeatFields.add(s.getJiedaiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [接待编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiedaiService.insertBatch(jiedaiList);
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
        PageUtils page = jiedaiService.queryPage(params);

        //字典表数据转换
        List<JiedaiView> list =(List<JiedaiView>)page.getList();
        for(JiedaiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiedaiEntity jiedai = jiedaiService.selectById(id);
            if(jiedai !=null){


                //entity转view
                JiedaiView view = new JiedaiView();
                BeanUtils.copyProperties( jiedai , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jiedai.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YingdiEntity yingdi = yingdiService.selectById(jiedai.getYingdiId());
                if(yingdi != null){
                    BeanUtils.copyProperties( yingdi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYingdiId(yingdi.getId());
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
    public R add(@RequestBody JiedaiEntity jiedai, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiedai:{}",this.getClass().getName(),jiedai.toString());
        Wrapper<JiedaiEntity> queryWrapper = new EntityWrapper<JiedaiEntity>()
            .eq("yingdi_id", jiedai.getYingdiId())
            .eq("yonghu_id", jiedai.getYonghuId())
            .eq("jiedai_name", jiedai.getJiedaiName())
            .eq("jiedai_uuid_number", jiedai.getJiedaiUuidNumber())
            .eq("jiedai_types", jiedai.getJiedaiTypes())
            .eq("jiedai_zhuangtai_types", jiedai.getJiedaiZhuangtaiTypes())
            .eq("jiedai_delete", jiedai.getJiedaiDelete())
//            .notIn("jiedai_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiedaiEntity jiedaiEntity = jiedaiService.selectOne(queryWrapper);
        if(jiedaiEntity==null){
            jiedai.setJiedaiDelete(1);
            jiedai.setInsertTime(new Date());
            jiedai.setCreateTime(new Date());
        jiedaiService.insert(jiedai);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

