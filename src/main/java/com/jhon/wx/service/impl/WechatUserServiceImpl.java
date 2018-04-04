package com.jhon.wx.service.impl;

import com.github.pagehelper.Page;
import com.jhon.wx.entity.WechatUserDO;
import com.jhon.wx.mapper.WechatUserMapper;
import com.jhon.wx.service.WechatUserService;
import com.jhon.wx.util.GeneralTools;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * <p>功能描述</br> 微信粉丝业务逻辑接口实现类 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName WechatUserServiceImpl
 * @date 2017/10/13 14:44
 */
@Service
public class WechatUserServiceImpl implements WechatUserService {

	@Autowired
	private WechatUserMapper wechatUserMapper;

	@Override
	public List<WechatUserDO> list() {
		return wechatUserMapper.getAll();
	}

	@Override
	public Page<WechatUserDO> findByPage(int pageNo, int pageSize) {
		return null;
	}

	@Override
	public WechatUserDO findByOpenId(String openId) {
		return wechatUserMapper.findByOpenId(openId);
	}

	@Override
	public WechatUserDO findByUniionId(String unionId) {
		return wechatUserMapper.findByUnionId(unionId);
	}

	@Override
	@Transactional
	public int create(WechatUserDO wechatUser) {
		return wechatUserMapper.createRecord(wechatUser);
	}

	@Override
	@Transactional
	public int deleteById(Long id) {
		return wechatUserMapper.delete(id);
	}

	@Override
	@Transactional
	public int deleteByOpenId(String openId) {
		return wechatUserMapper.deleteByOpenId(openId);
	}

	@Override
	@Transactional
	public WechatUserDO updateUserInfo(WxMpUser wxMpUser) {
		/** 先查询记录,如果记录存在就更新 **/
		String openId = wxMpUser.getOpenId();
		WechatUserDO queryWechatUser = this.findByOpenId(openId);
		if (queryWechatUser != null) {
			return queryWechatUser;
		} else {
			WechatUserDO wechatUserDO = new WechatUserDO();
			wechatUserDO.setSubscribe(wxMpUser.getSubscribe());
			wechatUserDO.setOpenId(wxMpUser.getOpenId());
			wechatUserDO.setNickname(wxMpUser.getNickname());
			wechatUserDO.setSex(wxMpUser.getSex());
			wechatUserDO.setLanguage(wxMpUser.getLanguage());
			wechatUserDO.setCity(wxMpUser.getCity());
			wechatUserDO.setProvince(wxMpUser.getProvince());
			wechatUserDO.setCountry(wxMpUser.getCountry());
			wechatUserDO.setHeadImgUrl(wxMpUser.getHeadImgUrl());
			wechatUserDO.setUnionId(wxMpUser.getUnionId());
			wechatUserDO.setRemark(wxMpUser.getRemark());
			wechatUserDO.setSubscribeTime(new Date(wxMpUser.getSubscribeTime()));
			wechatUserDO.setGroupId(wxMpUser.getGroupId());
			wechatUserDO.setTagIds(GeneralTools.array2Str(wxMpUser.getTagIds()));
			wechatUserDO.setRegisterUserId(0L);
			wechatUserDO.setWechatAccountId(0L);
			int influenceRecord = this.create(wechatUserDO);
			return wechatUserDO;
		}
	}
}
