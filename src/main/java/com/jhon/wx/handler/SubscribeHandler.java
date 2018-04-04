package com.jhon.wx.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jhon.wx.builder.TextBuilder;
import com.jhon.wx.entity.WechatUserDO;
import com.jhon.wx.service.WechatUserService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * <p>功能描述</br> 用户关注事件处理器 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName SubscribeHandler
 * @date 2017/10/12 22:53
 */
@Component
@Slf4j
public class SubscribeHandler extends AbstractHandler {

	@Autowired
	private WechatUserService wechatUserService;

	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context,
	                                WxMpService wxMpService, WxSessionManager sessionManager)
					throws WxErrorException {
		this.log.info("新关注用户 OPENID: " + wxMessage.getFromUser());

		// 获取微信用户基本信息
		WxMpUser userWxInfo = wxMpService.getUserService().userInfo(wxMessage.getFromUser(), null);

		if (userWxInfo != null) {
			WechatUserDO wechatUserDO = wechatUserService.updateUserInfo(userWxInfo);
			log.info("更新微信粉丝信息：{}",JSON.toJSONString(wechatUserDO, SerializerFeature.PrettyFormat));
		}
		WxMpXmlOutMessage responseResult = null;
		try {
			responseResult = handleSpecial(wxMessage);
		} catch (Exception e) {
			this.log.error(e.getMessage(), e);
		}

		if (responseResult != null) {
			return responseResult;
		}

		try {
			return new TextBuilder().build("感谢您关注小万服务家，骚年开始撸代码吧！", wxMessage, wxMpService);
		} catch (Exception e) {
			this.log.error(e.getMessage(), e);
		}

		return null;
	}

	/**
	 * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
	 */
	private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage)
					throws Exception {
		//TODO
		System.out.println("Special Process");
		return null;
	}
}
