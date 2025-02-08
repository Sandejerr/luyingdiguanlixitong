package com.entity.model;

import com.entity.ChujiguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 初级管理
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChujiguanliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 初级管理姓名
     */
    private String chujiguanliName;


    /**
     * 初级管理手机号
     */
    private String chujiguanliPhone;


    /**
     * 初级管理身份证号
     */
    private String chujiguanliIdNumber;


    /**
     * 初级管理头像
     */
    private String chujiguanliPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String chujiguanliEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：初级管理姓名
	 */
    public String getChujiguanliName() {
        return chujiguanliName;
    }


    /**
	 * 设置：初级管理姓名
	 */
    public void setChujiguanliName(String chujiguanliName) {
        this.chujiguanliName = chujiguanliName;
    }
    /**
	 * 获取：初级管理手机号
	 */
    public String getChujiguanliPhone() {
        return chujiguanliPhone;
    }


    /**
	 * 设置：初级管理手机号
	 */
    public void setChujiguanliPhone(String chujiguanliPhone) {
        this.chujiguanliPhone = chujiguanliPhone;
    }
    /**
	 * 获取：初级管理身份证号
	 */
    public String getChujiguanliIdNumber() {
        return chujiguanliIdNumber;
    }


    /**
	 * 设置：初级管理身份证号
	 */
    public void setChujiguanliIdNumber(String chujiguanliIdNumber) {
        this.chujiguanliIdNumber = chujiguanliIdNumber;
    }
    /**
	 * 获取：初级管理头像
	 */
    public String getChujiguanliPhoto() {
        return chujiguanliPhoto;
    }


    /**
	 * 设置：初级管理头像
	 */
    public void setChujiguanliPhoto(String chujiguanliPhoto) {
        this.chujiguanliPhoto = chujiguanliPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getChujiguanliEmail() {
        return chujiguanliEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setChujiguanliEmail(String chujiguanliEmail) {
        this.chujiguanliEmail = chujiguanliEmail;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
