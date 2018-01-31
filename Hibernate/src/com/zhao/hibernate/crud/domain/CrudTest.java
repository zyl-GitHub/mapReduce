package com.zhao.hibernate.crud.domain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class CrudTest
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
	public void testSave()
	{
		Person person = new Person();
		person.setName("趙胤龍");
		person.setSex("男");
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(person);
		transaction.commit();
		session.close();
		
	}
	@Test
	public void testQueryAllPerson()
	{
		Session session = sessionFactory.openSession();
		List<Person> list = session.createQuery("from "+Person.class.getSimpleName()).list();
		System.out.println(list.get(0).getName());
		session.close();
	}
	@Test
	public void testQueryPersonById()
	{
		Session session = sessionFactory.openSession();
		Person person = (Person) session.get(Person.class, 1L);
		System.out.println(person.getName());
		session.close();
	}
	@Test
	public void testUpdate()
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person) session.get(Person.class, 1L);
		person.setName("王浩然");
		session.update(person);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void testDelete()
	{
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Person person = (Person) session.get(Person.class, 1L);
		session.delete(person);
		transaction.commit();
		session.close();
	}
	
}
