package com.jhon.wx.service.impl;

import com.github.pagehelper.Page;
import com.jhon.wx.entity.WechatAccountDO;
import com.jhon.wx.mapper.WechatAccountMapper;
import com.jhon.wx.service.WechatAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>功能描述</br> 微信公众号配置查询 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatAccountServiceImpl
 * @date 2017/10/13 14:03
 */
@Service
@Slf4j
public class WechatAccountServiceImpl implements WechatAccountService {

	@Autowired
	private WechatAccountMapper wechatAccountMapper;


	@Override
	public List<WechatAccountDO> list() {
		return wechatAccountMapper.getAll();
	}

	@Override
	public Page<WechatAccountDO> findByPage(int pageNo, int pageSize) {
		return null;
	}
}
