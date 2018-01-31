package com.zhao.spring.ioc.createObject;

public class HelloWorldFactory
{
	
	public static HelloWorld getHelloWorld()
	{
		return new HelloWorld();
	}
}
