package com.zhao.spring.ioc.scope;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ScopeTest
{
	@Test
	public void testScope_Default()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		HelloWorld helloWorld1 = (HelloWorld) ac.getBean("helloWorld");
		HelloWorld helloWorld2 = (HelloWorld) ac.getBean("helloWorld");
	}
	@Test
	public void testScope_Prototype()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		HelloWorld helloWorld1 = (HelloWorld) ac.getBean("helloWorld");
		HelloWorld helloWorld2 = (HelloWorld) ac.getBean("helloWorld");
	}
	@Test
	public void testScope_Prototype_Lazy_Default()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("scope.xml");
		HelloWorld helloWorld1 = (HelloWorld) ac.getBean("helloWorld");
		HelloWorld helloWorld2 = (HelloWorld) ac.getBean("helloWorld");
	}
	
}
