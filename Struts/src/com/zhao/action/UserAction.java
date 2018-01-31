package com.zhao.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zhao.pojo.User;

public class UserAction extends ActionSupport  implements ModelDriven<User>
{
	private User user = new User();

	
	public String captcha()
	{
		return "captcha";
	}
	public String login()
	{
		return "login";
	}
	public String login_in()
	{
		
		System.out.println(user.getCode()+":"+user.getUsername()+":"+user.getPassword());
		return "success";
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	@Override
	public User getModel()
	{
		return user;
	}
	@Override
	public void validate()
	{

	}
	
}
