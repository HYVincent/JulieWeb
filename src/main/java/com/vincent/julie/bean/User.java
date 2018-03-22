
package com.vincent.julie.bean;

import java.io.Serializable;

/**
 * @Description:  用户实体类
 * @veresion 1.0
 * @author Vincent QQ:1032006226
 * @date   2018年1月27日 上午12:18:50
 */

public class User implements Serializable{

	/**
	 * 序列化Id
	 */
	private static final long serialVersionUID = 1L;

	private String api_token;

	/**
	 * 用户id
	 */
	private int user_id;
	/**
	 * 用户账号
	 */
	private int user_account;
	/**
	 * 用户密码
	 */
	private String user_password;
	/**
	 * 用户手机号码
	 */
	private String user_phone;
	/**
	 * 用户姓名
	 */
	private String user_name;
	/**
	 * 用户头像
	 */
	private String user_head;
	/**
	 * 用户身高
	 */
	private int user_height;
	/**
	 * 用户体重
	 */
	private int user_weight;
	/**
	 * 用户性别
	 */
	private String user_sex;
	/**
	 * 用户生日
	 */
	private String user_birthday;
	/**
	 * 注册时间
	 */
	private String user_create_time;
	/**
	 * 用户登录时间
	 */
	private long user_login_time;
	/**
	 * 用户退出登录
	 */
	private long user_login_out_time;



	public String getApi_token() {
		return api_token;
	}
	public void setApi_token(String api_token) {
		this.api_token = api_token;
	}
	public long getUser_login_time() {
		return user_login_time;
	}
	public void setUser_login_time(long user_login_time) {
		this.user_login_time = user_login_time;
	}
	public long getUser_login_out_time() {
		return user_login_out_time;
	}
	public void setUser_login_out_time(long user_login_out_time) {
		this.user_login_out_time = user_login_out_time;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getUser_account() {
		return user_account;
	}
	public void setUser_account(int user_account) {
		this.user_account = user_account;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_head() {
		return user_head;
	}
	public void setUser_head(String user_head) {
		this.user_head = user_head;
	}
	public int getUser_height() {
		return user_height;
	}
	public void setUser_height(int user_height) {
		this.user_height = user_height;
	}
	public int getUser_weight() {
		return user_weight;
	}
	public void setUser_weight(int user_weight) {
		this.user_weight = user_weight;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_birthday() {
		return user_birthday;
	}
	public void setUser_birthday(String user_birthday) {
		this.user_birthday = user_birthday;
	}
	public String getUser_create_time() {
		return user_create_time;
	}
	public void setUser_create_time(String user_create_time) {
		this.user_create_time = user_create_time;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}




}
