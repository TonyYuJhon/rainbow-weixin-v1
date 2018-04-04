package com.jhon.wx.service;

import com.jhon.wx.entity.MediaDO;

import java.util.List;

/**
 * <p>功能描述</br>微信素材业务逻辑接口定义</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-weixin
 * @date 2018/4/3 15:25
 */
public interface MediaService {

  /**
   * <pre>查询所有的记录</pre>
   *
   * @return
   */
  List<MediaDO> getList();

  /**
   * <pre>创建新的记录</pre>
   *
   * @param media 素材
   * @return
   */
  int createRecord(MediaDO media);

  /**
   * <pre>通过mediaId查询记录</pre>
   *
   * @param mediaId 素材Id
   * @return
   */
  MediaDO findRecordBydMediaId(String mediaId);
}
