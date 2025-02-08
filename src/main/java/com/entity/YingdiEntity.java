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
 * 营地
 *
 * @author 
 * @email
 */
@TableName("yingdi")
public class YingdiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YingdiEntity() {

	}

	public YingdiEntity(T t) {
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
     * 营地名称
     */
    @ColumnInfo(comment="营地名称",type="varchar(200)")
    @TableField(value = "yingdi_name")

    private String yingdiName;


    /**
     * 营地编号
     */
    @ColumnInfo(comment="营地编号",type="varchar(200)")
    @TableField(value = "yingdi_uuid_number")

    private String yingdiUuidNumber;


    /**
     * 营地照片
     */
    @ColumnInfo(comment="营地照片",type="varchar(200)")
    @TableField(value = "yingdi_photo")

    private String yingdiPhoto;


    /**
     * 营地地点
     */
    @ColumnInfo(comment="营地地点",type="varchar(200)")
    @TableField(value = "yingdi_address")

    private String yingdiAddress;


    /**
     * 营地类型
     */
    @ColumnInfo(comment="营地类型",type="int(11)")
    @TableField(value = "yingdi_types")

    private Integer yingdiTypes;


    /**
     * 价格
     */
    @ColumnInfo(comment="价格",type="decimal(10,2)")
    @TableField(value = "yingdi_new_money")

    private Double yingdiNewMoney;


    /**
     * 营地状态
     */
    @ColumnInfo(comment="营地状态",type="int(11)")
    @TableField(value = "yingdi_zhuangtai_types")

    private Integer yingdiZhuangtaiTypes;


    /**
     * 营地热度
     */
    @ColumnInfo(comment="营地热度",type="int(11)")
    @TableField(value = "yingdi_clicknum")

    private Integer yingdiClicknum;


    /**
     * 营地介绍
     */
    @ColumnInfo(comment="营地介绍",type="text")
    @TableField(value = "yingdi_content")

    private String yingdiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "yingdi_delete")

    private Integer yingdiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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
	 * 获取：营地名称
	 */
    public String getYingdiName() {
        return yingdiName;
    }
    /**
	 * 设置：营地名称
	 */

    public void setYingdiName(String yingdiName) {
        this.yingdiName = yingdiName;
    }
    /**
	 * 获取：营地编号
	 */
    public String getYingdiUuidNumber() {
        return yingdiUuidNumber;
    }
    /**
	 * 设置：营地编号
	 */

    public void setYingdiUuidNumber(String yingdiUuidNumber) {
        this.yingdiUuidNumber = yingdiUuidNumber;
    }
    /**
	 * 获取：营地照片
	 */
    public String getYingdiPhoto() {
        return yingdiPhoto;
    }
    /**
	 * 设置：营地照片
	 */

    public void setYingdiPhoto(String yingdiPhoto) {
        this.yingdiPhoto = yingdiPhoto;
    }
    /**
	 * 获取：营地地点
	 */
    public String getYingdiAddress() {
        return yingdiAddress;
    }
    /**
	 * 设置：营地地点
	 */

    public void setYingdiAddress(String yingdiAddress) {
        this.yingdiAddress = yingdiAddress;
    }
    /**
	 * 获取：营地类型
	 */
    public Integer getYingdiTypes() {
        return yingdiTypes;
    }
    /**
	 * 设置：营地类型
	 */

    public void setYingdiTypes(Integer yingdiTypes) {
        this.yingdiTypes = yingdiTypes;
    }
    /**
	 * 获取：价格
	 */
    public Double getYingdiNewMoney() {
        return yingdiNewMoney;
    }
    /**
	 * 设置：价格
	 */

    public void setYingdiNewMoney(Double yingdiNewMoney) {
        this.yingdiNewMoney = yingdiNewMoney;
    }
    /**
	 * 获取：营地状态
	 */
    public Integer getYingdiZhuangtaiTypes() {
        return yingdiZhuangtaiTypes;
    }
    /**
	 * 设置：营地状态
	 */

    public void setYingdiZhuangtaiTypes(Integer yingdiZhuangtaiTypes) {
        this.yingdiZhuangtaiTypes = yingdiZhuangtaiTypes;
    }
    /**
	 * 获取：营地热度
	 */
    public Integer getYingdiClicknum() {
        return yingdiClicknum;
    }
    /**
	 * 设置：营地热度
	 */

    public void setYingdiClicknum(Integer yingdiClicknum) {
        this.yingdiClicknum = yingdiClicknum;
    }
    /**
	 * 获取：营地介绍
	 */
    public String getYingdiContent() {
        return yingdiContent;
    }
    /**
	 * 设置：营地介绍
	 */

    public void setYingdiContent(String yingdiContent) {
        this.yingdiContent = yingdiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYingdiDelete() {
        return yingdiDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setYingdiDelete(Integer yingdiDelete) {
        this.yingdiDelete = yingdiDelete;
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
        return "Yingdi{" +
            ", id=" + id +
            ", yingdiName=" + yingdiName +
            ", yingdiUuidNumber=" + yingdiUuidNumber +
            ", yingdiPhoto=" + yingdiPhoto +
            ", yingdiAddress=" + yingdiAddress +
            ", yingdiTypes=" + yingdiTypes +
            ", yingdiNewMoney=" + yingdiNewMoney +
            ", yingdiZhuangtaiTypes=" + yingdiZhuangtaiTypes +
            ", yingdiClicknum=" + yingdiClicknum +
            ", yingdiContent=" + yingdiContent +
            ", yingdiDelete=" + yingdiDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
