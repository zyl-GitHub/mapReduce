/**
 * 
 */
package com.zhao.spring.ioc.createObject;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**   
 *    
 * 项目名称：Spring   
 * 类名称：HelloWorldTest   
 * 类描述：   
 * 创建人：zhao   
 * 创建时间：2018年1月27日 下午3:21:59   
 * @version        
 */
public class HelloWorldTest
{
	@Test
	public void HelloWorld_Default()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("createObject.xml");
		HelloWorld helloWorld = (HelloWorld) ac.getBean("hello");
		helloWorld.hello();
	}
	@Test
	public void HelloWorld_StaticFactory()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("createObject.xml");
		HelloWorld helloWorld = (HelloWorld) ac.getBean("helloFactory");
		helloWorld.hello();
	}
	@Test
	public void HelloWorld_InstanceFactory()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("createObject.xml");
		HelloWorld helloWorld = (HelloWorld) ac.getBean("helloWorld2");
		helloWorld.hello();
	}
	
}	
