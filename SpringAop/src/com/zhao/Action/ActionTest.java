package com.zhao.Action;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActionTest
{
	@Test
	public void actionTest()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		PersonAction personAction = (PersonAction)ac.getBean("personAction");
		personAction.savePerson();
	}
}
