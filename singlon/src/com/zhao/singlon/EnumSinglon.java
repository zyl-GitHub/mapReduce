package com.zhao.singlon;

enum EnumSinglon
{
	INSTANCE;
	private Resource resource;

	private EnumSinglon()
	{
		resource = new Resource();
	}
	
	public Resource getInstance()
	{
		return this.resource;
	}
}
