
package com.vincent.julie.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vincent.julie.config.CodeConfig;
import org.json.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {

	private static ObjectMapper objectMapper;

	/**
	 * renderJsonDataSuccess
	 * @param response
	 * @param statusCode
	 * @param msg
	 * @param dataJson
	 */
	public static void renderJsonDataSuccess(HttpServletResponse response, String msg) {
		try {
			JSONObject responseObj = new JSONObject();
			responseObj.put("success", true);
			responseObj.put("responseCode", CodeConfig.SERVICE_NORMAL);
			responseObj.put("msg", msg);
			response.setCharacterEncoding("utf-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(objectMapper.writeValueAsString(responseObj));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * renderJsonDataSuccess
	 * @param response
	 * @param statusCode
	 * @param msg
	 * @param dataJson
	 */
	public static void renderJsonDataSuccess(HttpServletResponse response, String msg, Object o) {
		try {
			JSONObject responseObj = new JSONObject();
			responseObj.put("success", true);
			responseObj.put("errorCode", CodeConfig.SERVICE_NORMAL);
			responseObj.put("msg", msg);
			responseObj.put("data", o);
			response.setCharacterEncoding("utf-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(objectMapper.writeValueAsString(responseObj));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * renderJsonDataFail
	 * @param response
	 * @param statusCode
	 * @param msg
	 * @param dataJson
	 */
	public static void renderJsonDataFail(HttpServletResponse response, int errorCode, String msg) {
		try {
			JSONObject responseObj = new JSONObject();
			responseObj.put("success", false);
			responseObj.put("errorCode", errorCode);
			responseObj.put("msg", msg);
			response.setCharacterEncoding("utf-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(objectMapper.writeValueAsString(responseObj));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
