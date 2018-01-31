package com.zhao.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AListener implements ServletContextListener
{

	@Override
	public void contextDestroyed(ServletContextEvent event)
	{
		System.out.println("走了");

	}

	@Override
	public void contextInitialized(ServletContextEvent event)
	{
		System.out.println("来了");
	}

}
