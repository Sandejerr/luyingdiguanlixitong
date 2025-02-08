package com.entity.model;

import com.entity.JiesuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 结算
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiesuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 营地
     */
    private Integer jiedaiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 结算名称
     */
    private String jiesuanName;


    /**
     * 结算编号
     */
    private String jiesuanUuidNumber;


    /**
     * 结算照片
     */
    private String jiesuanPhoto;


    /**
     * 价格
     */
    private Double jiesuanNewMoney;


    /**
     * 结算状态
     */
    private Integer jiesuanZhuangtaiTypes;


    /**
     * 备注
     */
    private String jiesuanContent;


    /**
     * 逻辑删除
     */
    private Integer jiesuanDelete;


    /**
     * 录入时间
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
