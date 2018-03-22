
package com.vincent.julie.utils;

/**
 * @Title: StringUtils.java
 * @Package com.vincent.julie.utils
 * @Description: StringUtils
 * @author: Vinent QQ:1032006226
 * @date: 2018��1��31�� ����11:23:45
 * @version V1.0
 * @Copyright: 2018
 */
public class StringUtils {

	public static boolean isEmpty(String str) {
		if (str == null || str.length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * equals
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equals(String str1, String str2) {
		if (str1.equals(str2)) {
			return true;
		} else {
			return false;
		}
	}
}
