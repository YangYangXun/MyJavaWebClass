package com.tainan.controller;

import com.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterController extends ActionSupport {
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	public String valid() {
		// TODO Auto-generated method stub
//		System.out.println("�ϥΪ̦W��:"+user.userName);
		//���ҳq�L
		return "ok";
	}
	
	
}