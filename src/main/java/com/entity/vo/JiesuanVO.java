package com.entity.vo;

import com.entity.JiesuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 结算
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiesuan")
public class JiesuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 营地
     */

    @TableField(value = "jiedai_id")
    private Integer jiedaiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 结算名称
     */

    @TableField(value = "jiesuan_name")
    private String jiesuanName;


    /**
     * 结算编号
     */

    @TableField(value = "jiesuan_uuid_number")
    private String jiesuanUuidNumber;


    /**
     * 结算照片
     */

    @TableField(value = "jiesuan_photo")
    private String jiesuanPhoto;


    /**
     * 价格
     */

    @TableField(value = "jiesuan_new_money")
    private Double jiesuanNewMoney;


    /**
     * 结算状态
     */

    @TableField(value = "jiesuan_zhuangtai_types")
    private Integer jiesuanZhuangtaiTypes;


    /**
     * 备注
     */

    @TableField(value = "jiesuan_content")
    private String jiesuanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiesuan_delete")
    private Integer jiesuanDelete;


    /**
     * 录入时间
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
    public Integer getJiedaiId() {
        return jiedaiId;
    }


    /**
	 * 获取：营地
	 */

    public void setJiedaiId(Integer jiedaiId) {
        this.jiedaiId = jiedaiId;
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
	 * 设置：结算名称
	 */
    public String getJiesuanName() {
        return jiesuanName;
    }


    /**
	 * 获取：结算名称
	 */

    public void setJiesuanName(String jiesuanName) {
        this.jiesuanName = jiesuanName;
    }
    /**
	 * 设置：结算编号
	 */
    public String getJiesuanUuidNumber() {
        return jiesuanUuidNumber;
    }


    /**
	 * 获取：结算编号
	 */

    public void setJiesuanUuidNumber(String jiesuanUuidNumber) {
        this.jiesuanUuidNumber = jiesuanUuidNumber;
    }
    /**
	 * 设置：结算照片
	 */
    public String getJiesuanPhoto() {
        return jiesuanPhoto;
    }


    /**
	 * 获取：结算照片
	 */

    public void setJiesuanPhoto(String jiesuanPhoto) {
        this.jiesuanPhoto = jiesuanPhoto;
    }
    /**
	 * 设置：价格
	 */
    public Double getJiesuanNewMoney() {
        return jiesuanNewMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setJiesuanNewMoney(Double jiesuanNewMoney) {
        this.jiesuanNewMoney = jiesuanNewMoney;
    }
    /**
	 * 设置：结算状态
	 */
    public Integer getJiesuanZhuangtaiTypes() {
        return jiesuanZhuangtaiTypes;
    }


    /**
	 * 获取：结算状态
	 */

    public void setJiesuanZhuangtaiTypes(Integer jiesuanZhuangtaiTypes) {
        this.jiesuanZhuangtaiTypes = jiesuanZhuangtaiTypes;
    }
    /**
	 * 设置：备注
	 */
    public String getJiesuanContent() {
        return jiesuanContent;
    }


    /**
	 * 获取：备注
	 */

    public void setJiesuanContent(String jiesuanContent) {
        this.jiesuanContent = jiesuanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiesuanDelete() {
        return jiesuanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiesuanDelete(Integer jiesuanDelete) {
        this.jiesuanDelete = jiesuanDelete;
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
