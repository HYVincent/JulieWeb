
package com.vincent.julie.bean;

import java.io.Serializable;

/**
 * @author chenpy-1072
 * @desc JulieResult
 * @date 2018/3/19 15:04
 * @see
 */
public class JulieResult<T> implements Serializable {

	private static final long serialVersionUID = 2884051241350863563L;
	private T data;
	private String msg;
	private Integer errorCode;
	private boolean isSuccess;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean success) {
		isSuccess = success;
	}
}
