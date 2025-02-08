package com.entity.vo;

import com.entity.ChujiguanliEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 初级管理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chujiguanli")
public class ChujiguanliVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 初级管理姓名
     */

    @TableField(value = "chujiguanli_name")
    private String chujiguanliName;


    /**
     * 初级管理手机号
     */

    @TableField(value = "chujiguanli_phone")
    private String chujiguanliPhone;


    /**
     * 初级管理身份证号
     */

    @TableField(value = "chujiguanli_id_number")
    private String chujiguanliIdNumber;


    /**
     * 初级管理头像
     */

    @TableField(value = "chujiguanli_photo")
    private String chujiguanliPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "chujiguanli_email")
    private String chujiguanliEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：初级管理姓名
	 */
    public String getChujiguanliName() {
        return chujiguanliName;
    }


    /**
	 * 获取：初级管理姓名
	 */

    public void setChujiguanliName(String chujiguanliName) {
        this.chujiguanliName = chujiguanliName;
    }
    /**
	 * 设置：初级管理手机号
	 */
    public String getChujiguanliPhone() {
        return chujiguanliPhone;
    }


    /**
	 * 获取：初级管理手机号
	 */

    public void setChujiguanliPhone(String chujiguanliPhone) {
        this.chujiguanliPhone = chujiguanliPhone;
    }
    /**
	 * 设置：初级管理身份证号
	 */
    public String getChujiguanliIdNumber() {
        return chujiguanliIdNumber;
    }


    /**
	 * 获取：初级管理身份证号
	 */

    public void setChujiguanliIdNumber(String chujiguanliIdNumber) {
        this.chujiguanliIdNumber = chujiguanliIdNumber;
    }
    /**
	 * 设置：初级管理头像
	 */
    public String getChujiguanliPhoto() {
        return chujiguanliPhoto;
    }


    /**
	 * 获取：初级管理头像
	 */

    public void setChujiguanliPhoto(String chujiguanliPhoto) {
        this.chujiguanliPhoto = chujiguanliPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getChujiguanliEmail() {
        return chujiguanliEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setChujiguanliEmail(String chujiguanliEmail) {
        this.chujiguanliEmail = chujiguanliEmail;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
