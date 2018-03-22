
package com.vincent.julie.controller;

import com.vincent.julie.bean.JulieResult;
import com.vincent.julie.bean.MemoBean;
import com.vincent.julie.config.CodeConfig;
import com.vincent.julie.config.MsgConfig;
import com.vincent.julie.dao.MemoMapper;
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
import java.util.List;
import java.util.Map;

/**
 * @Title: MemoController.java
 * @Package com.vincent.julie.controller
 * @Description: MemoController
 * @author: Vinent QQ:1032006226
 * @version V1.0
 */
@Controller
@RequestMapping("/user/memo")
public class MemoController {

	@Autowired
	private MemoMapper memoMapper;
	private static final Logger LOGGER = LoggerFactory.getLogger(MemoController.class);

	@ResponseBody
	@RequestMapping(value = "addMemo", method = RequestMethod.POST)
	public JulieResult addMemo(@RequestParam("user_id") Integer user_id, @RequestParam("memo_title") String memo_title,
			@RequestParam("memo_content") String memo_content, @RequestParam("memo_target_time") String memoTargetTime,
			HttpServletRequest request, HttpServletResponse response) {
		JulieResult result = new JulieResult();
		if (user_id == 0) {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.MEMO_ADD_TITLE_USER_ID_NULL);
			return result;
		}
		if (StringUtils.isEmpty(memo_title)) {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.MEMO_ADD_TITLE_IS_NULL);
			return result;
		}
		if (StringUtils.isEmpty(memoTargetTime)) {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.MEMO_ADD_TITLE_TARGET_TIME_NULL);
			return result;
		}
		if (StringUtils.isEmpty(memo_content)) {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.MEMO_ADD_TITLE_CONTENT_NULL);
			return result;
		}
		MemoBean memo = getMemoFromMemoTitle(user_id, memo_title);
		if (memo != null) {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.MEMO_ADD_TITLE_EXIST);
			return result;
		}
		memo = new MemoBean();
		memo.setUser_id(user_id);
		memo.setMemo_content(memo_content);
		memo.setMemo_title(memo_title);
		memo.setMemo_target_time(memoTargetTime);
		memoMapper.addMemo(memo);
		MemoBean newMemo = getMemoFromMemoTitle(user_id, memo_title);
		if (newMemo != null) {
			result.setSuccess(true);
			return result;
		}
		result.setErrorCode(CodeConfig.SERVICE_ERROR);
		result.setMsg(MsgConfig.MEMO_ADD_FAIL);
		return result;
	}

	/**
	 * @param user_id
	 * @param request
	 * @param response
	 */
	@ResponseBody
	@RequestMapping(value = "getAllMemo", method = RequestMethod.GET)
	public JulieResult getAllMemo(@RequestParam("user_id") Integer user_id, HttpServletRequest request,
			HttpServletResponse response) {
		JulieResult result = new JulieResult();
		if (user_id == null) {
			result.setErrorCode(CodeConfig.SERVICE_ERROR);
			result.setMsg(MsgConfig.MEMO_ADD_TITLE_USER_ID_NULL);
			return result;
		}
		LOGGER.info("user_id=" + user_id);
		List<MemoBean> data = memoMapper.getMemoAll(user_id);
		if (data != null && data.size() > 0) {
			result.setSuccess(true);
			result.setData(data);
			return result;
		}
		result.setSuccess(true);
		result.setMsg(MsgConfig.MEMO_SELECT_ALL_IS_NULL);
		return result;
	}

	/**
	 * @param userId
	 * @param memoTitle
	 * @return
	 */
	private MemoBean getMemoFromMemoTitle(int userId, String memoTitle) {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", userId);
		map.put("memo_title", memoTitle);
		return memoMapper.getMemoFromTitle(map);
	}
}
