package com.jhon.wx.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>功能描述</br> 微信粉丝信息 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatUserDO
 * @date 2017/10/13 10:52
 */
@Data
public class WechatUserDO implements Serializable {

	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 是否关注
	 */
	private Boolean subscribe;

	/**
	 * 微信openId
	 */
	private String openId;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 性别
	 */
	private String sex;

	/**
	 * 用户的语言，简体中文为zh_CN
	 */
	private String language;

	/**
	 * 用户所在城市
	 */
	private String city;

	/**
	 * 用户所在省份
	 */
	private String province;

	/**
	 * 用户所在国家
	 */
	private String country;

	/**
	 * 用户头像
	 */
	private String headImgUrl;

	/**
	 * 用户关注时间，为时间戳
	 */
	private Date subscribeTime;

	/**
	 * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
	 */
	private String unionId;

	/**
	 * 公众号运营者对粉丝的备注
	 */
	private String remark;

	/**
	 * 用户所在的分组ID
	 */
	private Integer groupId;

	/**
	 * 用户被打上的标签ID列表
	 */
	private String tagIds;

	/**
	 * 注册用户id
	 */
	private Long registerUserId;

	/**
	 * 微信公众号Id
	 */
	private Long wechatAccountId;
}
