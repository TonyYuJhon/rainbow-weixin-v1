package com.jhon.wx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jhon.wx.entity.RegisterUserDO;
import com.jhon.wx.mapper.RegisterUserMapper;
import com.jhon.wx.service.RegisterUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>功能描述</br> 注册用户业务逻辑接口实现类 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName RegisterUserServiceImpl
 * @date 2017/10/14 9:50
 */
@Service
@Slf4j
public class RegisterUserServiceImpl implements RegisterUserService {

	@Autowired
	private RegisterUserMapper registerUserMapper;


	@Override
	public List<RegisterUserDO> list() {
		return registerUserMapper.getAll();
	}

	@Override
	public Page<RegisterUserDO> findByPage(int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return registerUserMapper.findByPage();
	}
}
