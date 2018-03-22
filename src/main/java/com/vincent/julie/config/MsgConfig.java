package com.vincent.julie.config;

import com.vincent.julie.utils.StringUtils;

/**
 * @desc
 * @author Vincent QQ:1032006226
 * @version 1.0
 * @date 2018年1月30日
 */

public class MsgConfig {
	/*公共模块*/
	/**
	 * 服务器异常
	 */
	public static final String COMMON_SERVICE_EXCEPTION = "服务器异常";
	/**
	 * 手机号码不能为空
	 */
	public static final String COMMON_PHONE_IS_NOT_NULL = "手机号码不能为空";
	/**
	 * 密码不能为空
	 */
	public static final String COMMON_PASSWORD_IS_NOT_NULL = "密码不能为空";
	/**
	 * 用户不存在
	 */
	public static final String COMMON_USER_ACCOUNT_IS_NOT_EXIST = "该账号尚未注册";

	/**
	 * 登陆状态异常，请重新登陆
	 */
	public static final String COMMON_USER_LOGIN_STATUS_EXCEPTION = "登陆状态异常,请重新登陆";

	/*
	 * 注册成功
	 */
	public static final String USER_REGISTER_SUCCESS = "注册成功";
	/**
	 * 注册失败
	 */
	public static final String USER_REGISTER_FAILE = "注册失败";
	/**
	 * 注册失败
	 */
	public static final String USER_REGISTER_USER_IS_EXIST="用户已存在";
	/**
	 * 请登录
	 */
	public static final String USER_NEED_LOGIN = "用户未登陆,请登录";

	/**
	 * 当前账户已在其他客户端登录,如要继续请重新登录
	 */
	public static final String USER_LOGIN_STATUS_PAST_DUE = "当前账户已在其他客户端登录,如要继续请重新登录";

	/**
	 * 登录成功
	 */
	public static final String USER_LOGIN_SUCCESS = "登录成功";
	/**
	 * 登录失败
	 */
	public static final String USER_LOGIN_FAIL = "密码错误";
	/**
	 * 重置密码成功
	 */
	public static final String USER_RESET_PASSWORD_SUCCESS = "重置密码成功";
	/**
	 * 重置密码失败
	 */
	public static final String USER_RESET_PASSWORD_FAIL = "重置密码失败";
	/**
	 * 修改密码
	 */
	public static final String USER_ALERT_PASSWORD_ERROR = "旧密码错误";

	/**
	 * 修改密码
	 */
	public static final String USER_ALERT_PASSWORD_FAIL = "系统错误";

	/**
	 * 修改密码
	 */
	public static final String USER_ALERT_PASSWORD_SUCCESS = "密码修改成功";

	/**
	 * 修改用户信息
	 */
	public static final String USER_CHANGE_USER_INFO_SUCCESSFAILE = "用户信息修改成功";

	/**
	 * 添加备忘录
	 */
	public static final String MEMO_ADD_TITLE_USER_ID_NULL ="用户id不能为空";
	/**
	 * 添加备忘录
	 */
	public static final String MEMO_ADD_TITLE_IS_NULL ="标题不能为空";
	/**
	 * 添加备忘录
	 */
	public static final String MEMO_ADD_TITLE_CONTENT_NULL ="内容不能为空";
	/**
	 * 添加备忘录
	 */
	public static final String MEMO_ADD_TITLE_TARGET_TIME_NULL ="备忘录提醒时间不能为空";
	/**
	 * 添加备忘录
	 */
	public static final String MEMO_ADD_TITLE_EXIST ="标题已存在,请修改后再次提交";

	/**
	 * 添加备忘录
	 */
	public static final String MEMO_ADD_FAIL ="添加失败,请检查服务器代码";

	/**
	 * 添加备忘录
	 */
	public static final String MEMO_ADD_SUCCESS ="添加成功";
	/**
	 * 获取所有数据
	 */
	public static final String MEMO_SELECT_ALL_IS_NULL="暂无数据";
	/**
	 * 获取所有数据
	 */
	public static final String MEMO_SELECT_ALL_SUCCESS="已获取所有数据";

	///////////////////////////////版本控制相关//////////////////////////////////////////////
	/**
	 * 添加新版本
	 */
	public static final String VERSION_ADD_NEW_VERSION_SUCCESS = "新版本添加成功";
	/**
	 * 检查最新版本
	 */
	public static final String VERSION_CHECK_NEW_VERSION_SUCCESS = "查询成功";
	/**
	 * 当前已是最新版本
	 */
	public static final String VERSION_VERSION_LATEST = "当前已是最新版本";
	/**
	 * 版本删除成功
	 */
	public static final String VERSION_DELETE_VERSION_SUCCESS = "版本删除成功";
	/**
	 * 版本删除失败
	 */
	public static final String VERSION_DELETE_VERSION_FAIL = "版本删除失败";
	/**
	 * 版本不存在，无需删除
	 */
	public static final String VERSION_DELETE_VERSION_NOT_EXIST = "版本不存在，无需删除";
	/**
	 * version_desc 字段为空
	 */
	public static final String VERSION_DESC_IS_NULL = "请输入版本描述";

}
