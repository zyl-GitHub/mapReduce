package com.zhao.spring.di.xml.constructor;

public class Customer
{
	private String name;
	private String sex;
	public Customer(String name, String sex)
	{
		this.name = name;
		this.sex = sex;
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
	@Override
	public String toString()
	{
		return "Customer [name=" + name + ", sex=" + sex + "]";
	}
	
}
