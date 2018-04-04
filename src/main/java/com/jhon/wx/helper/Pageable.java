package com.jhon.wx.helper;

import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>功能描述</br> 分页值对象 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName Pageable
 * @date 2017/10/14 9:38
 */
@Data
public class Pageable<T> implements Serializable {

	private static final long serialVersionUID = 7185424959558987236L;

	/**
	 * 当前页
	 */
	private int pageNum;

	/**
	 * 每页的大小
	 */
	private int pageSize;

	/**
	 * 总记录数
	 */
	private long total;

	/**
	 * 总页数
	 */
	private int pages;

	/**
	 * 结果集
	 */
	private List<T> list;

	/**
	 * 是否为第一页
	 */
	private boolean isFirstPage;

	/**
	 * 是否为最后一页
	 */
	private boolean isLastPage;

}
