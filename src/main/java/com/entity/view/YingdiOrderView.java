package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YingdiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 营地预约
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yingdi_order")
public class YingdiOrderView extends YingdiOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 营地类型的值
	*/
	@ColumnInfo(comment="营地类型的字典表值",type="varchar(200)")
	private String yingdiOrderValue;

	//级联表 营地
		/**
		* 营地名称
		*/

		@ColumnInfo(comment="营地名称",type="varchar(200)")
		private String yingdiName;
		/**
		* 营地编号
		*/

		@ColumnInfo(comment="营地编号",type="varchar(200)")
		private String yingdiUuidNumber;
		/**
		* 营地照片
		*/

		@ColumnInfo(comment="营地照片",type="varchar(200)")
		private String yingdiPhoto;
		/**
		* 营地地点
		*/

		@ColumnInfo(comment="营地地点",type="varchar(200)")
		private String yingdiAddress;
		/**
		* 营地类型
		*/
		@ColumnInfo(comment="营地类型",type="int(11)")
		private Integer yingdiTypes;
			/**
			* 营地类型的值
			*/
			@ColumnInfo(comment="营地类型的字典表值",type="varchar(200)")
			private String yingdiValue;
		/**
		* 价格
		*/
		@ColumnInfo(comment="价格",type="decimal(10,2)")
		private Double yingdiNewMoney;
		/**
		* 营地状态
		*/
		@ColumnInfo(comment="营地状态",type="int(11)")
		private Integer yingdiZhuangtaiTypes;
			/**
			* 营地状态的值
			*/
			@ColumnInfo(comment="营地状态的字典表值",type="varchar(200)")
			private String yingdiZhuangtaiValue;
		/**
		* 营地热度
		*/

		@ColumnInfo(comment="营地热度",type="int(11)")
		private Integer yingdiClicknum;
		/**
		* 营地介绍
		*/

		@ColumnInfo(comment="营地介绍",type="text")
		private String yingdiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yingdiDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;



	public YingdiOrderView() {

	}

	public YingdiOrderView(YingdiOrderEntity yingdiOrderEntity) {
		try {
			BeanUtils.copyProperties(this, yingdiOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 营地类型的值
	*/
	public String getYingdiOrderValue() {
		return yingdiOrderValue;
	}
	/**
	* 设置： 营地类型的值
	*/
	public void setYingdiOrderValue(String yingdiOrderValue) {
		this.yingdiOrderValue = yingdiOrderValue;
	}


	//级联表的get和set 营地

		/**
		* 获取： 营地名称
		*/
		public String getYingdiName() {
			return yingdiName;
		}
		/**
		* 设置： 营地名称
		*/
		public void setYingdiName(String yingdiName) {
			this.yingdiName = yingdiName;
		}

		/**
		* 获取： 营地编号
		*/
		public String getYingdiUuidNumber() {
			return yingdiUuidNumber;
		}
		/**
		* 设置： 营地编号
		*/
		public void setYingdiUuidNumber(String yingdiUuidNumber) {
			this.yingdiUuidNumber = yingdiUuidNumber;
		}

		/**
		* 获取： 营地照片
		*/
		public String getYingdiPhoto() {
			return yingdiPhoto;
		}
		/**
		* 设置： 营地照片
		*/
		public void setYingdiPhoto(String yingdiPhoto) {
			this.yingdiPhoto = yingdiPhoto;
		}

		/**
		* 获取： 营地地点
		*/
		public String getYingdiAddress() {
			return yingdiAddress;
		}
		/**
		* 设置： 营地地点
		*/
		public void setYingdiAddress(String yingdiAddress) {
			this.yingdiAddress = yingdiAddress;
		}
		/**
		* 获取： 营地类型
		*/
		public Integer getYingdiTypes() {
			return yingdiTypes;
		}
		/**
		* 设置： 营地类型
		*/
		public void setYingdiTypes(Integer yingdiTypes) {
			this.yingdiTypes = yingdiTypes;
		}


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

		/**
		* 获取： 价格
		*/
		public Double getYingdiNewMoney() {
			return yingdiNewMoney;
		}
		/**
		* 设置： 价格
		*/
		public void setYingdiNewMoney(Double yingdiNewMoney) {
			this.yingdiNewMoney = yingdiNewMoney;
		}
		/**
		* 获取： 营地状态
		*/
		public Integer getYingdiZhuangtaiTypes() {
			return yingdiZhuangtaiTypes;
		}
		/**
		* 设置： 营地状态
		*/
		public void setYingdiZhuangtaiTypes(Integer yingdiZhuangtaiTypes) {
			this.yingdiZhuangtaiTypes = yingdiZhuangtaiTypes;
		}


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

		/**
		* 获取： 营地热度
		*/
		public Integer getYingdiClicknum() {
			return yingdiClicknum;
		}
		/**
		* 设置： 营地热度
		*/
		public void setYingdiClicknum(Integer yingdiClicknum) {
			this.yingdiClicknum = yingdiClicknum;
		}

		/**
		* 获取： 营地介绍
		*/
		public String getYingdiContent() {
			return yingdiContent;
		}
		/**
		* 设置： 营地介绍
		*/
		public void setYingdiContent(String yingdiContent) {
			this.yingdiContent = yingdiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYingdiDelete() {
			return yingdiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYingdiDelete(Integer yingdiDelete) {
			this.yingdiDelete = yingdiDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}


	@Override
	public String toString() {
		return "YingdiOrderView{" +
			", yingdiOrderValue=" + yingdiOrderValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yingdiName=" + yingdiName +
			", yingdiUuidNumber=" + yingdiUuidNumber +
			", yingdiPhoto=" + yingdiPhoto +
			", yingdiAddress=" + yingdiAddress +
			", yingdiNewMoney=" + yingdiNewMoney +
			", yingdiClicknum=" + yingdiClicknum +
			", yingdiContent=" + yingdiContent +
			", yingdiDelete=" + yingdiDelete +
			"} " + super.toString();
	}
}
