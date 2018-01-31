package com.zhao.domain;

import java.io.Serializable;

public class Student implements Serializable
{
	private Long sid;
	private String name;
	public Student(){}
	public Student(Long sid)
	{
		this.sid = sid;
	}
	public Long getSid()
	{
		return sid;
	}
	public void setSid(Long sid)
	{
		this.sid = sid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
}
