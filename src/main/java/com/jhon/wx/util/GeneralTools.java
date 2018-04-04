package com.jhon.wx.util;

/**
 * <p>功能描述</br> 通用工具类 </p>
 *
 * @author jiangy19
 * @version v1.0
 * @FileName GeneralTools
 * @date 2017/10/13 16:36
 */
public class GeneralTools {

	/**
	 *
	 * @param array 数组
	 * @param <T>
	 * @return
	 */
	public static <T> boolean isEmpty(T[] array) {
		return (array == null || array.length == 0);
	}

	/**
	 * 数组装换为逗号隔开的字符串
	 * @param arr 目标数组
	 * @return
	 */
	public static String array2Str(Object[] arr) {
		String result = null;
		StringBuilder sb = new StringBuilder();
		if (!isEmpty(arr)) {
			for (Object obj : arr) {
				sb.append(",").append(obj.toString());
			}

			result = sb.toString();
			if (result.length()>0){
				result = result.substring(0,result.length()-1);
			}
		}
		return  result;
	}
}
