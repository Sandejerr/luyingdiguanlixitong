package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiesuanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 结算
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiesuan")
public class JiesuanView extends JiesuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 结算状态的值
	*/
	@ColumnInfo(comment="结算状态的字典表值",type="varchar(200)")
	private String jiesuanZhuangtaiValue;

	//级联表 接待
										 
		/**
		* 接待 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer jiedaiYonghuId;
		/**
		* 接待名称
		*/

		@ColumnInfo(comment="接待名称",type="varchar(200)")
		private String jiedaiName;
		/**
		* 接待编号
		*/

		@ColumnInfo(comment="接待编号",type="varchar(200)")
		private String jiedaiUuidNumber;
		/**
		* 接待照片
		*/

		@ColumnInfo(comment="接待照片",type="varchar(200)")
		private String jiedaiPhoto;
		/**
		* 接待类型
		*/
		@ColumnInfo(comment="接待类型",type="int(11)")
		private Integer jiedaiTypes;
			/**
			* 接待类型的值
			*/
			@ColumnInfo(comment="接待类型的字典表值",type="varchar(200)")
			private String jiedaiValue;
		/**
		* 价格
		*/
		@ColumnInfo(comment="价格",type="decimal(10,2)")
		private Double jiedaiNewMoney;
		/**
		* 接待状态
		*/
		@ColumnInfo(comment="接待状态",type="int(11)")
		private Integer jiedaiZhuangtaiTypes;
			/**
			* 接待状态的值
			*/
			@ColumnInfo(comment="接待状态的字典表值",type="varchar(200)")
			private String jiedaiZhuangtaiValue;
		/**
		* 接待介绍
		*/

		@ColumnInfo(comment="接待介绍",type="text")
		private String jiedaiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jiedaiDelete;
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



	public JiesuanView() {

	}

	public JiesuanView(JiesuanEntity jiesuanEntity) {
		try {
			BeanUtils.copyProperties(this, jiesuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 结算状态的值
	*/
	public String getJiesuanZhuangtaiValue() {
		return jiesuanZhuangtaiValue;
	}
	/**
	* 设置： 结算状态的值
	*/
	public void setJiesuanZhuangtaiValue(String jiesuanZhuangtaiValue) {
		this.jiesuanZhuangtaiValue = jiesuanZhuangtaiValue;
	}


	//级联表的get和set 接待
		/**
		* 获取：接待 的 用户
		*/
		public Integer getJiedaiYonghuId() {
			return jiedaiYonghuId;
		}
		/**
		* 设置：接待 的 用户
		*/
		public void setJiedaiYonghuId(Integer jiedaiYonghuId) {
			this.jiedaiYonghuId = jiedaiYonghuId;
		}

		/**
		* 获取： 接待名称
		*/
		public String getJiedaiName() {
			return jiedaiName;
		}
		/**
		* 设置： 接待名称
		*/
		public void setJiedaiName(String jiedaiName) {
			this.jiedaiName = jiedaiName;
		}

		/**
		* 获取： 接待编号
		*/
		public String getJiedaiUuidNumber() {
			return jiedaiUuidNumber;
		}
		/**
		* 设置： 接待编号
		*/
		public void setJiedaiUuidNumber(String jiedaiUuidNumber) {
			this.jiedaiUuidNumber = jiedaiUuidNumber;
		}

		/**
		* 获取： 接待照片
		*/
		public String getJiedaiPhoto() {
			return jiedaiPhoto;
		}
		/**
		* 设置： 接待照片
		*/
		public void setJiedaiPhoto(String jiedaiPhoto) {
			this.jiedaiPhoto = jiedaiPhoto;
		}
		/**
		* 获取： 接待类型
		*/
		public Integer getJiedaiTypes() {
			return jiedaiTypes;
		}
		/**
		* 设置： 接待类型
		*/
		public void setJiedaiTypes(Integer jiedaiTypes) {
			this.jiedaiTypes = jiedaiTypes;
		}


			/**
			* 获取： 接待类型的值
			*/
			public String getJiedaiValue() {
				return jiedaiValue;
			}
			/**
			* 设置： 接待类型的值
			*/
			public void setJiedaiValue(String jiedaiValue) {
				this.jiedaiValue = jiedaiValue;
			}

		/**
		* 获取： 价格
		*/
		public Double getJiedaiNewMoney() {
			return jiedaiNewMoney;
		}
		/**
		* 设置： 价格
		*/
		public void setJiedaiNewMoney(Double jiedaiNewMoney) {
			this.jiedaiNewMoney = jiedaiNewMoney;
		}
		/**
		* 获取： 接待状态
		*/
		public Integer getJiedaiZhuangtaiTypes() {
			return jiedaiZhuangtaiTypes;
		}
		/**
		* 设置： 接待状态
		*/
		public void setJiedaiZhuangtaiTypes(Integer jiedaiZhuangtaiTypes) {
			this.jiedaiZhuangtaiTypes = jiedaiZhuangtaiTypes;
		}


			/**
			* 获取： 接待状态的值
			*/
			public String getJiedaiZhuangtaiValue() {
				return jiedaiZhuangtaiValue;
			}
			/**
			* 设置： 接待状态的值
			*/
			public void setJiedaiZhuangtaiValue(String jiedaiZhuangtaiValue) {
				this.jiedaiZhuangtaiValue = jiedaiZhuangtaiValue;
			}

		/**
		* 获取： 接待介绍
		*/
		public String getJiedaiContent() {
			return jiedaiContent;
		}
		/**
		* 设置： 接待介绍
		*/
		public void setJiedaiContent(String jiedaiContent) {
			this.jiedaiContent = jiedaiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJiedaiDelete() {
			return jiedaiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJiedaiDelete(Integer jiedaiDelete) {
			this.jiedaiDelete = jiedaiDelete;
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
		return "JiesuanView{" +
			", jiesuanZhuangtaiValue=" + jiesuanZhuangtaiValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", jiedaiName=" + jiedaiName +
			", jiedaiUuidNumber=" + jiedaiUuidNumber +
			", jiedaiPhoto=" + jiedaiPhoto +
			", jiedaiNewMoney=" + jiedaiNewMoney +
			", jiedaiContent=" + jiedaiContent +
			", jiedaiDelete=" + jiedaiDelete +
			"} " + super.toString();
	}
}
