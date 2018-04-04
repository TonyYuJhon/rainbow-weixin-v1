package com.jhon.wx.service;

import com.github.pagehelper.Page;
import com.jhon.wx.entity.WechatAccountDO;

import java.util.List;

/**
 * <p>功能描述</br> 微信公众号业务逻辑接口 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatAccountService
 * @date 2017/10/13 14:02
 */
public interface WechatAccountService {
	/**
	 * <p>查询所有的公众号</p>
	 *
	 * @return
	 */
	List<WechatAccountDO> list();

	/**
	 * <p>分页查询记录</p>
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page<WechatAccountDO> findByPage(int pageNo, int pageSize);

}
