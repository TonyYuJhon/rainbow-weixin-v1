package com.jhon.wx.entity;

import lombok.Data;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-weixin
 * @date 2018/4/3 16:47
 */
@Data
public class ArticleDO {
  /**
   * 主键
   */
  private Long id;

  /**
   * 标题
   */
  private String title;
  /**
   * 描述
   */
  private String description;
  /**
   * 封面图片
   */
  private String coverPicture;

  /**
   * 链接地址
   */
  private String url;
}
