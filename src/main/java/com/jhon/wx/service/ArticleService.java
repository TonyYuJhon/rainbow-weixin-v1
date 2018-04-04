package com.jhon.wx.service;

import com.jhon.wx.entity.ArticleDO;

import java.util.List;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-weixin
 * @date 2018/4/3 16:52
 */
public interface ArticleService {

  /**
   * <pre>查询所有记录</pre>
   *
   * @return
   */
  List<ArticleDO> findAllRecord();
}
