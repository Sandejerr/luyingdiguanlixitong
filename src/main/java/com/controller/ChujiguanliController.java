
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
 * 初级管理
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chujiguanli")
public class ChujiguanliController {
    private static final Logger logger = LoggerFactory.getLogger(ChujiguanliController.class);

    private static final String TABLE_NAME = "chujiguanli";

    @Autowired
    private ChujiguanliService chujiguanliService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private JiedaiService jiedaiService;//接待
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
        CommonUtil.checkMap(params);
        PageUtils page = chujiguanliService.queryPage(params);

        //字典表数据转换
        List<ChujiguanliView> list =(List<ChujiguanliView>)page.getList();
        for(ChujiguanliView c:list){
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
        ChujiguanliEntity chujiguanli = chujiguanliService.selectById(id);
        if(chujiguanli !=null){
            //entity转view
            ChujiguanliView view = new ChujiguanliView();
            BeanUtils.copyProperties( chujiguanli , view );//把实体数据重构到view中
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
    public R save(@RequestBody ChujiguanliEntity chujiguanli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chujiguanli:{}",this.getClass().getName(),chujiguanli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChujiguanliEntity> queryWrapper = new EntityWrapper<ChujiguanliEntity>()
            .eq("username", chujiguanli.getUsername())
            .or()
            .eq("chujiguanli_phone", chujiguanli.getChujiguanliPhone())
            .or()
            .eq("chujiguanli_id_number", chujiguanli.getChujiguanliIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChujiguanliEntity chujiguanliEntity = chujiguanliService.selectOne(queryWrapper);
        if(chujiguanliEntity==null){
            chujiguanli.setCreateTime(new Date());
            chujiguanli.setPassword("123456");
            chujiguanliService.insert(chujiguanli);
            return R.ok();
        }else {
            return R.error(511,"账户或者初级管理手机号或者初级管理身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChujiguanliEntity chujiguanli, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chujiguanli:{}",this.getClass().getName(),chujiguanli.toString());
        ChujiguanliEntity oldChujiguanliEntity = chujiguanliService.selectById(chujiguanli.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(chujiguanli.getChujiguanliPhoto()) || "null".equals(chujiguanli.getChujiguanliPhoto())){
                chujiguanli.setChujiguanliPhoto(null);
        }

            chujiguanliService.updateById(chujiguanli);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChujiguanliEntity> oldChujiguanliList =chujiguanliService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        chujiguanliService.deleteBatchIds(Arrays.asList(ids));

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
            List<ChujiguanliEntity> chujiguanliList = new ArrayList<>();//上传的东西
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
                            ChujiguanliEntity chujiguanliEntity = new ChujiguanliEntity();
//                            chujiguanliEntity.setUsername(data.get(0));                    //账户 要改的
//                            //chujiguanliEntity.setPassword("123456");//密码
//                            chujiguanliEntity.setChujiguanliName(data.get(0));                    //初级管理姓名 要改的
//                            chujiguanliEntity.setChujiguanliPhone(data.get(0));                    //初级管理手机号 要改的
//                            chujiguanliEntity.setChujiguanliIdNumber(data.get(0));                    //初级管理身份证号 要改的
//                            chujiguanliEntity.setChujiguanliPhoto("");//详情和图片
//                            chujiguanliEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            chujiguanliEntity.setChujiguanliEmail(data.get(0));                    //电子邮箱 要改的
//                            chujiguanliEntity.setCreateTime(date);//时间
                            chujiguanliList.add(chujiguanliEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //初级管理手机号
                                if(seachFields.containsKey("chujiguanliPhone")){
                                    List<String> chujiguanliPhone = seachFields.get("chujiguanliPhone");
                                    chujiguanliPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> chujiguanliPhone = new ArrayList<>();
                                    chujiguanliPhone.add(data.get(0));//要改的
                                    seachFields.put("chujiguanliPhone",chujiguanliPhone);
                                }
                                //初级管理身份证号
                                if(seachFields.containsKey("chujiguanliIdNumber")){
                                    List<String> chujiguanliIdNumber = seachFields.get("chujiguanliIdNumber");
                                    chujiguanliIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chujiguanliIdNumber = new ArrayList<>();
                                    chujiguanliIdNumber.add(data.get(0));//要改的
                                    seachFields.put("chujiguanliIdNumber",chujiguanliIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ChujiguanliEntity> chujiguanliEntities_username = chujiguanliService.selectList(new EntityWrapper<ChujiguanliEntity>().in("username", seachFields.get("username")));
                        if(chujiguanliEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChujiguanliEntity s:chujiguanliEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //初级管理手机号
                        List<ChujiguanliEntity> chujiguanliEntities_chujiguanliPhone = chujiguanliService.selectList(new EntityWrapper<ChujiguanliEntity>().in("chujiguanli_phone", seachFields.get("chujiguanliPhone")));
                        if(chujiguanliEntities_chujiguanliPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChujiguanliEntity s:chujiguanliEntities_chujiguanliPhone){
                                repeatFields.add(s.getChujiguanliPhone());
                            }
                            return R.error(511,"数据库的该表中的 [初级管理手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //初级管理身份证号
                        List<ChujiguanliEntity> chujiguanliEntities_chujiguanliIdNumber = chujiguanliService.selectList(new EntityWrapper<ChujiguanliEntity>().in("chujiguanli_id_number", seachFields.get("chujiguanliIdNumber")));
                        if(chujiguanliEntities_chujiguanliIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChujiguanliEntity s:chujiguanliEntities_chujiguanliIdNumber){
                                repeatFields.add(s.getChujiguanliIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [初级管理身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chujiguanliService.insertBatch(chujiguanliList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ChujiguanliEntity chujiguanli = chujiguanliService.selectOne(new EntityWrapper<ChujiguanliEntity>().eq("username", username));
        if(chujiguanli==null || !chujiguanli.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(chujiguanli.getId(),username, "chujiguanli", "初级管理");
        R r = R.ok();
        r.put("token", token);
        r.put("role","初级管理");
        r.put("username",chujiguanli.getChujiguanliName());
        r.put("tableName","chujiguanli");
        r.put("userId",chujiguanli.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ChujiguanliEntity chujiguanli, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ChujiguanliEntity> queryWrapper = new EntityWrapper<ChujiguanliEntity>()
            .eq("username", chujiguanli.getUsername())
            .or()
            .eq("chujiguanli_phone", chujiguanli.getChujiguanliPhone())
            .or()
            .eq("chujiguanli_id_number", chujiguanli.getChujiguanliIdNumber())
            ;
        ChujiguanliEntity chujiguanliEntity = chujiguanliService.selectOne(queryWrapper);
        if(chujiguanliEntity != null)
            return R.error("账户或者初级管理手机号或者初级管理身份证号已经被使用");
        chujiguanli.setCreateTime(new Date());
        chujiguanliService.insert(chujiguanli);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        ChujiguanliEntity chujiguanli = chujiguanliService.selectById(id);
        chujiguanli.setPassword("123456");
        chujiguanliService.updateById(chujiguanli);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ChujiguanliEntity chujiguanli = chujiguanliService.selectOne(new EntityWrapper<ChujiguanliEntity>().eq("username", username));
        if(chujiguanli!=null){
            chujiguanli.setPassword("123456");
            chujiguanliService.updateById(chujiguanli);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrChujiguanli(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ChujiguanliEntity chujiguanli = chujiguanliService.selectById(id);
        if(chujiguanli !=null){
            //entity转view
            ChujiguanliView view = new ChujiguanliView();
            BeanUtils.copyProperties( chujiguanli , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = chujiguanliService.queryPage(params);

        //字典表数据转换
        List<ChujiguanliView> list =(List<ChujiguanliView>)page.getList();
        for(ChujiguanliView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChujiguanliEntity chujiguanli = chujiguanliService.selectById(id);
            if(chujiguanli !=null){


                //entity转view
                ChujiguanliView view = new ChujiguanliView();
                BeanUtils.copyProperties( chujiguanli , view );//把实体数据重构到view中

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
    public R add(@RequestBody ChujiguanliEntity chujiguanli, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chujiguanli:{}",this.getClass().getName(),chujiguanli.toString());
        Wrapper<ChujiguanliEntity> queryWrapper = new EntityWrapper<ChujiguanliEntity>()
            .eq("username", chujiguanli.getUsername())
            .or()
            .eq("chujiguanli_phone", chujiguanli.getChujiguanliPhone())
            .or()
            .eq("chujiguanli_id_number", chujiguanli.getChujiguanliIdNumber())
//            .notIn("chujiguanli_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChujiguanliEntity chujiguanliEntity = chujiguanliService.selectOne(queryWrapper);
        if(chujiguanliEntity==null){
            chujiguanli.setCreateTime(new Date());
        chujiguanli.setPassword("123456");
        chujiguanliService.insert(chujiguanli);

            return R.ok();
        }else {
            return R.error(511,"账户或者初级管理手机号或者初级管理身份证号已经被使用");
        }
    }

}

