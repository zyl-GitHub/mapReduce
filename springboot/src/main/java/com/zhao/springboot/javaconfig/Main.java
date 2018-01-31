package com.zhao.springboot.javaconfig;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		UserService userService = context.getBean(UserService.class);
		
		List<User> list = userService.quertUserList();
		for(User user : list)
		{
			System.out.println(user.getUsername()+":"+user.getPassword());
		}
		context.destroy();;
	}
}
