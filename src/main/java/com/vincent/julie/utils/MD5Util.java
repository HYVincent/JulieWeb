package com.vincent.julie.utils;

import java.security.MessageDigest;

/**
 * @Title:  MD5Utils.java
 * @Package com.vincent.julie.utils
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: Vinent QQ:1032006226
 * @date:   2018年3月3日 上午7:52:16
 * @version V1.0
 * @Copyright: 2018
 * 注意：本内容仅限于是我写的
 */

public class MD5Util {

	private static final String encryModel="MD5";
	/**
	 * 32λmd5.
	 * 32位小写md5加密
	 * @param str
	 * @return
	 */
	public  static String md5(String str) {
		return encrypt(encryModel, str);
	}


	public static String encrypt(String algorithm, String str) {
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);
			md.update(str.getBytes());
			StringBuffer sb = new StringBuffer();
			byte[] bytes = md.digest();
			for (int i = 0; i < bytes.length; i++) {
				int b = bytes[i] & 0xFF;
				if (b < 0x10) {
					sb.append('0');
				}
				sb.append(Integer.toHexString(b));
			}
			return sb.toString();
		} catch (Exception e) {
			return "";
		}
	}

}
