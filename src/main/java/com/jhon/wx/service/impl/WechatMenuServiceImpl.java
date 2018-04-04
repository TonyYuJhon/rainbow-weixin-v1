package com.jhon.wx.service.impl;

import com.jhon.wx.service.WechatMenuService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMenuService;
import me.chanjar.weixin.mp.bean.menu.WxMpGetSelfMenuInfoResult;
import me.chanjar.weixin.mp.bean.menu.WxMpMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>功能描述</br> 微信菜单业务逻辑实现类 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatMenuServiceImpl
 * @date 2017/10/13 8:40
 */
@Service
@Slf4j
public class WechatMenuServiceImpl implements WechatMenuService {

	@Autowired
	private WxMpMenuService wxMpMenuService;

	@Override
	public String menuCreate(WxMenu menu) {
		String menuId = null;
		try {
			menuId = wxMpMenuService.menuCreate(menu);
		} catch (WxErrorException e) {
			log.error("【生成菜单失败MenuId】{}", menuId);
			e.printStackTrace();
		}
		return menuId;
	}

	@Override
	public String menuCreate(String json) {
		String menuId = "";
		try {
			menuId = wxMpMenuService.menuCreate(json);
		} catch (WxErrorException e) {
			log.error("【生成菜单失败MenuId】{}", menuId);
			e.printStackTrace();
		}
		return menuId;
	}

	@Override
	public void menuDelete() {
		try {
			wxMpMenuService.menuDelete();
		} catch (WxErrorException e) {
			log.error("【删除所有菜单失败】");
			e.printStackTrace();
		}
	}

	@Override
	public void menuDelete(String menuId) {
		try {
			wxMpMenuService.menuDelete(menuId);
		} catch (WxErrorException e) {
			log.error("【删除所有菜单失败MenuId】{}", menuId);
			e.printStackTrace();
		}
	}

	@Override
	public WxMpMenu menuGet() {
		WxMpMenu wxMpMenu = null;
		try {
			wxMpMenu = wxMpMenuService.menuGet();
		} catch (WxErrorException e) {
			log.error("【获取所有的菜单】");
			e.printStackTrace();
		}
		return wxMpMenu;
	}

	@Override
	public WxMenu menuTryMatch(String userId) {
		WxMenu wxMenu = null;
		try {
			wxMenu = wxMpMenuService.menuTryMatch(userId);
		} catch (WxErrorException e) {
			log.error("【测试个性化菜单匹配结果失败】");
			e.printStackTrace();
		}
		return wxMenu;
	}

	@Override
	public WxMpGetSelfMenuInfoResult getSelfMenuInfo() {
		WxMpGetSelfMenuInfoResult selfMenuInfoResult = null;
		try {
			selfMenuInfoResult = wxMpMenuService.getSelfMenuInfo();
		} catch (WxErrorException e) {
			log.error("【获取自定义菜单配置接口失败】");
			e.printStackTrace();
		}
		return selfMenuInfoResult;
	}
}
