package com.zhao.domain;

import java.io.Serializable;
import java.util.Set;

public class Classes implements Serializable
{
	private Long cid;
	private String name;
	private Set<Student> students;
	public Long getCid()
	{
		return cid;
	}
	public void setCid(Long cid)
	{
		this.cid = cid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Set<Student> getStudents()
	{
		return students;
	}
	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}
}
