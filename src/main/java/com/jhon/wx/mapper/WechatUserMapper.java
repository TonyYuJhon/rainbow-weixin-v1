package com.jhon.wx.mapper;

import com.jhon.wx.entity.WechatUserDO;

import java.util.List;

/**
 * <p>功能描述</br> 微信粉丝信息接口 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatUserMapper
 * @date 2017/10/13 11:20
 */
public interface WechatUserMapper {

	/**
	 * <p>查询所有微信粉丝记录</p>
	 *
	 * @return
	 */
	List<WechatUserDO> getAll();

	/**
	 * <p>创建微信粉丝信息</p>
	 *
	 * @param wechatUser 微信粉丝信息
	 * @return
	 */
	int createRecord(WechatUserDO wechatUser);

	/**
	 * <p>通过openId查询微信粉丝信息</p>
	 *
	 * @param openId 微信openId
	 * @return
	 */
	WechatUserDO findByOpenId(String openId);

	/**
	 * <p>通过UnionId查询微信粉丝信息</p>
	 *
	 * @param unionId 微信unionId
	 * @return
	 */
	WechatUserDO findByUnionId(String unionId);

	/**
	 * <p>通过openId删除记录</p>
	 *
	 * @param openId 微信粉丝Id
	 * @return
	 */
	int deleteByOpenId(String openId);

	/**
	 * <p>通过id删除记录</p>
	 *
	 * @param id 记录的Id
	 * @return
	 */
	int delete(Long id);

}
