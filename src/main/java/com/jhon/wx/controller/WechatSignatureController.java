package com.jhon.wx.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>功能描述</br> 微信服务器签名认证控制器 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatSignatureController
 * @date 2017/10/12 22:36
 */
@RestController
@RequestMapping("/signature")
@Slf4j
public class WechatSignatureController {

	@Autowired
	private WxMpService wxMpService;

	@Autowired
	private WxMpMessageRouter router;

	@GetMapping(produces = "text/plain;charset=utf-8")
	public String authGet(
					@RequestParam(name = "signature", required = false) String signature,
					@RequestParam(name = "timestamp", required = false) String timestamp,
					@RequestParam(name = "nonce", required = false) String nonce,
					@RequestParam(name = "echostr", required = false) String echostr) {

		log.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]",
						signature, timestamp, nonce, echostr);

		if (StringUtils.isAnyBlank(signature, timestamp, nonce, echostr)) {
			throw new IllegalArgumentException("请求参数非法，请核实!");
		}

		if (this.wxMpService.checkSignature(timestamp, nonce, signature)) {
			return echostr;
		}
		return "非法请求";
	}


	@PostMapping(produces = "application/xml; charset=UTF-8")
	public String post(@RequestBody String requestBody,
	                   @RequestParam("signature") String signature,
	                   @RequestParam("timestamp") String timestamp,
	                   @RequestParam("nonce") String nonce,
	                   @RequestParam(name = "encrypt_type", required = false) String encType,
	                   @RequestParam(name = "msg_signature", required = false) String msgSignature) {
		this.log.info("\n接收微信请求：[signature=[{}], encType=[{}], msgSignature=[{}],"
										+ " timestamp=[{}], nonce=[{}], requestBody=[\n{}\n] ",
						signature, encType, msgSignature, timestamp, nonce, requestBody);

		if (!this.wxMpService.checkSignature(timestamp, nonce, signature)) {
			throw new IllegalArgumentException("非法请求，可能属于伪造的请求！");
		}

		String responseMsg = null;
		if (encType == null) {
			// 明文传输的消息
			WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(requestBody);
			WxMpXmlOutMessage outMessage = this.route(inMessage);
			if (outMessage == null) {
				return "";
			}

			responseMsg = outMessage.toXml();
		} else if ("aes".equals(encType)) {
			// aes加密的消息
			WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(
							requestBody, this.wxMpService.getWxMpConfigStorage(), timestamp,
							nonce, msgSignature);
			this.log.debug("\n消息解密后内容为：\n{} ", inMessage.toString());
			WxMpXmlOutMessage outMessage = this.route(inMessage);
			if (outMessage == null) {
				return "";
			}

			responseMsg = outMessage.toEncryptedXml(this.wxMpService.getWxMpConfigStorage());
		}

		this.log.debug("\n组装回复信息：{}", responseMsg);

		return responseMsg;
	}

	private WxMpXmlOutMessage route(WxMpXmlMessage message) {
		try {
			return this.router.route(message);
		} catch (Exception e) {
			this.log.error(e.getMessage(), e);
		}

		return null;
	}
}
