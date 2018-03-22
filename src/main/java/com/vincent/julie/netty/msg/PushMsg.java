
package com.vincent.julie.netty.msg;

/**
 * @Project: schoolmallapi
 * @ClassName: PushMsg
 * @Description: 推�?�消息类
 * @author: chenpy
 * @version 1.0.0
 */
public class PushMsg extends BaseMsg {

	private String account;
	private String content;

	public PushMsg() {
		super();
		setType(MsgType.PUSH);
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
