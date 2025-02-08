package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 初级管理
 *
 * @author 
 * @email
 */
@TableName("chujiguanli")
public class ChujiguanliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChujiguanliEntity() {

	}

	public ChujiguanliEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 初级管理姓名
     */
    @ColumnInfo(comment="初级管理姓名",type="varchar(200)")
    @TableField(value = "chujiguanli_name")

    private String chujiguanliName;


    /**
     * 初级管理手机号
     */
    @ColumnInfo(comment="初级管理手机号",type="varchar(200)")
    @TableField(value = "chujiguanli_phone")

    private String chujiguanliPhone;


    /**
     * 初级管理身份证号
     */
    @ColumnInfo(comment="初级管理身份证号",type="varchar(200)")
    @TableField(value = "chujiguanli_id_number")

    private String chujiguanliIdNumber;


    /**
     * 初级管理头像
     */
    @ColumnInfo(comment="初级管理头像",type="varchar(200)")
    @TableField(value = "chujiguanli_photo")

    private String chujiguanliPhoto;


    /**
     * 性别
     */
    @ColumnInfo(comment="性别",type="int(11)")
    @TableField(value = "sex_types")

    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    @ColumnInfo(comment="电子邮箱",type="varchar(200)")
    @TableField(value = "chujiguanli_email")

    private String chujiguanliEmail;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "Chujiguanli{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", chujiguanliName=" + chujiguanliName +
            ", chujiguanliPhone=" + chujiguanliPhone +
            ", chujiguanliIdNumber=" + chujiguanliIdNumber +
            ", chujiguanliPhoto=" + chujiguanliPhoto +
            ", sexTypes=" + sexTypes +
            ", chujiguanliEmail=" + chujiguanliEmail +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
