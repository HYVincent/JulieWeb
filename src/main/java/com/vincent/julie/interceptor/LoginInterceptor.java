package com.vincent.julie.interceptor;


import com.alibaba.fastjson.JSON;
import com.vincent.julie.config.CodeConfig;
import com.vincent.julie.config.MsgConfig;
import com.vincent.julie.netty.NettyServerHandler;
import com.vincent.julie.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @Title: LoginInterceptor.java
 * @Package com.vincent.julie
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: Vinent QQ:1032006226
 * @date: 2018年3月17日 下午4:45:20
 * @version V1.0
 * @Copyright: 2018 注意：本内容仅限于是我写的
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		LOGGER.debug("cookies length->"+request.getCookies().length);
		/*String requestSessionId = request.getRequestedSessionId();
		HttpSession session = request.getSession();
		String sessionId = request.getRequestedSessionId();
		Object o = request.getSession().getAttribute("API_TOKEN");
		String headToken = request.getHeader("API_TOKEN");
		LOGGER.debug("服务器API_TOKEN="+String.valueOf(o));
		LOGGER.debug("客户端API_TOKEN="+headToken);
		System.out.println("服务器API_TOKEN ="+String.valueOf(o));
		System.out.println("客户端API_TOKEN ="+headToken);
		if (StringUtils.isEmpty(headToken)) {
			ResponseUtils.renderJsonDataFail(response, CodeConfig.USER_NO_LOGIN,
					MsgConfig.USER_NEED_LOGIN);
			return false;
		} else if(headToken.equals(String.valueOf(o))) {
			return true;
		}
		ResponseUtils.renderJsonDataFail(response, CodeConfig.USER_LOGIN_STATUS_EXECEPTION,
				MsgConfig.COMMON_USER_LOGIN_STATUS_EXCEPTION);*/
		return true;
	}
}
