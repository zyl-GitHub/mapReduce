package com.zhao.spring.aop.xml.transaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
