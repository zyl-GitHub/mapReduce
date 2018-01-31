package com.zhao.springboot.javaconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	@Autowired
	private UserDao userDao;
	public List<User> quertUserList()
	{
		return userDao.queryUserList();
	}
}
