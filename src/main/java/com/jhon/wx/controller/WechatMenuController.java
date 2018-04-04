package com.jhon.wx.controller;

import com.jhon.wx.service.WechatMenuService;
import com.jhon.wx.vo.RainbowResponse;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.common.bean.menu.WxMenuButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>功能描述</br> 微信菜单控制器 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatMenuController
 * @date 2017/10/13 8:37
 */
@RestController
@RequestMapping("/menu")
public class WechatMenuController {

  @Autowired
  private WechatMenuService wechatMenuService;

  @PostMapping("/create")
  public String menuCreate(@RequestBody WxMenu wxMenu) {
    return wechatMenuService.menuCreate(wxMenu);
  }

  @GetMapping("/create")
  public String menuCreate() {
    WxMenu menu = new WxMenu();
    WxMenuButton button1 = new WxMenuButton();
    button1.setType(WxConsts.BUTTON_CLICK);
    button1.setName("个人网站");
    button1.setKey("V1001_Personal_Web");

    WxMenuButton button2 = new WxMenuButton();
    button2.setName("菜单");

    menu.getButtons().add(button1);
    menu.getButtons().add(button2);

    WxMenuButton button21 = new WxMenuButton();
    button21.setType(WxConsts.BUTTON_VIEW);
    button21.setName("生活博客");
    button21.setUrl("http://www.jhonrain.org");

    WxMenuButton button22 = new WxMenuButton();
    button22.setType(WxConsts.BUTTON_VIEW);
    button22.setName("技术博客");
    button22.setUrl("http://www.jiang-yu.cn");

    WxMenuButton button23 = new WxMenuButton();
    button23.setType(WxConsts.BUTTON_CLICK);
    button23.setName("赞一下我们");
    button23.setKey("V1001_GOOD");

    button2.getSubButtons().add(button21);
    button2.getSubButtons().add(button22);
    button2.getSubButtons().add(button23);

    return wechatMenuService.menuCreate(menu);
  }

  @GetMapping("/delete")
  public void menuDelete() {
    wechatMenuService.menuDelete();
  }
}
