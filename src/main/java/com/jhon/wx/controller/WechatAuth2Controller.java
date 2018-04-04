package com.jhon.wx.controller;

import com.alibaba.fastjson.JSON;
import com.jhon.wx.config.ProjectUrlConfig;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * <p>功能描述</br> 微信控制器 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatController
 * @date 2017/10/12 17:38
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatAuth2Controller {

  @Autowired
  private WxMpService wxMpService;

  @Autowired
  private WxMpService wxOpenService;

  @Autowired
  private ProjectUrlConfig projectUrlConfig;

  /**
   * 获取code
   *
   * @param returnUrl
   * @return
   */
  @GetMapping("/authorize")
  public String authorize(@RequestParam("returnUrl") String returnUrl) throws UnsupportedEncodingException {
    String url = projectUrlConfig.getWechatMpAuthorize() + "/wechat/userInfo";
    String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_BASE, URLEncoder.encode(returnUrl, "utf-8"));
    return "redirect:" + redirectUrl;
  }

  /**
   * 获取openId
   *
   * @param code
   * @param returnUrl
   * @return
   */
  @GetMapping("/userInfo")
  @ResponseBody
  public String userInfo(@RequestParam("code") String code, @RequestParam("state") String returnUrl) {
    WxMpUser wxMpUser = null;
    String openId = null;
    try {
      WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
      openId = wxMpOAuth2AccessToken.getOpenId();
      log.info("【网页授权获取openId】{}", openId);
      wxMpUser = wxMpService.getUserService().userInfo(openId);
      log.info("【获取到微信粉丝的信息】", JSON.toJSONString(wxMpUser, true));
    } catch (WxErrorException e) {
      log.error("【微信网页授权】{}", e);
      e.printStackTrace();
    }
    return "redirect:" + returnUrl + "?openid=" + openId;
  }

  /**
   * 开放平台
   **/
  @GetMapping("/qrAuthorize")
  public String qrAuthorize(@RequestParam("returnUrl") String returnUrl) {
    String url = projectUrlConfig.getWechatOpenAuthorize() + "/wechat/qrUserInfo";
    String redirectUrl = wxOpenService.buildQrConnectUrl(url, WxConsts.QRCONNECT_SCOPE_SNSAPI_LOGIN, URLEncoder.encode(returnUrl));
    return "redirect:" + redirectUrl;
  }

  /**
   * <pre>用户信息</pre>
   *
   * @param code
   * @param returnUrl
   * @return
   */
  @GetMapping("/qrUserInfo")
  public String qrUserInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl) {
    WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
    try {
      wxMpOAuth2AccessToken = wxOpenService.oauth2getAccessToken(code);
    } catch (WxErrorException e) {
      log.error("【微信网页授权】{}", e);
      //throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(), e.getError().getErrorMsg());
    }
    log.info("wxMpOAuth2AccessToken={}", wxMpOAuth2AccessToken);
    String openId = wxMpOAuth2AccessToken.getOpenId();

    return "redirect:" + returnUrl + "?openid=" + openId;
  }
}
