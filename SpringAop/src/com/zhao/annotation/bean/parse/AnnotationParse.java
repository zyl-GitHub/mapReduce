package com.zhao.annotation.bean.parse;

import java.lang.reflect.Method;

import com.zhao.annotation.PrivilegeInfo;

public class AnnotationParse
{
	public static String parse(Class targetClassName,String methodName) throws Exception
	{
		Method method = targetClassName.getMethod(methodName);
		String methodAccess = "";
		if(method.isAnnotationPresent(PrivilegeInfo.class))
		{
			PrivilegeInfo privilegeInfo = method.getAnnotation(PrivilegeInfo.class);
			methodAccess = privilegeInfo.name();
		}
		return methodAccess;
	}
}
