package com.zhao.Action;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhao.service.PersonService;


public class PersonAction
{	
	@Autowired
	private PersonService personService;
	public void savePerson()
	{
		personService.savePerson();
	}
}
