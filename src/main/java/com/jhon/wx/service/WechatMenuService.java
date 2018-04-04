package com.jhon.wx.service;

import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.mp.bean.menu.WxMpGetSelfMenuInfoResult;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;

/**
 * <p>功能描述</br> 微信菜单业务逻辑接口 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatMenuService
 * @date 2017/10/13 8:39
 */
public interface WechatMenuService {

	/**
	 * 创建菜单
	 *
	 * @param menu
	 * @return
	 */
	String menuCreate(WxMenu menu);

	/**
	 * 创建菜单
	 *
	 * @param json
	 * @return
	 */
	String menuCreate(String json);

	/**
	 * 删除全部自定义菜单
	 */
	void menuDelete();

	/**
	 * 删除指定的菜单
	 *
	 * @param menuId
	 */
	void menuDelete(String menuId);

	/**
	 * 获取到所有的菜单
	 *
	 * @return
	 */
	WxMpMenu menuGet();

	/**
	 * 匹配菜单
	 *
	 * @param userid 可以是openId 或者是 微信号
	 * @return
	 */
	WxMenu menuTryMatch(String userid);

	/**
	 *  获取自定义菜单配置接口
	 * @return
	 */
	WxMpGetSelfMenuInfoResult getSelfMenuInfo();
}
