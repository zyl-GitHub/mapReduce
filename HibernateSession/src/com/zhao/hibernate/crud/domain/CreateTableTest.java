package com.zhao.hibernate.crud.domain;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;


public class CreateTableTest 
{
	@Test
	public void testCreateTable()
	{
		/**
		 * 加载了Hibernate的配置文件
		 */
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
	}
}