package com.jhon.wx.mapper;

import com.jhon.wx.entity.MediaDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>功能描述</br></p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-weixin
 * @date 2018/4/3 15:22
 */
public interface MediaMapper {

  /**
   * <pre>查询所有记录</pre>
   *
   * @return
   */
  List<MediaDO> getAll();

  /**
   * <pre>通过Id查询记录</pre>
   *
   * @param mediaId
   * @return
   */
  MediaDO findByMediaId(@Param("mediaId") String mediaId);

  /**
   * <pre>新增记录</pre>
   *
   * @param media
   * @return
   */
  int createRecord(MediaDO media);
}
