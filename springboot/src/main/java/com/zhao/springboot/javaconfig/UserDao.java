package com.zhao.springboot.javaconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
@Repository
public class UserDao
{
	public List<User> queryUserList()
	{
		List<User> result = new ArrayList<>();
		for(int i = 0;i<10;i++)
		{
			User user = new User();
			user.setUsername("username"+i);
			user.setPassword("password"+i);
			user.setAge(i);
			result.add(user);
		}
		return result;
	}
}
