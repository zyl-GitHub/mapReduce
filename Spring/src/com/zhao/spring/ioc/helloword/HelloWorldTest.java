/**
 * 
 */
package com.zhao.spring.ioc.helloword;

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
	public void HelloWorld()
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld = (HelloWorld) ac.getBean("hello");
		helloWorld.hello();
	}
}	
