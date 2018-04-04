package com.jhon.wx.service;

import com.github.pagehelper.Page;
import com.jhon.wx.entity.WechatUserDO;
import me.chanjar.weixin.mp.bean.result.WxMpUser;

import java.util.List;

/**
 * <p>功能描述</br> 微信粉丝接口 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatUserService
 * @date 2017/10/13 14:43
 */
public interface WechatUserService {
	/**
	 * <p>查询所有的记录</p>
	 *
	 * @return
	 */
	List<WechatUserDO> list();

	/**
	 * <p>分页查询记录</p>
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<WechatUserDO> findByPage(int pageNo,int pageSize);

	/**
	 * <p>通过openId查询微信粉丝信息</p>
	 *
	 * @param openId 微信openId
	 * @return
	 */
	WechatUserDO findByOpenId(String openId);

	/**
	 * <p>通过unionId查询记录</p>
	 *
	 * @param unionId 微信公众号unionId
	 * @return
	 */
	WechatUserDO findByUniionId(String unionId);

	/**
	 * <p>创建新的微信粉丝</p>
	 *
	 * @param wechatUser 微信粉丝实体
	 * @return
	 */
	int create(WechatUserDO wechatUser);

	/**
	 * <p>删除微信粉丝</p>
	 *
	 * @param id 记录的主键id
	 * @return
	 */
	int deleteById(Long id);

	/**
	 * <p>通过openId删除微信粉丝信息</p>
	 *
	 * @param openId 微信openid
	 * @return
	 */
	int deleteByOpenId(String openId);

	/**
	 * <p>更新用户信息</p>
	 *
	 * @param wxMpUser 微信用户信息
	 * @return
	 */
	WechatUserDO updateUserInfo(WxMpUser wxMpUser);
}
