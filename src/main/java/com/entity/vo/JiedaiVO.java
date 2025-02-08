package com.entity.vo;

import com.entity.JiedaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 接待
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiedai")
public class JiedaiVO implements Serializable {
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
     * 接待名称
     */

    @TableField(value = "jiedai_name")
    private String jiedaiName;


    /**
     * 接待编号
     */

    @TableField(value = "jiedai_uuid_number")
    private String jiedaiUuidNumber;


    /**
     * 接待照片
     */

    @TableField(value = "jiedai_photo")
    private String jiedaiPhoto;


    /**
     * 接待类型
     */

    @TableField(value = "jiedai_types")
    private Integer jiedaiTypes;


    /**
     * 价格
     */

    @TableField(value = "jiedai_new_money")
    private Double jiedaiNewMoney;


    /**
     * 接待状态
     */

    @TableField(value = "jiedai_zhuangtai_types")
    private Integer jiedaiZhuangtaiTypes;


    /**
     * 接待介绍
     */

    @TableField(value = "jiedai_content")
    private String jiedaiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiedai_delete")
    private Integer jiedaiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：接待名称
	 */
    public String getJiedaiName() {
        return jiedaiName;
    }


    /**
	 * 获取：接待名称
	 */

    public void setJiedaiName(String jiedaiName) {
        this.jiedaiName = jiedaiName;
    }
    /**
	 * 设置：接待编号
	 */
    public String getJiedaiUuidNumber() {
        return jiedaiUuidNumber;
    }


    /**
	 * 获取：接待编号
	 */

    public void setJiedaiUuidNumber(String jiedaiUuidNumber) {
        this.jiedaiUuidNumber = jiedaiUuidNumber;
    }
    /**
	 * 设置：接待照片
	 */
    public String getJiedaiPhoto() {
        return jiedaiPhoto;
    }


    /**
	 * 获取：接待照片
	 */

    public void setJiedaiPhoto(String jiedaiPhoto) {
        this.jiedaiPhoto = jiedaiPhoto;
    }
    /**
	 * 设置：接待类型
	 */
    public Integer getJiedaiTypes() {
        return jiedaiTypes;
    }


    /**
	 * 获取：接待类型
	 */

    public void setJiedaiTypes(Integer jiedaiTypes) {
        this.jiedaiTypes = jiedaiTypes;
    }
    /**
	 * 设置：价格
	 */
    public Double getJiedaiNewMoney() {
        return jiedaiNewMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setJiedaiNewMoney(Double jiedaiNewMoney) {
        this.jiedaiNewMoney = jiedaiNewMoney;
    }
    /**
	 * 设置：接待状态
	 */
    public Integer getJiedaiZhuangtaiTypes() {
        return jiedaiZhuangtaiTypes;
    }


    /**
	 * 获取：接待状态
	 */

    public void setJiedaiZhuangtaiTypes(Integer jiedaiZhuangtaiTypes) {
        this.jiedaiZhuangtaiTypes = jiedaiZhuangtaiTypes;
    }
    /**
	 * 设置：接待介绍
	 */
    public String getJiedaiContent() {
        return jiedaiContent;
    }


    /**
	 * 获取：接待介绍
	 */

    public void setJiedaiContent(String jiedaiContent) {
        this.jiedaiContent = jiedaiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiedaiDelete() {
        return jiedaiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiedaiDelete(Integer jiedaiDelete) {
        this.jiedaiDelete = jiedaiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
