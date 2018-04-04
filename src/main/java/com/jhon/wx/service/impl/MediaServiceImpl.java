package com.jhon.wx.service.impl;

import com.jhon.wx.entity.MediaDO;
import com.jhon.wx.mapper.MediaMapper;
import com.jhon.wx.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>功能描述</br>素材业务逻辑接口</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-weixin
 * @date 2018/4/3 15:26
 */
@Service
public class MediaServiceImpl implements MediaService {

  @Autowired
  private MediaMapper mediaMapper;

  @Override
  public List<MediaDO> getList() {
    return mediaMapper.getAll();
  }

  @Override
  @Transactional
  public int createRecord(MediaDO media) {
    return mediaMapper.createRecord(media);
  }

  @Override
  public MediaDO findRecordBydMediaId(String mediaId) {
    return mediaMapper.findByMediaId(mediaId);
  }
}
