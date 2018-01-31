package com.zhao.spring.di.xml.constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DIXMLCONSTRUCTORTEST
{
	@Test
	public void testDI_XML_Setter_Test()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("di.xml");
		Customer person = (Customer)ac.getBean("customer");
		System.out.println(person.toString());
	}
}
