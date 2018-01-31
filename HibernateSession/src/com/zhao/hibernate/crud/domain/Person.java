package com.zhao.hibernate.crud.domain;

import java.io.Serializable;

public class Person implements Serializable
{
	private Long pid;
	private String name;
	private String sex;
	public Long getPid()
	{
		return pid;
	}
	public void setPid(Long pid)
	{
		this.pid = pid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}
}
