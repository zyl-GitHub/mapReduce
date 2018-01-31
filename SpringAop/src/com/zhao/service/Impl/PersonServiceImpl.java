package com.zhao.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhao.annotation.PrivilegeInfo;
import com.zhao.dao.PersonDao;
import com.zhao.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService
{
	@Autowired
	private PersonDao personDao;
	@Override
	@PrivilegeInfo(name="haha")
	public void savePerson()
	{
		personDao.savePerson();
	}

}
