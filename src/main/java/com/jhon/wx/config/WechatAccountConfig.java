package com.jhon.wx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>功能描述</br> 微信账号配置信息 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatAccountConfig
 * @date 2017/10/12 10:34
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {

  /**
   * 公众平台AppId
   **/
  private String mpAppId;

  /**
   * 公众平台AppSecret
   **/
  private String mpAppSecret;

  private String mpToken;

  private String mpAesKey;

  /**
   * <pre>开放平台</pre>
   */
  private String openAppId;

  private String openAppSecret;

  private String openToken;

  private String openAesKey;

}
