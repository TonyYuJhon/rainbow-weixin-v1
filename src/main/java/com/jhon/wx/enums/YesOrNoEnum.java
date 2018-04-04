package com.jhon.wx.enums;

import lombok.Getter;

/**
 * <p>功能描述</br> 是，否的枚举 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName YesOrNoEnum
 * @date 2017/10/13 10:47
 */
@Getter
public enum YesOrNoEnum {
	NO(0, "否"),
	YES(1, "是");

	/**
	 * 值
	 */
	private Integer value;
	/**
	 * 描述
	 */
	private String text;


	private YesOrNoEnum(Integer value, String text) {
		this.value = value;
		this.text = text;
	}
}
