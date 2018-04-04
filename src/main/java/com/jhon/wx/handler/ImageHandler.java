package com.jhon.wx.handler;

import com.jhon.wx.builder.ImageBuilder;
import com.jhon.wx.entity.MediaDO;
import com.jhon.wx.mapper.MediaMapper;
import com.jhon.wx.service.MediaService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <p>功能描述</br>图片处理器</p>
 *
 * @author jiangy19
 * @version v1.0
 * @projectName rainbow-weixin
 * @date 2018/4/3 14:42
 */
@Slf4j
@Component
public class ImageHandler extends AbstractHandler {

  @Autowired
  private MediaService mediaService;

  @Override
  public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                  Map<String, Object> context,
                                  WxMpService wxMpService,
                                  WxSessionManager sessionManager) throws WxErrorException {
    /** 原始ID **/
    String originMediaId = wxMessage.getMediaId();
    String content = "";
    log.info("获取到的原始资源ID={}",originMediaId);
    /*MediaDO mediaDO = mediaService.findRecordBydMediaId(originMediaId);
    if (mediaDO == null){
      mediaDO = new MediaDO();
      mediaDO.setMediaId(originMediaId);
      mediaDO.setMediaType("image");
      mediaService.createRecord(mediaDO);
    }
    List<MediaDO> mediaList = mediaService.getList();
    int record = (new Random().nextInt(100))%3;
    String content = "";
    if (record == 0){
      mediaList.get(0);
    }
    else if (record == 1){
      mediaList.get(1);
    }
    else if (record == 2){
      mediaList.get(2);
    }*/
    int record = (new Random().nextInt(100))%2;
    if(record == 0){
      content = "dKSWdSN2zOdxKjgf1MYPe9sRsqynJoX5Wr-zaMr9hkQJRZnBJjcDhDFDko7QFvYF";
    }
    else{
      content = "BtHuy-hTKAXD-xKW2rh2M6KTb_OGghSoMraDUEozjGLQ04Mxhved_2EUC375QqRI";
    }
    return new ImageBuilder().build(content, wxMessage, wxMpService);
  }
}
