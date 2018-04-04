package com.jhon.wx.config;

import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpInRedisConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-weixin
 * @date 2018/3/27 11:45
 */
@Component
public class WechatOpenConfig {

  @Autowired
  private WechatAccountConfig accountConfig;

  @Autowired
  private JedisPool jedisPool;

  @Bean
  public WxMpService wxOpenService() {
    WxMpService wxOpenService = new WxMpServiceImpl();
    wxOpenService.setWxMpConfigStorage(wxOpenConfigStorage());
    return wxOpenService;
  }

  @Bean
  public WxMpConfigStorage wxOpenConfigStorage() {
    WxMpInRedisConfigStorage wxMpInRedisConfigStorage = new WxMpInRedisConfigStorage();
    wxMpInRedisConfigStorage.setAppId(accountConfig.getOpenAppId());
    wxMpInRedisConfigStorage.setSecret(accountConfig.getOpenAppSecret());
    wxMpInRedisConfigStorage.setToken(accountConfig.getOpenToken());
    wxMpInRedisConfigStorage.setAesKey(accountConfig.getOpenAesKey());
    return wxMpInRedisConfigStorage;
  }
}
