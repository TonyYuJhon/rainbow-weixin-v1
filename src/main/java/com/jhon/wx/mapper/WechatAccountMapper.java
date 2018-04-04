package com.jhon.wx.mapper;

import com.jhon.wx.entity.WechatAccountDO;

import java.util.List;

/**
 * <p>功能描述</br> 微信公众号接口 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatAccountMapper
 * @date 2017/10/13 13:51
 */
public interface WechatAccountMapper {

	/**
	 * 查询所有的公众号
	 * @return
	 */
	List<WechatAccountDO> getAll();
}
