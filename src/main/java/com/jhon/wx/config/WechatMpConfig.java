package com.jhon.wx.config;

import com.jhon.wx.handler.*;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.*;
import me.chanjar.weixin.mp.api.impl.WxMpMenuServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.api.impl.WxMpUserServiceImpl;
import me.chanjar.weixin.mp.constant.WxMpEventConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * <p>功能描述</br> 微信公众平台配置 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatMpConfig
 * @date 2018/04/04 10:32
 */
@Component
public class WechatMpConfig {

  @Autowired
  private WechatAccountConfig accountConfig;

  @Autowired
  private LogHandler logHandler;

  @Autowired
  private SubscribeHandler subscribeHandler;

  @Autowired
  private UnSubscribeHandler unSubscribeHandler;

  @Autowired
  private MenuHandler menuHandler;

  @Autowired
  private NullHandler nullHandler;

  @Autowired
  private ScanHandler scanHandler;

  @Autowired
  private LocationHandler locationHandler;

  @Autowired
  private MsgHandler msgHandler;

  @Autowired
  private StoreCheckNotifyHandler storeCheckNotifyHandler;

  @Autowired
  private KfSessionHandler kfSessionHandler;

  @Autowired
  private ImageHandler imageHandler;


  @Autowired
  private JedisPool jedisPool;

  @Bean
  public WxMpMenuService wxMpMenuService() {
    WxMpMenuService wxMpMenuService = new WxMpMenuServiceImpl(wxMpService());
    return wxMpMenuService;
  }

  @Bean
  public WxMpUserService wxMpUserService() {
    WxMpUserService wxMpUserService = new WxMpUserServiceImpl(wxMpService());
    return wxMpUserService;
  }

  @Bean
  public WxMpService wxMpService() {
    WxMpService wxMpService = new WxMpServiceImpl();
    wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
    return wxMpService;
  }

  @Bean
  public WxMpConfigStorage wxMpConfigStorage() {
    WxMpInRedisConfigStorage wxMpInRedisConfigStorage = new WxMpInRedisConfigStorage();
    wxMpInRedisConfigStorage.setJedis(jedisPool.getResource());
    wxMpInRedisConfigStorage.setAppId(accountConfig.getMpAppId());
    wxMpInRedisConfigStorage.setSecret(accountConfig.getMpAppSecret());
    wxMpInRedisConfigStorage.setToken(accountConfig.getMpToken());
    wxMpInRedisConfigStorage.setAesKey(accountConfig.getMpAesKey());
    return wxMpInRedisConfigStorage;
  }

  @Bean
  public WxMpMessageRouter router(WxMpService wxMpService) {

    final WxMpMessageRouter newRouter = new WxMpMessageRouter(wxMpService);

    // 记录所有事件的日志 （异步执行）
    newRouter.rule().handler(this.logHandler).next();

    // 文本消息
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_TEXT)
            .handler(msgHandler)
            .end();

    // 关注事件
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxConsts.EVT_SUBSCRIBE)
            .handler(subscribeHandler)
            .end();
    // 取消关注事件
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxConsts.EVT_UNSUBSCRIBE)
            .handler(unSubscribeHandler)
            .end();

    // 自定义菜单事件
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxConsts.BUTTON_CLICK)
            .handler(menuHandler)
            .end();

    // 点击菜单连接事件
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxConsts.BUTTON_VIEW)
            .handler(nullHandler)
            .end();

    // 扫码事件
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxConsts.EVT_SCAN)
            .handler(scanHandler)
            .end();

    // 上报地理位置事件
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxConsts.EVT_LOCATION)
            .handler(locationHandler)
            .end();

    // 接收地理位置消息
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_LOCATION)
            .handler(locationHandler)
            .end();


    // 接收客服会话管理事件
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxMpEventConstants.CustomerService.KF_CREATE_SESSION)
            .handler(kfSessionHandler)
            .end();
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxMpEventConstants.CustomerService.KF_CLOSE_SESSION)
            .handler(kfSessionHandler)
            .end();
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxMpEventConstants.CustomerService.KF_SWITCH_SESSION)
            .handler(kfSessionHandler)
            .end();

    // 门店审核事件
    newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
            .event(WxMpEventConstants.POI_CHECK_NOTIFY)
            .handler(storeCheckNotifyHandler)
            .end();

    // 图片事件
    newRouter.rule().async(false).msgType(WxConsts.MEDIA_IMAGE)
            .handler(imageHandler)
            .end();

    return newRouter;
  }
}
