package com.zhao.spring.di.xml.setter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DIXMLSetterTest
{
	@Test
	public void testDI_XML_Setter_Test()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("di.xml");
		Person person = (Person)ac.getBean("person");
		System.out.println(person.toString());
	}
}
