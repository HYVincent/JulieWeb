package com.vincent.julie.controller;

import com.vincent.julie.bean.JulieResult;
import com.vincent.julie.bean.VersionBean;
import com.vincent.julie.config.CodeConfig;
import com.vincent.julie.config.MsgConfig;
import com.vincent.julie.dao.VersionMapper;
import com.vincent.julie.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title:  VersionController.java
 * @Package com.vincent.julie.controller
 * @Description:    TODO(用一句话描述该文件做什么)
 * @author: Vinent QQ:1032006226
 * @date:   2018年3月18日 下午9:04:18
 * @version V1.0
 * @Copyright: 2018
 * 注意：本内容仅限于是我写的
 */
@Controller
@RequestMapping("/version")
public class VersionController {

	@Autowired
	private VersionMapper versionMapper;

	/**
	 * 添加新版本
	 * @param version_code
	 * @param version_codes
	 * @param version_desc
	 * @param filePath
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "addVersion",method = RequestMethod.POST)
	public  JulieResult addVersion(@RequestParam("version_code")int version_code, @RequestParam("version_codes")String version_codes,
											@RequestParam("version_desc")String version_desc, @RequestParam("version_file_path")String filePath, HttpServletRequest request, HttpServletResponse response) {

		JulieResult julieResult = new JulieResult();
		if(StringUtils.isEmpty(version_desc)){
			julieResult.setMsg(MsgConfig.VERSION_DESC_IS_NULL);
			julieResult.setSuccess(false);
			julieResult.setErrorCode(CodeConfig.SERVICE_NORMAL);
			return julieResult;
		}
		VersionBean versionBean = new VersionBean();
		versionBean.setVersion_code(version_code);
		versionBean.setVersion_codes(version_codes);
		versionBean.setVersion_desc(version_desc);
		versionBean.setVersion_file_path(filePath);
		versionMapper.addVersion(versionBean);
		julieResult.setSuccess(true);
		julieResult.setMsg(MsgConfig.VERSION_ADD_NEW_VERSION_SUCCESS);
		julieResult.setErrorCode(CodeConfig.SERVICE_NORMAL);
		return julieResult;
	}

	/**
	 * 检查新版本
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "checkNewVersion",method = RequestMethod.GET)
	public JulieResult checkNewVersion(@RequestParam("version")int version,HttpServletRequest request,HttpServletResponse response) {
		JulieResult julieResult = new JulieResult();
		VersionBean versionBean = getVersion();
		if(versionBean.getVersion_code() == version){
			julieResult.setSuccess(false);
			julieResult.setMsg(MsgConfig.VERSION_VERSION_LATEST);
			return julieResult;
		}
		julieResult.setSuccess(true);
		julieResult.setData(versionBean);
		return julieResult;
	}

	/**
	 *
	 * @param version
	 * @return
	 */
	public VersionBean getVersion(){
		return versionMapper.getLatestVersion();
	}

	/**
	 * 查询某个版本
	 * @param version_code
	 * @return
	 */
	public VersionBean getVersion(int version_code){
		return versionMapper.getVersion(version_code);
	}

	/**
	 * 删除某个id对应的版本
	 * @param versionId
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "deleteIdVersion",method = RequestMethod.POST)
	public  JulieResult deleteIdVersion(@RequestParam("version_code")int version_code,HttpServletRequest request,HttpServletResponse response) {
		JulieResult julieResult = new JulieResult();
		VersionBean versionBean = getVersion(version_code);
		if(versionBean == null){
			julieResult.setSuccess(false);
			julieResult.setMsg(MsgConfig.VERSION_DELETE_VERSION_NOT_EXIST);
			return julieResult;
		}
		versionMapper.deleteIdVersion(version_code);
		VersionBean versionBean1 = getVersion(version_code);
		if(versionBean1 == null){
			julieResult.setSuccess(true);
			julieResult.setMsg(MsgConfig.VERSION_DELETE_VERSION_SUCCESS);
			return julieResult;
		}
		julieResult.setSuccess(false);
		julieResult.setMsg(MsgConfig.VERSION_DELETE_VERSION_FAIL);
		return julieResult;
	}

}
