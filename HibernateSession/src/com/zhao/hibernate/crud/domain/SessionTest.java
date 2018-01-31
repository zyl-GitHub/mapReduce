package com.zhao.hibernate.crud.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class SessionTest
{
	private SessionFactory sessionFactory;
	@Before
	public void createSessionFactory()
	{
		Configuration configuration = new Configuration();
		configuration.configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	@Test
	public void testGet()
	{
		Session session = sessionFactory.openSession();
		session.get(Person.class, 1L);
		session.get(Person.class, 1L);
		session.close();
	}
	@Test
	public void testStatistics()
	{
		Session session = sessionFactory.openSession();
		System.out.println(session.getStatistics().getEntityCount());
		session.get(Person.class, 1L);
		System.out.println(session.getStatistics().getEntityCount());
		session.get(Person.class, 1L);
		System.out.println(session.getStatistics().getEntityCount());
		session.close();
	}
	@Test
	public void testCurrentSession()
	{
		Session session = sessionFactory.getCurrentSession();
		Person person = new Person();
	}
	
}
