package com.jhon.wx.mapper;

import com.jhon.wx.entity.ArticleDO;

import java.util.List;

/**
 * <p>功能描述</br>图文消息</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-weixin
 * @date 2018/4/3 16:51
 */
public interface ArticleMapper {
  /**
   * <pre>查询所有记录</pre>
   *
   * @return
   */
  List<ArticleDO> getAll();
}
