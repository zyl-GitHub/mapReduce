package com.zhao.dao.Impl;

import org.springframework.stereotype.Repository;

import com.zhao.dao.PersonDao;

@Repository
public class PersonImpl implements PersonDao
{

	@Override
	public void savePerson()
	{
		System.out.println("save person");

	}

}
