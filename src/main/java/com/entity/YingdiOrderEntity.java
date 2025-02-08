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
 * 营地预约
 *
 * @author 
 * @email
 */
@TableName("yingdi_order")
public class YingdiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YingdiOrderEntity() {

	}

	public YingdiOrderEntity(T t) {
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
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "yingdi_order_time")

    private Date yingdiOrderTime;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "yingdi_order_true_price")

    private Double yingdiOrderTruePrice;


    /**
     * 营地类型
     */
    @ColumnInfo(comment="营地类型",type="int(11)")
    @TableField(value = "yingdi_order_types")

    private Integer yingdiOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
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
	 * 获取：预约时间
	 */
    public Date getYingdiOrderTime() {
        return yingdiOrderTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setYingdiOrderTime(Date yingdiOrderTime) {
        this.yingdiOrderTime = yingdiOrderTime;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getYingdiOrderTruePrice() {
        return yingdiOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setYingdiOrderTruePrice(Double yingdiOrderTruePrice) {
        this.yingdiOrderTruePrice = yingdiOrderTruePrice;
    }
    /**
	 * 获取：营地类型
	 */
    public Integer getYingdiOrderTypes() {
        return yingdiOrderTypes;
    }
    /**
	 * 设置：营地类型
	 */

    public void setYingdiOrderTypes(Integer yingdiOrderTypes) {
        this.yingdiOrderTypes = yingdiOrderTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
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
        return "YingdiOrder{" +
            ", id=" + id +
            ", yingdiId=" + yingdiId +
            ", yonghuId=" + yonghuId +
            ", yingdiOrderTime=" + DateUtil.convertString(yingdiOrderTime,"yyyy-MM-dd") +
            ", yingdiOrderTruePrice=" + yingdiOrderTruePrice +
            ", yingdiOrderTypes=" + yingdiOrderTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
