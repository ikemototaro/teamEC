package com.internousdev.pumpkin.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.pumpkin.dao.MCategoryDAO;
import com.internousdev.pumpkin.dto.MCategoryDTO;
import com.internousdev.pumpkin.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	private Map<String,Object>session;

	public String execute(){

		/*ログインしていない状態では仮ユーザーIDを発行*/
		if(!session.containsKey("logined")){
			session.put("logined",0);
		}
		String tempLogined = String.valueOf(session.get("logined"));
		int logined = "null".equals(tempLogined)? 0 : Integer.parseInt(tempLogined);
		if(!session.containsKey("tempUserId") && logined == 0){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRamdomValue());
		}
		/*カテゴリマスターテーブルの情報を保持していない場合はカテゴリ情報を与える*/
		if(!session.containsKey("mCategoryDTOList")){
			List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
			MCategoryDAO mCategoryDAO = new MCategoryDAO();
			mCategoryDTOList = mCategoryDAO.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
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
