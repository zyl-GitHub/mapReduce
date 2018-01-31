package com.zhao.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class SqlTest
{
	@Test
	public void testFindUserById() throws IOException
	{
		InputStream stream = Resources.getResourceAsStream("sqlMapConfig.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
		SqlSession session = sessionFactory.openSession();
		session.selectOne("","");
		session.close();
	}
}
