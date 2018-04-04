package com.jhon.wx.service;

import com.github.pagehelper.Page;
import com.jhon.wx.entity.RegisterUserDO;

import java.util.List;

/**
 * <p>功能描述</br> 注册用户业务逻辑接口 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName RegisterUserService
 * @date 2017/10/14 9:50
 */
public interface RegisterUserService {

	/**
	 * <p>查询所有记录</p>
	 *
	 * @return
	 */
	List<RegisterUserDO> list();

	/**
	 * <p>分页查询记录</p>
	 *
	 * @param pageNo 当前页
	 * @param pageSize 每页大小
	 * @return
	 */
	Page<RegisterUserDO> findByPage(int pageNo, int pageSize);
}
