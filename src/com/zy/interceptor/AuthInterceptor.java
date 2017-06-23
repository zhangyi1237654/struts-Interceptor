package com.zy.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class AuthInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		ActionContext context = ActionContext.getContext();
		
		Map<String, Object> session = context.getSession();
		
		if(session.get("loginInfo") != null){
			String result = invocation.invoke();
			
			return result;
			
		}else{
			
			return "login";
			
		}
	}

}
