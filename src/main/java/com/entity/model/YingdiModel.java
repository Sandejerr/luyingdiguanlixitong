package com.entity.model;

import com.entity.YingdiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 营地
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YingdiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 营地名称
     */
    private String yingdiName;


    /**
     * 营地编号
     */
    private String yingdiUuidNumber;


    /**
     * 营地照片
     */
    private String yingdiPhoto;


    /**
     * 营地地点
     */
    private String yingdiAddress;


    /**
     * 营地类型
     */
    private Integer yingdiTypes;


    /**
     * 价格
     */
    private Double yingdiNewMoney;


    /**
     * 营地状态
     */
    private Integer yingdiZhuangtaiTypes;


    /**
     * 营地热度
     */
    private Integer yingdiClicknum;


    /**
     * 营地介绍
     */
    private String yingdiContent;


    /**
     * 逻辑删除
     */
    private Integer yingdiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
