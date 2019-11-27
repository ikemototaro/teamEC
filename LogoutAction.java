package com.internousdev.pumpkin.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;

	public String execute(){
		String userId = String.valueOf(session.get("userId"));
		/*真偽値にはログイン時のtrueが入っている*/
		boolean savedUserIdFlag = Boolean.valueOf(String.valueOf(session.get("savedUserIdFlag")));
		session.clear();
		/*ID保存のチェックボックスにチェックが入っているならばIDを保存*/
		if(savedUserIdFlag){
			session.put("savedUserIdFlag", savedUserIdFlag);
			session.put("userId", userId);
		}
		return SUCCESS;
	}

	public Map<String,Object>getSession(){
		return session;
	}
	public void setSession(Map<String,Object>session){
		this.session = session;
	}
}
