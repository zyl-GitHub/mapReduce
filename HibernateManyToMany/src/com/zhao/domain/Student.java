package com.zhao.domain;

import java.io.Serializable;
import java.util.Set;

public class Student implements Serializable
{
	private Long sid;
	private String name;
	private Set<Classes> classes;
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
	public Set<Classes> getClasses()
	{
		return classes;
	}
	public void setClasses(Set<Classes> classes)
	{
		this.classes = classes;
	}
}
