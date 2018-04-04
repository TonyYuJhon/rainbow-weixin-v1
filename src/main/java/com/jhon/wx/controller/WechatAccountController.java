package com.jhon.wx.controller;

import com.jhon.wx.entity.WechatAccountDO;
import com.jhon.wx.service.WechatAccountService;
import com.jhon.wx.util.ResponseUtil;
import com.jhon.wx.vo.RainbowResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>功能描述</br> 微信公众号配置控制器 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatAccountController
 * @date 2017/10/13 14:16
 */
@RestController
@RequestMapping("/wechatAccount")
public class WechatAccountController {

	@Autowired
	private WechatAccountService wechatAccountService;

	@GetMapping("/list")
	public RainbowResponse queryAll() {
		List<WechatAccountDO> wechatAccounts = wechatAccountService.list();
		return ResponseUtil.ok(wechatAccounts);
	}
}
