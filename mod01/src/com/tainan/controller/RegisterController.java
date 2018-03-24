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

		//�غc�@��DataSource����
		BasicDataSource dataSource=new BasicDataSource();
		//1.�]�wurl(�s���r��)
		dataSource.setUrl("jdbc:mysql://localhost:3306/gjun");
		//2.���JDriver
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//3�]�w�n�J�b���P�K�X
		dataSource.setUsername("root");
		dataSource.setPassword("1111");
		//�غcDAO����(��Ӫ���Φ�����)
		IDao<User> dao=new UsersDao();
		//�`�J���ʪ��� DataSource
		dao.setDataSource(dataSource);
		
		boolean r=dao.selectForObject(this.user);
		if(r){
			//���ҳq�L
			//�o�X����(�e�ݪ��ACookie)
			Cookie cookie=new Cookie("cred",user.getUserName());
			//Cookie�����g��Response(����???)
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