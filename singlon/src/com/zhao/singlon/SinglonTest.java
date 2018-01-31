package com.zhao.singlon;

import org.junit.Test;

public class SinglonTest
{
	@Test
	public void testCreateSinglon()
	{
		Resource resource = EnumSinglon.INSTANCE.getInstance();
	}
}
