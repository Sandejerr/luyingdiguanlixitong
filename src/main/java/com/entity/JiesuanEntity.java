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
 * 结算
 *
 * @author 
 * @email
 */
@TableName("jiesuan")
public class JiesuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiesuanEntity() {

	}

	public JiesuanEntity(T t) {
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
    @TableField(value = "jiedai_id")

    private Integer jiedaiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 结算名称
     */
    @ColumnInfo(comment="结算名称",type="varchar(200)")
    @TableField(value = "jiesuan_name")

    private String jiesuanName;


    /**
     * 结算编号
     */
    @ColumnInfo(comment="结算编号",type="varchar(200)")
    @TableField(value = "jiesuan_uuid_number")

    private String jiesuanUuidNumber;


    /**
     * 结算照片
     */
    @ColumnInfo(comment="结算照片",type="varchar(200)")
    @TableField(value = "jiesuan_photo")

    private String jiesuanPhoto;


    /**
     * 价格
     */
    @ColumnInfo(comment="价格",type="decimal(10,2)")
    @TableField(value = "jiesuan_new_money")

    private Double jiesuanNewMoney;


    /**
     * 结算状态
     */
    @ColumnInfo(comment="结算状态",type="int(11)")
    @TableField(value = "jiesuan_zhuangtai_types")

    private Integer jiesuanZhuangtaiTypes;


    /**
     * 备注
     */
    @ColumnInfo(comment="备注",type="text")
    @TableField(value = "jiesuan_content")

    private String jiesuanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiesuan_delete")

    private Integer jiesuanDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
    public Integer getJiedaiId() {
        return jiedaiId;
    }
    /**
	 * 设置：营地
	 */

    public void setJiedaiId(Integer jiedaiId) {
        this.jiedaiId = jiedaiId;
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
	 * 获取：结算名称
	 */
    public String getJiesuanName() {
        return jiesuanName;
    }
    /**
	 * 设置：结算名称
	 */

    public void setJiesuanName(String jiesuanName) {
        this.jiesuanName = jiesuanName;
    }
    /**
	 * 获取：结算编号
	 */
    public String getJiesuanUuidNumber() {
        return jiesuanUuidNumber;
    }
    /**
	 * 设置：结算编号
	 */

    public void setJiesuanUuidNumber(String jiesuanUuidNumber) {
        this.jiesuanUuidNumber = jiesuanUuidNumber;
    }
    /**
	 * 获取：结算照片
	 */
    public String getJiesuanPhoto() {
        return jiesuanPhoto;
    }
    /**
	 * 设置：结算照片
	 */

    public void setJiesuanPhoto(String jiesuanPhoto) {
        this.jiesuanPhoto = jiesuanPhoto;
    }
    /**
	 * 获取：价格
	 */
    public Double getJiesuanNewMoney() {
        return jiesuanNewMoney;
    }
    /**
	 * 设置：价格
	 */

    public void setJiesuanNewMoney(Double jiesuanNewMoney) {
        this.jiesuanNewMoney = jiesuanNewMoney;
    }
    /**
	 * 获取：结算状态
	 */
    public Integer getJiesuanZhuangtaiTypes() {
        return jiesuanZhuangtaiTypes;
    }
    /**
	 * 设置：结算状态
	 */

    public void setJiesuanZhuangtaiTypes(Integer jiesuanZhuangtaiTypes) {
        this.jiesuanZhuangtaiTypes = jiesuanZhuangtaiTypes;
    }
    /**
	 * 获取：备注
	 */
    public String getJiesuanContent() {
        return jiesuanContent;
    }
    /**
	 * 设置：备注
	 */

    public void setJiesuanContent(String jiesuanContent) {
        this.jiesuanContent = jiesuanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiesuanDelete() {
        return jiesuanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setJiesuanDelete(Integer jiesuanDelete) {
        this.jiesuanDelete = jiesuanDelete;
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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiesuan{" +
            ", id=" + id +
            ", jiedaiId=" + jiedaiId +
            ", yonghuId=" + yonghuId +
            ", jiesuanName=" + jiesuanName +
            ", jiesuanUuidNumber=" + jiesuanUuidNumber +
            ", jiesuanPhoto=" + jiesuanPhoto +
            ", jiesuanNewMoney=" + jiesuanNewMoney +
            ", jiesuanZhuangtaiTypes=" + jiesuanZhuangtaiTypes +
            ", jiesuanContent=" + jiesuanContent +
            ", jiesuanDelete=" + jiesuanDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
