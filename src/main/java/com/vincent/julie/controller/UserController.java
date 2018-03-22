
package com.vincent.julie.controller;

import com.vincent.julie.bean.JulieResult;
import com.vincent.julie.bean.User;
import com.vincent.julie.config.CodeConfig;
import com.vincent.julie.config.MsgConfig;
import com.vincent.julie.dao.UserMapper;
//import com.vincent.julie.utils.ResponseUtils;
import com.vincent.julie.utils.MD5Util;
import com.vincent.julie.utils.Sha1Util;
import com.vincent.julie.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserMapper userMapper;

	/**
	 * 注册
	 * @param password
	 * @param phone
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public JulieResult register(@RequestParam("user_password") String user_password,
			@RequestParam("user_phone") String user_phone, HttpServletRequest request, HttpServletResponse response) {
		JulieResult result = new JulieResult();
		if (StringUtils.isEmpty(user_phone)) {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.COMMON_PHONE_IS_NOT_NULL);
			return result;
		}
		if (StringUtils.isEmpty(user_password)) {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.COMMON_PASSWORD_IS_NOT_NULL);
			return result;
		}
		if (queryUserIsExist(user_phone)) {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.USER_REGISTER_USER_IS_EXIST);
			return result;
		} else {
			User user = new User();
			user.setUser_password(user_password);
			user.setUser_phone(user_phone);
			userMapper.registerUser(user);
			if (!queryUserIsExist(user_phone)) {
				result.setErrorCode(CodeConfig.SERVICE_ERROR);
				result.setMsg(MsgConfig.USER_REGISTER_FAILE);
				return result;
			}else {
                result.setMsg(MsgConfig.USER_REGISTER_SUCCESS);
                result.setSuccess(true);
                result.setData(user);
                return result;
            }
		}
	}

	/**
	 * @param user_phone
	 * @param user_password
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public JulieResult login(@RequestParam("user_phone") String user_phone,
			@RequestParam("user_password") String user_password, HttpServletRequest request,
			HttpServletResponse response) {
		JulieResult result = new JulieResult();
		if (StringUtils.isEmpty(user_phone)) {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.COMMON_PHONE_IS_NOT_NULL);
			return result;
		}
		if (StringUtils.isEmpty(user_password)) {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.COMMON_PASSWORD_IS_NOT_NULL);
			return result;
		}
		User user = getUserForPhone(user_phone);
		if (user != null) {
			if (StringUtils.equals(user_password, user.getUser_password())) {
				user.setUser_password("********");
				result.setSuccess(true);
				// 生成客户端token，以验证用户是否登录成功
				String originalToken  = user.getUser_name() + "_JULIE" + "TOKEN"+System.currentTimeMillis();
				String token = generatorToken(originalToken);
				String sha1Token = Sha1Util.encode(token);
				request.getSession().setAttribute("API_TOKEN",sha1Token);
				user.setApi_token(sha1Token);
				result.setMsg(MsgConfig.USER_LOGIN_SUCCESS);
				result.setData(user);
				return result;
			} else {
				result.setErrorCode(CodeConfig.SERVICE_ERROR);
				result.setMsg(MsgConfig.USER_LOGIN_FAIL);
				return result;
			}
		} else {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.COMMON_USER_ACCOUNT_IS_NOT_EXIST);
			return result;
		}
	}

	/**
	 *
	 * @param originalToken
	 * @return
	 */
	private static String generatorToken(String originalToken) {
		/*ByteArrayInputStream inputStream = new ByteArrayInputStream("hello".getBytes());
		try {
			return DigestUtils.md5DigestAsHex(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return MD5Util.md5(originalToken);
	}


	/**
	 * alertPassword
	 * @date 2018/3/19 15:20
	 * @param user_phone
	 * @param old_password
	 * @param new_password
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "alertPassword", method = RequestMethod.POST)
	public JulieResult alertPassword(@RequestParam("user_phone") String user_phone,
			@RequestParam("old_password") String old_password, @RequestParam("new_password") String new_password,
			HttpServletRequest request, HttpServletResponse response) {
		JulieResult result = new JulieResult();
		User user = getUserForPhone(user_phone);
		if (user != null) {
			if (StringUtils.equals(user.getUser_password(), old_password)) {
				user.setUser_password(new_password);
				Map<String, Object> map = new HashMap<>();
				map.put("user_password", new_password);
				userMapper.resetPassword(map);
				User newUser = getUserForPhone(user_phone);
				if (newUser != null) {
					result.setSuccess(true);
					result.setMsg(MsgConfig.USER_ALERT_PASSWORD_SUCCESS);
					return result;
				} else {
					result.setErrorCode(CodeConfig.SERVICE_ERROR);
					result.setMsg(MsgConfig.USER_ALERT_PASSWORD_FAIL);
					return result;
				}
			} else {
				result.setErrorCode(CodeConfig.SERVICE_ERROR);
				result.setMsg(MsgConfig.USER_ALERT_PASSWORD_ERROR);
				return result;
			}
		} else {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.COMMON_USER_ACCOUNT_IS_NOT_EXIST);
			return result;
		}
	}

	/**
	 * resetPassword
	 * @param user_phone
	 * @param user_password
	 * @param httpServletRequest
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)
	public JulieResult resetPassword(@RequestParam("user_phone") String user_phone,
			@RequestParam("user_password") String user_password, HttpServletRequest httpServletRequest,
			HttpServletResponse response) {
		JulieResult result = new JulieResult();
		User user = getUserForPhone(user_phone);
		if (user != null) {
			Map<String, Object> map = new HashMap<>();
			map.put("user_phone", user_phone);
			map.put("user_password", user_password);
			userMapper.resetPassword(map);
			if (StringUtils.equals(getUserForPhone(user_phone).getUser_password(), user_password)) {
				result.setSuccess(true);
				result.setMsg(MsgConfig.USER_RESET_PASSWORD_SUCCESS);
				return result;
			} else {
				result.setErrorCode(CodeConfig.SERVICE_ERROR);
				result.setMsg(MsgConfig.USER_RESET_PASSWORD_FAIL);
				return result;
			}
		} else {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.COMMON_USER_ACCOUNT_IS_NOT_EXIST);
			return result;
		}
	}

	/**
	 * queryUserIsExist
	 * @param phone
	 * @param request
	 * @param response
	 * @return
	 */
	public boolean queryUserIsExist(String user_phone) {
		User user = getUserForPhone(user_phone);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * getUserForPhone
	 * @param user_phone
	 * @return
	 */
	public User getUserForPhone(String user_phone) {
		return userMapper.selectUser(user_phone);
	}
}
