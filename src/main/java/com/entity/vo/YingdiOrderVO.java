package com.entity.vo;

import com.entity.YingdiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 营地预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yingdi_order")
public class YingdiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 营地
     */

    @TableField(value = "yingdi_id")
    private Integer yingdiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yingdi_order_time")
    private Date yingdiOrderTime;


    /**
     * 实付价格
     */

    @TableField(value = "yingdi_order_true_price")
    private Double yingdiOrderTruePrice;


    /**
     * 营地类型
     */

    @TableField(value = "yingdi_order_types")
    private Integer yingdiOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 设置：营地
	 */
    public Integer getYingdiId() {
        return yingdiId;
    }


    /**
	 * 获取：营地
	 */

    public void setYingdiId(Integer yingdiId) {
        this.yingdiId = yingdiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getYingdiOrderTime() {
        return yingdiOrderTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setYingdiOrderTime(Date yingdiOrderTime) {
        this.yingdiOrderTime = yingdiOrderTime;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getYingdiOrderTruePrice() {
        return yingdiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setYingdiOrderTruePrice(Double yingdiOrderTruePrice) {
        this.yingdiOrderTruePrice = yingdiOrderTruePrice;
    }
    /**
	 * 设置：营地类型
	 */
    public Integer getYingdiOrderTypes() {
        return yingdiOrderTypes;
    }


    /**
	 * 获取：营地类型
	 */

    public void setYingdiOrderTypes(Integer yingdiOrderTypes) {
        this.yingdiOrderTypes = yingdiOrderTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
