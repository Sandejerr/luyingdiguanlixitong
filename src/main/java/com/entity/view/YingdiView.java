package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YingdiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 营地
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yingdi")
public class YingdiView extends YingdiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 营地类型的值
	*/
	@ColumnInfo(comment="营地类型的字典表值",type="varchar(200)")
	private String yingdiValue;
	/**
	* 营地状态的值
	*/
	@ColumnInfo(comment="营地状态的字典表值",type="varchar(200)")
	private String yingdiZhuangtaiValue;




	public YingdiView() {

	}

	public YingdiView(YingdiEntity yingdiEntity) {
		try {
			BeanUtils.copyProperties(this, yingdiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 营地类型的值
	*/
	public String getYingdiValue() {
		return yingdiValue;
	}
	/**
	* 设置： 营地类型的值
	*/
	public void setYingdiValue(String yingdiValue) {
		this.yingdiValue = yingdiValue;
	}
	//当前表的
	/**
	* 获取： 营地状态的值
	*/
	public String getYingdiZhuangtaiValue() {
		return yingdiZhuangtaiValue;
	}
	/**
	* 设置： 营地状态的值
	*/
	public void setYingdiZhuangtaiValue(String yingdiZhuangtaiValue) {
		this.yingdiZhuangtaiValue = yingdiZhuangtaiValue;
	}




	@Override
	public String toString() {
		return "YingdiView{" +
			", yingdiValue=" + yingdiValue +
			", yingdiZhuangtaiValue=" + yingdiZhuangtaiValue +
			"} " + super.toString();
	}
}
