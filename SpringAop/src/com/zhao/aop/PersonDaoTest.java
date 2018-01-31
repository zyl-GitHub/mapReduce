package com.zhao.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhao.dao.PersonDao;

public class PersonDaoTest
{
	@Test
	public void testAop()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonDao personDao = (PersonDao)ac.getBean("personDao");
		personDao.savePerson();
	}
}
