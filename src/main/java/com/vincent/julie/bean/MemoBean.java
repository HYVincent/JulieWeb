
package com.vincent.julie.bean;

/**
 * @Title: Memo.java
 * @Package com.vincent.julie.bean
 * @Description:MemoBean
 * @author: Vinent QQ:1032006226
 * @date: 2018年2月6日 上午12:18:03
 * @version V1.0
 * @Copyright: 2018 注意：本内容仅限于是我写的
 */
public class MemoBean {

    /**
     * 用户id
     */
	private long user_id;
    /**
     * 用户title
     */
	private String memo_title;
    /**
     * 创建时间
     */
	private String memo_create_time;
    /**
     * 备忘录内容
     */
	private String memo_content;
    /**
     * 是否提醒过了 实际上数据库存的tinyint类型 0为false 1为true
     */
	private boolean memo_action;
    /**
     * 提醒时间
     */
	private String memo_target_time;

	public String getMemo_target_time() {
		return memo_target_time;
	}

	public void setMemo_target_time(String memo_target_time) {
		this.memo_target_time = memo_target_time;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getMemo_title() {
		return memo_title;
	}

	public void setMemo_title(String memo_title) {
		this.memo_title = memo_title;
	}

	public String getMemo_create_time() {
		return memo_create_time;
	}

	public void setMemo_create_time(String memo_create_time) {
		this.memo_create_time = memo_create_time;
	}

	public String getMemo_content() {
		return memo_content;
	}

	public void setMemo_content(String memo_content) {
		this.memo_content = memo_content;
	}

	public boolean isMemo_action() {
		return memo_action;
	}

	public void setMemo_action(boolean memo_action) {
		this.memo_action = memo_action;
	}
}
