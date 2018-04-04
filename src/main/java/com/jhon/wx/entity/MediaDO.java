package com.jhon.wx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-weixin
 * @date 2018/4/3 15:17
 */
@Data
public class MediaDO implements Serializable {
  /**
   * 主键
   */
  private Long id;

  /**
   * 素材Id
   */
  private String mediaId;
  /**
   * 素材类型
   */
  private String mediaType;
}
