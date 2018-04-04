package com.jhon.wx.controller;

import com.jhon.wx.service.WechatUserService;
import com.jhon.wx.util.ResponseUtil;
import com.jhon.wx.vo.RainbowResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>功能描述</br> 微信粉丝信息控制器 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatUserController
 * @date 2017/10/13 17:54
 */
@RestController
@RequestMapping("wechatUser")
public class WechatUserController {

	@Autowired
	private WechatUserService wechatUserService;

	/**
	 * 查询所有粉丝信息
	 *
	 * @return 粉丝信息列表
	 */
	@GetMapping("/list")
	public RainbowResponse list() {
		return ResponseUtil.ok(wechatUserService.list());
	}
}
