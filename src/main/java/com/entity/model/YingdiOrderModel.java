package com.entity.model;

import com.entity.YingdiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 营地预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YingdiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 营地
     */
    private Integer yingdiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yingdiOrderTime;


    /**
     * 实付价格
     */
    private Double yingdiOrderTruePrice;


    /**
     * 营地类型
     */
    private Integer yingdiOrderTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
