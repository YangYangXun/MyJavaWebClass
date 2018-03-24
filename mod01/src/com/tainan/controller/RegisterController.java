package com.tainan.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.model.IDao;
import com.model.User;
import com.model.UsersDao;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterController extends ActionSupport implements ServletResponseAware {
	
	private User user;
	private HttpServletResponse response;
	
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

		//建構一個DataSource物件
		BasicDataSource dataSource=new BasicDataSource();
		//1.設定url(連接字串)
		dataSource.setUrl("jdbc:mysql://localhost:3306/gjun");
		//2.載入Driver
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//3設定登入帳號與密碼
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		//建構DAO物件(兩個物件形成互動)
		IDao<User> dao=new UsersDao();
		//注入互動物件 DataSource
		dao.setDataSource(dataSource);
		
		boolean r=dao.selectForObject(this.user);
		if(r){
			//驗證通過
			//發出憑證(前端狀態Cookie)
			Cookie cookie=new Cookie("cred",user.getUserName());
			//Cookie必須經由Response(互動???)
			response.addCookie(cookie);
			return "ok";
		}else
		{
			return "failure";
		}
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=response;
	}
	
	
}