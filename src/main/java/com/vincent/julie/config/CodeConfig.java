package com.vincent.julie.config;

/**
 * @Title:  CodeConfig.java
 * @Package com.vincent.julie
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: Vinent QQ:1032006226
 * @date:   2018年1月30日 下午1:04:58
 * @version V1.0
 * @Copyright: 2018
 * 注意：本内容仅限于是我写的
 */

public class CodeConfig {

	/**
	 * 服务器异常 服务器报错
	 */
	public static final int SERVICE_EXCEPTION = 10000;

	/**
	 * 逻辑错误，服务器相应正常
	 */
	public static final int SERVICE_ERROR = 10001;

	/**
	 * 服务器正常
	 */
	public static final int SERVICE_NORMAL = 10002;

	/**
	 * 用戶未登陸
	 */
	public static final int USER_NO_LOGIN = 10003;

	/**
	 * 当前账户在其他地方登陆
	 */
	public static final int USER_LOGIN_STATUS_PAST_DUE = 10004;
	/**
	 * 登陆状态异常,请重新登陆
	 */
	public static final int USER_LOGIN_STATUS_EXECEPTION = 10005;



}
