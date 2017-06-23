package com.zy.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zy.po.User;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport implements ModelDriven<User>,SessionAware{
	
	private User user = new User();
	private Map<String, Object> session ;

	@Override
	public User getModel() {
		return user;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	/**
	 * 处理登陆请求
	 */
	public String login(){
		
		if("admin".equals(user.getUsername())
				&& "123".equals(user.getPassword())){
			session.put("loginInfo", user.getUsername());
			return SUCCESS;
		}else{
			session.put("loginError", "用户名或密码不正确");
			return ERROR;
		}
		
	}
	
	
}
