package com.jhon.wx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>功能描述</br> 项目的url配置和微信授权回调url配置 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName ProjectUrlConfig
 * @date 2017/10/12 10:33
 */
@Data
@Component
@ConfigurationProperties(prefix = "projectUrl")
public class ProjectUrlConfig {

	/**
	 * 微信公众平台授权回调Url
	 **/
	private String wechatMpAuthorize;

	/**
	 * 微信开放平台授权回调Url
	 **/
	private String wechatOpenAuthorize;
}
