package com.entity.model;

import com.entity.JiedaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 接待
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiedaiModel implements Serializable {
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
     * 接待名称
     */
    private String jiedaiName;


    /**
     * 接待编号
     */
    private String jiedaiUuidNumber;


    /**
     * 接待照片
     */
    private String jiedaiPhoto;


    /**
     * 接待类型
     */
    private Integer jiedaiTypes;


    /**
     * 价格
     */
    private Double jiedaiNewMoney;


    /**
     * 接待状态
     */
    private Integer jiedaiZhuangtaiTypes;


    /**
     * 接待介绍
     */
    private String jiedaiContent;


    /**
     * 逻辑删除
     */
    private Integer jiedaiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
