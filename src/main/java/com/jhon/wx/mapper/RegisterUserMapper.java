package com.jhon.wx.mapper;

import com.github.pagehelper.Page;
import com.jhon.wx.entity.RegisterUserDO;

import java.util.List;

/**
 * <p>功能描述</br> 注册用户接口 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName RegisterUserMapper
 * @date 2017/10/13 13:51
 */
public interface RegisterUserMapper {

	/**
	 * <p>新增注册用户</p>
	 *
	 * @param registerUser
	 * @return
	 */
	int createRecord(RegisterUserDO registerUser);

	/**
	 * <p>更新注册用户信息</p>
	 *
	 * @param registerUser
	 * @return
	 */
	int updateRecord(RegisterUserDO registerUser);

	/**
	 * <p>根据Id删除记录</p>
	 *
	 * @param id 主键
	 * @return
	 */
	int delete(Long id);

	/**
	 * <p>根据电话删除记录</p>
	 *
	 * @param phone 电话
	 * @return
	 */
	int delete(String phone);

	/**
	 * <p>获取所有</p>
	 *
	 * @return
	 */
	List<RegisterUserDO> getAll();

	/**
	 * <p>分页查询记录</p>
	 *
	 * @return
	 */
	Page<RegisterUserDO> findByPage();
}
