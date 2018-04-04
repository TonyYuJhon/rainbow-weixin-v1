package com.jhon.wx.service.impl;

import com.jhon.wx.entity.ArticleDO;
import com.jhon.wx.mapper.ArticleMapper;
import com.jhon.wx.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>功能描述</br>图文消息的业务逻辑接口处理</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-weixin
 * @date 2018/4/3 16:52
 */
@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private ArticleMapper articleMapper;


  @Override
  public List<ArticleDO> findAllRecord() {
    return articleMapper.getAll();
  }
}
