package com.zhao.domain;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;
/**
 * 
*    
* 项目名称：HibernateOnToMany-single   
* 类名称：OntoManySingleTest   
* 类描述：   
* 创建人：zhao   
* 创建时间：2018年1月28日 下午1:57:42   
* @version
 */
public class OntoManySingleTest
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
	public void testSaveClasses()
	{
		Classes classes = new Classes();
		classes.setName("1班");
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(classes);
		transaction.commit();
	}
	@Test
	public void testSaveStudent()
	{
		Student student = new Student();
		student.setName("小明");
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
	}
	@Test
	public void testSaveClassesAndStudent()
	{
		Classes classes = new Classes();
		classes.setName("2班");
		Student student = new Student();
		student.setName("小紅");
		Set<Student> students = new HashSet<Student>();
		students.add(student);
		classes.setStudents(students);
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		session.save(classes);
		transaction.commit();
	}
	@Test
	public void testSaveClassesAndUpdateStudent()
	{
		Classes classes = new Classes();
		classes.setName("3班");
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, 1L);
		Set<Student> students = new HashSet<Student>();
		students.add(student);
		classes.setStudents(students);
		session.save(classes);
		transaction.commit();
		
	}
	@Test
	public void testUpdateClassesAndUpdateStudent()
	{
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, 1L);
		
		
		transaction.commit();
	}
	@Test
	public void testHql()
	{
		Session session = sessionFactory.openSession();
		//session.createQuery("from "+Student.class.getSimpleName() ).list();
		
		//带构造函数的查询
		//String query = "select new "+Student.class.getName()+"(sid) from "+Student.class.getSimpleName();
		//session.createQuery(query).list();
		
		//带参数查询
		/*Query query = session.createQuery("from Student where name=? and sid=?");
		query.setParameter(0, "王浩然");
		query.setParameter(1, 1L);
		query.list();*/
		Query query = session.createQuery("from Student where name=:name and sid=:sid");
		query.setParameter("name", "王浩然");
		query.setParameter("sid", 1L);
		query.list();
		session.close();
	}
	
}

