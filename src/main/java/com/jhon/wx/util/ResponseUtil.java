package com.jhon.wx.util;

import com.jhon.wx.constants.RainbowConstants;
import com.jhon.wx.vo.RainbowResponse;

/**
 * <p>功能描述</br> 返回值的工具类 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName ResponseUtil
 * @date 2017/10/13 14:18
 */
public final class ResponseUtil {

	/**
	 * 正确返回结果处理
	 * @param data 返回的结果
	 * @return
	 */
	public static RainbowResponse ok(Object data){
		RainbowResponse rainbowResponse = new RainbowResponse();
		rainbowResponse.setCode(RainbowConstants.DEFAULT_SUCCESS_CODE);
		rainbowResponse.setData(data);
		return rainbowResponse;
	}

	/**
	 * 正确响应结果的处理
	 * @param msg 返回消息
	 * @param data 返回数据
	 * @return
	 */
	public static RainbowResponse ok(String msg, Object data) {
		RainbowResponse rainbowResponse = new RainbowResponse();
		rainbowResponse.setMsg(msg);
		rainbowResponse.setData(data);
		return rainbowResponse;
	}
}
