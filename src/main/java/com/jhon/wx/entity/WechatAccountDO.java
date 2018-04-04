package com.jhon.wx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>功能描述</br> 微信公众号 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatAccountDO
 * @date 2017/10/13 10:57
 */
@Data
public class WechatAccountDO implements Serializable {

	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * appId
	 */
	private String appId;

	/**
	 * 原始Id
	 */
	private String sourceId;

}
