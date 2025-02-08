
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
 * 营地预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yingdiOrder")
public class YingdiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(YingdiOrderController.class);

    private static final String TABLE_NAME = "yingdiOrder";

    @Autowired
    private YingdiOrderService yingdiOrderService;


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
    private YingdiService yingdiService;//营地
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
        CommonUtil.checkMap(params);
        PageUtils page = yingdiOrderService.queryPage(params);

        //字典表数据转换
        List<YingdiOrderView> list =(List<YingdiOrderView>)page.getList();
        for(YingdiOrderView c:list){
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
        YingdiOrderEntity yingdiOrder = yingdiOrderService.selectById(id);
        if(yingdiOrder !=null){
            //entity转view
            YingdiOrderView view = new YingdiOrderView();
            BeanUtils.copyProperties( yingdiOrder , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yingdiOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 营地
            //级联表
            YingdiEntity yingdi = yingdiService.selectById(yingdiOrder.getYingdiId());
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
    public R save(@RequestBody YingdiOrderEntity yingdiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yingdiOrder:{}",this.getClass().getName(),yingdiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            yingdiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        yingdiOrder.setCreateTime(new Date());
        yingdiOrder.setInsertTime(new Date());
        yingdiOrderService.insert(yingdiOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YingdiOrderEntity yingdiOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yingdiOrder:{}",this.getClass().getName(),yingdiOrder.toString());
        YingdiOrderEntity oldYingdiOrderEntity = yingdiOrderService.selectById(yingdiOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            yingdiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            yingdiOrderService.updateById(yingdiOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YingdiOrderEntity> oldYingdiOrderList =yingdiOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yingdiOrderService.deleteBatchIds(Arrays.asList(ids));

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
            List<YingdiOrderEntity> yingdiOrderList = new ArrayList<>();//上传的东西
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
                            YingdiOrderEntity yingdiOrderEntity = new YingdiOrderEntity();
//                            yingdiOrderEntity.setYingdiId(Integer.valueOf(data.get(0)));   //营地 要改的
//                            yingdiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            yingdiOrderEntity.setYingdiOrderTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            yingdiOrderEntity.setYingdiOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            yingdiOrderEntity.setYingdiOrderTypes(Integer.valueOf(data.get(0)));   //营地类型 要改的
//                            yingdiOrderEntity.setInsertTime(date);//时间
//                            yingdiOrderEntity.setCreateTime(date);//时间
                            yingdiOrderList.add(yingdiOrderEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yingdiOrderService.insertBatch(yingdiOrderList);
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
        PageUtils page = yingdiOrderService.queryPage(params);

        //字典表数据转换
        List<YingdiOrderView> list =(List<YingdiOrderView>)page.getList();
        for(YingdiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YingdiOrderEntity yingdiOrder = yingdiOrderService.selectById(id);
            if(yingdiOrder !=null){


                //entity转view
                YingdiOrderView view = new YingdiOrderView();
                BeanUtils.copyProperties( yingdiOrder , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(yingdiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YingdiEntity yingdi = yingdiService.selectById(yingdiOrder.getYingdiId());
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
    public R add(@RequestBody YingdiOrderEntity yingdiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yingdiOrder:{}",this.getClass().getName(),yingdiOrder.toString());
            YingdiEntity yingdiEntity = yingdiService.selectById(yingdiOrder.getYingdiId());
            if(yingdiEntity == null){
                return R.error(511,"查不到该营地");
            }
            // Double yingdiNewMoney = yingdiEntity.getYingdiNewMoney();

            if(false){
            }
            else if(yingdiEntity.getYingdiNewMoney() == null){
                return R.error(511,"价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - yingdiEntity.getYingdiNewMoney()*1;//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            yingdiOrder.setYingdiOrderTypes(101); //设置订单状态为已预约
            yingdiOrder.setYingdiOrderTruePrice(yingdiEntity.getYingdiNewMoney()*1); //设置实付价格
            yingdiOrder.setYonghuId(userId); //设置订单支付人id
            yingdiOrder.setInsertTime(new Date());
            yingdiOrder.setCreateTime(new Date());
                yingdiOrderService.insert(yingdiOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
            yingdiEntity.setYingdiZhuangtaiTypes(1);

            yingdiService.updateById(yingdiEntity);
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 取消预约
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            YingdiOrderEntity yingdiOrder = yingdiOrderService.selectById(id);//当前表service
            Integer yingdiId = yingdiOrder.getYingdiId();
            if(yingdiId == null)
                return R.error(511,"查不到该营地");
            YingdiEntity yingdiEntity = yingdiService.selectById(yingdiId);
            if(yingdiEntity == null)
                return R.error(511,"查不到该营地");
            Double yingdiNewMoney = yingdiEntity.getYingdiNewMoney();
            if(yingdiNewMoney == null)
                return R.error(511,"营地价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;

                //计算金额
                Double money = yingdiEntity.getYingdiNewMoney() * 1  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额

            yingdiEntity.setYingdiZhuangtaiTypes(2);



            yingdiOrder.setYingdiOrderTypes(102);//设置订单状态为已取消预约
            yingdiOrderService.updateById(yingdiOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            yingdiService.updateById(yingdiEntity);//更新订单中营地的信息

            return R.ok();
    }

    /**
     * 同意预约
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        YingdiOrderEntity  yingdiOrderEntity = yingdiOrderService.selectById(id);
        yingdiOrderEntity.setYingdiOrderTypes(103);//设置订单状态为已同意预约
        yingdiOrderService.updateById( yingdiOrderEntity);

        return R.ok();
    }


}

