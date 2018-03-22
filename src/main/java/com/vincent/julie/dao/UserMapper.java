
package com.vincent.julie.dao;

import com.vincent.julie.bean.User;

import java.util.Map;

/**
 * @author chenpy-1072
 * @desc UserMapper
 * @date 2018/3/19 13:02
 * @see
 */
public interface UserMapper {

	User selectUser(String param);

	int registerUser(User user);

	int resetPassword(Map<String, Object> paramMap);

	/**
	 * 设置退出登录时间
	 * @param paramMap
	 */
	void setLoginOutTime(Map<String,Object> paramMap);

	/**
	 * 设置登录时间
	 * @param paramMap
	 */
	void setLoginTime(Map<String,Object> paramMap);

	/**
	 * 修改用户资料
	 * @param paramMap
	 */
	void updateUserInfo(Map<String,Object> paramMap);

}
