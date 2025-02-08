
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
 * 营地
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yingdi")
public class YingdiController {
    private static final Logger logger = LoggerFactory.getLogger(YingdiController.class);

    private static final String TABLE_NAME = "yingdi";

    @Autowired
    private YingdiService yingdiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChujiguanliService chujiguanliService;//初级管理
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private JiedaiService jiedaiService;//接待
    @Autowired
    private JiesuanService jiesuanService;//结算
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
        params.put("yingdiDeleteStart",1);params.put("yingdiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = yingdiService.queryPage(params);

        //字典表数据转换
        List<YingdiView> list =(List<YingdiView>)page.getList();
        for(YingdiView c:list){
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
        YingdiEntity yingdi = yingdiService.selectById(id);
        if(yingdi !=null){
            //entity转view
            YingdiView view = new YingdiView();
            BeanUtils.copyProperties( yingdi , view );//把实体数据重构到view中
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
    public R save(@RequestBody YingdiEntity yingdi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yingdi:{}",this.getClass().getName(),yingdi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<YingdiEntity> queryWrapper = new EntityWrapper<YingdiEntity>()
            .eq("yingdi_name", yingdi.getYingdiName())
            .eq("yingdi_address", yingdi.getYingdiAddress())
            .eq("yingdi_types", yingdi.getYingdiTypes())
            .eq("yingdi_zhuangtai_types", yingdi.getYingdiZhuangtaiTypes())
            .eq("yingdi_clicknum", yingdi.getYingdiClicknum())
            .eq("yingdi_delete", yingdi.getYingdiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YingdiEntity yingdiEntity = yingdiService.selectOne(queryWrapper);
        if(yingdiEntity==null){
            yingdi.setYingdiClicknum(1);
            yingdi.setYingdiDelete(1);
            yingdi.setInsertTime(new Date());
            yingdi.setCreateTime(new Date());
            yingdiService.insert(yingdi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YingdiEntity yingdi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yingdi:{}",this.getClass().getName(),yingdi.toString());
        YingdiEntity oldYingdiEntity = yingdiService.selectById(yingdi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(yingdi.getYingdiPhoto()) || "null".equals(yingdi.getYingdiPhoto())){
                yingdi.setYingdiPhoto(null);
        }

            yingdiService.updateById(yingdi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YingdiEntity> oldYingdiList =yingdiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<YingdiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            YingdiEntity yingdiEntity = new YingdiEntity();
            yingdiEntity.setId(id);
            yingdiEntity.setYingdiDelete(2);
            list.add(yingdiEntity);
        }
        if(list != null && list.size() >0){
            yingdiService.updateBatchById(list);
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
            List<YingdiEntity> yingdiList = new ArrayList<>();//上传的东西
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
                            YingdiEntity yingdiEntity = new YingdiEntity();
//                            yingdiEntity.setYingdiName(data.get(0));                    //营地名称 要改的
//                            yingdiEntity.setYingdiUuidNumber(data.get(0));                    //营地编号 要改的
//                            yingdiEntity.setYingdiPhoto("");//详情和图片
//                            yingdiEntity.setYingdiAddress(data.get(0));                    //营地地点 要改的
//                            yingdiEntity.setYingdiTypes(Integer.valueOf(data.get(0)));   //营地类型 要改的
//                            yingdiEntity.setYingdiNewMoney(data.get(0));                    //价格 要改的
//                            yingdiEntity.setYingdiZhuangtaiTypes(Integer.valueOf(data.get(0)));   //营地状态 要改的
//                            yingdiEntity.setYingdiClicknum(Integer.valueOf(data.get(0)));   //营地热度 要改的
//                            yingdiEntity.setYingdiContent("");//详情和图片
//                            yingdiEntity.setYingdiDelete(1);//逻辑删除字段
//                            yingdiEntity.setInsertTime(date);//时间
//                            yingdiEntity.setCreateTime(date);//时间
                            yingdiList.add(yingdiEntity);


                            //把要查询是否重复的字段放入map中
                                //营地编号
                                if(seachFields.containsKey("yingdiUuidNumber")){
                                    List<String> yingdiUuidNumber = seachFields.get("yingdiUuidNumber");
                                    yingdiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> yingdiUuidNumber = new ArrayList<>();
                                    yingdiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("yingdiUuidNumber",yingdiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //营地编号
                        List<YingdiEntity> yingdiEntities_yingdiUuidNumber = yingdiService.selectList(new EntityWrapper<YingdiEntity>().in("yingdi_uuid_number", seachFields.get("yingdiUuidNumber")).eq("yingdi_delete", 1));
                        if(yingdiEntities_yingdiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YingdiEntity s:yingdiEntities_yingdiUuidNumber){
                                repeatFields.add(s.getYingdiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [营地编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        yingdiService.insertBatch(yingdiList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<YingdiView> returnYingdiViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = yingdiOrderService.queryPage(params1);
        List<YingdiOrderView> orderViewsList =(List<YingdiOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(YingdiOrderView orderView:orderViewsList){
            Integer yingdiTypes = orderView.getYingdiTypes();
            if(typeMap.containsKey(yingdiTypes)){
                typeMap.put(yingdiTypes,typeMap.get(yingdiTypes)+1);
            }else{
                typeMap.put(yingdiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("yingdiTypes",type);
            PageUtils pageUtils1 = yingdiService.queryPage(params2);
            List<YingdiView> yingdiViewList =(List<YingdiView>)pageUtils1.getList();
            returnYingdiViewList.addAll(yingdiViewList);
            if(returnYingdiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = yingdiService.queryPage(params);
        if(returnYingdiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnYingdiViewList.size();//要添加的数量
            List<YingdiView> yingdiViewList =(List<YingdiView>)page.getList();
            for(YingdiView yingdiView:yingdiViewList){
                Boolean addFlag = true;
                for(YingdiView returnYingdiView:returnYingdiViewList){
                    if(returnYingdiView.getId().intValue() ==yingdiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnYingdiViewList.add(yingdiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnYingdiViewList = returnYingdiViewList.subList(0, limit);
        }

        for(YingdiView c:returnYingdiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnYingdiViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yingdiService.queryPage(params);

        //字典表数据转换
        List<YingdiView> list =(List<YingdiView>)page.getList();
        for(YingdiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YingdiEntity yingdi = yingdiService.selectById(id);
            if(yingdi !=null){

                //点击数量加1
                yingdi.setYingdiClicknum(yingdi.getYingdiClicknum()+1);
                yingdiService.updateById(yingdi);

                //entity转view
                YingdiView view = new YingdiView();
                BeanUtils.copyProperties( yingdi , view );//把实体数据重构到view中

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
    public R add(@RequestBody YingdiEntity yingdi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yingdi:{}",this.getClass().getName(),yingdi.toString());
        Wrapper<YingdiEntity> queryWrapper = new EntityWrapper<YingdiEntity>()
            .eq("yingdi_name", yingdi.getYingdiName())
            .eq("yingdi_uuid_number", yingdi.getYingdiUuidNumber())
            .eq("yingdi_address", yingdi.getYingdiAddress())
            .eq("yingdi_types", yingdi.getYingdiTypes())
            .eq("yingdi_zhuangtai_types", yingdi.getYingdiZhuangtaiTypes())
            .eq("yingdi_clicknum", yingdi.getYingdiClicknum())
            .eq("yingdi_delete", yingdi.getYingdiDelete())
//            .notIn("yingdi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YingdiEntity yingdiEntity = yingdiService.selectOne(queryWrapper);
        if(yingdiEntity==null){
            yingdi.setYingdiDelete(1);
            yingdi.setInsertTime(new Date());
            yingdi.setCreateTime(new Date());
        yingdiService.insert(yingdi);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

