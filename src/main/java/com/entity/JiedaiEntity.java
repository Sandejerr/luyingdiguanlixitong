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
 * 接待
 *
 * @author 
 * @email
 */
@TableName("jiedai")
public class JiedaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiedaiEntity() {

	}

	public JiedaiEntity(T t) {
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
     * 营地
     */
    @ColumnInfo(comment="营地",type="int(11)")
    @TableField(value = "yingdi_id")

    private Integer yingdiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 接待名称
     */
    @ColumnInfo(comment="接待名称",type="varchar(200)")
    @TableField(value = "jiedai_name")

    private String jiedaiName;


    /**
     * 接待编号
     */
    @ColumnInfo(comment="接待编号",type="varchar(200)")
    @TableField(value = "jiedai_uuid_number")

    private String jiedaiUuidNumber;


    /**
     * 接待照片
     */
    @ColumnInfo(comment="接待照片",type="varchar(200)")
    @TableField(value = "jiedai_photo")

    private String jiedaiPhoto;


    /**
     * 接待类型
     */
    @ColumnInfo(comment="接待类型",type="int(11)")
    @TableField(value = "jiedai_types")

    private Integer jiedaiTypes;


    /**
     * 价格
     */
    @ColumnInfo(comment="价格",type="decimal(10,2)")
    @TableField(value = "jiedai_new_money")

    private Double jiedaiNewMoney;


    /**
     * 接待状态
     */
    @ColumnInfo(comment="接待状态",type="int(11)")
    @TableField(value = "jiedai_zhuangtai_types")

    private Integer jiedaiZhuangtaiTypes;


    /**
     * 接待介绍
     */
    @ColumnInfo(comment="接待介绍",type="text")
    @TableField(value = "jiedai_content")

    private String jiedaiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiedai_delete")

    private Integer jiedaiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：营地
	 */
    public Integer getYingdiId() {
        return yingdiId;
    }
    /**
	 * 设置：营地
	 */

    public void setYingdiId(Integer yingdiId) {
        this.yingdiId = yingdiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：接待名称
	 */
    public String getJiedaiName() {
        return jiedaiName;
    }
    /**
	 * 设置：接待名称
	 */

    public void setJiedaiName(String jiedaiName) {
        this.jiedaiName = jiedaiName;
    }
    /**
	 * 获取：接待编号
	 */
    public String getJiedaiUuidNumber() {
        return jiedaiUuidNumber;
    }
    /**
	 * 设置：接待编号
	 */

    public void setJiedaiUuidNumber(String jiedaiUuidNumber) {
        this.jiedaiUuidNumber = jiedaiUuidNumber;
    }
    /**
	 * 获取：接待照片
	 */
    public String getJiedaiPhoto() {
        return jiedaiPhoto;
    }
    /**
	 * 设置：接待照片
	 */

    public void setJiedaiPhoto(String jiedaiPhoto) {
        this.jiedaiPhoto = jiedaiPhoto;
    }
    /**
	 * 获取：接待类型
	 */
    public Integer getJiedaiTypes() {
        return jiedaiTypes;
    }
    /**
	 * 设置：接待类型
	 */

    public void setJiedaiTypes(Integer jiedaiTypes) {
        this.jiedaiTypes = jiedaiTypes;
    }
    /**
	 * 获取：价格
	 */
    public Double getJiedaiNewMoney() {
        return jiedaiNewMoney;
    }
    /**
	 * 设置：价格
	 */

    public void setJiedaiNewMoney(Double jiedaiNewMoney) {
        this.jiedaiNewMoney = jiedaiNewMoney;
    }
    /**
	 * 获取：接待状态
	 */
    public Integer getJiedaiZhuangtaiTypes() {
        return jiedaiZhuangtaiTypes;
    }
    /**
	 * 设置：接待状态
	 */

    public void setJiedaiZhuangtaiTypes(Integer jiedaiZhuangtaiTypes) {
        this.jiedaiZhuangtaiTypes = jiedaiZhuangtaiTypes;
    }
    /**
	 * 获取：接待介绍
	 */
    public String getJiedaiContent() {
        return jiedaiContent;
    }
    /**
	 * 设置：接待介绍
	 */

    public void setJiedaiContent(String jiedaiContent) {
        this.jiedaiContent = jiedaiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiedaiDelete() {
        return jiedaiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiedaiDelete(Integer jiedaiDelete) {
        this.jiedaiDelete = jiedaiDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiedai{" +
            ", id=" + id +
            ", yingdiId=" + yingdiId +
            ", yonghuId=" + yonghuId +
            ", jiedaiName=" + jiedaiName +
            ", jiedaiUuidNumber=" + jiedaiUuidNumber +
            ", jiedaiPhoto=" + jiedaiPhoto +
            ", jiedaiTypes=" + jiedaiTypes +
            ", jiedaiNewMoney=" + jiedaiNewMoney +
            ", jiedaiZhuangtaiTypes=" + jiedaiZhuangtaiTypes +
            ", jiedaiContent=" + jiedaiContent +
            ", jiedaiDelete=" + jiedaiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
