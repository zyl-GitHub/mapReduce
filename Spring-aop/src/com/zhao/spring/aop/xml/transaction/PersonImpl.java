package com.zhao.spring.aop.xml.transaction;

import org.springframework.stereotype.Repository;

@Repository
public class PersonImpl implements PersonDao
{

	@Override
	public void savePerson()
	{
		System.out.println("save person");

	}

}
