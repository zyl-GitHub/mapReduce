package com.zhao.spring.di.xml.setter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Person
{
	private Long pid;
	private String name;
	private Student student;
	private List list;
	private Set sets;
	private Map map;
	private Object[] objects;
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
	public Student getStudent()
	{
		return student;
	}
	public void setStudent(Student student)
	{
		this.student = student;
	}
	public List getList()
	{
		return list;
	}
	public void setList(List list)
	{
		this.list = list;
	}
	public Set getSets()
	{
		return sets;
	}
	public void setSets(Set sets)
	{
		this.sets = sets;
	}
	public Map getMap()
	{
		return map;
	}
	public void setMap(Map map)
	{
		this.map = map;
	}
	public Object[] getObjects()
	{
		return objects;
	}
	public void setObjects(Object[] objects)
	{
		this.objects = objects;
	}
	@Override
	public String toString()
	{
		return "Person [pid=" + pid + ", name=" + name + ", student=" + student
				+ ", list=" + list + ", sets=" + sets + ", map=" + map
				+ ", objects=" + Arrays.toString(objects) + "]";
	}
}
