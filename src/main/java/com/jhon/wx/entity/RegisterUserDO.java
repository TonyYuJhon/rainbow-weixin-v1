package com.jhon.wx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>功能描述</br> 注册用户信息 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName RegisterUserDO
 * @date 2017/10/13 12:07
 */
@Data
public class RegisterUserDO implements Serializable {

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 证件类型
	 */
	private String identifyType;

	/**
	 * 证件号
	 */
	private String identifyNum;

	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 地址
	 */
	private String address;
}
