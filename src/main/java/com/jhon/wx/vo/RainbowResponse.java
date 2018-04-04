package com.jhon.wx.vo;

import lombok.Data;

/**
 * <p>功能描述</br> 统一返回对象规定 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName RainbowResponse
 * @date 2017/10/13 9:49
 */
@Data
public class RainbowResponse {

	/**
	 * 编码（返回码）
	 */
	private String code;
	/**
	 * 简单信息
	 */
	private String msg;

	/**
	 * 详细描述信息
	 */
	private String description;

	/**
	 * 详细信息
	 */
	private Object data;


}
