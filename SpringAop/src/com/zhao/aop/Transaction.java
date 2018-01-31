package com.zhao.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;

import com.zhao.annotation.bean.parse.AnnotationParse;
@Repository
@Aspect
public class Transaction
{
	@Pointcut("execution(* com.zhao.service.Impl.PersonServiceImpl.*(..))" )
	public void pointcut(){}
	@Before("pointcut()")
	public void beginTransaction()
	{
		System.out.println("begin transaction");
	}
	@After("pointcut()")
	public void commit()
	{
		System.out.println("commit");
	}
	@Around("pointcut()")
	public Object accessMethod(ProceedingJoinPoint joinPoint) throws Throwable
	{
		Class targetClass = joinPoint.getTarget().getClass();
		String targetMethodName = joinPoint.getSignature().getName();
		String message = AnnotationParse.parse(targetClass, targetMethodName);
		if(message == "")
		{
			return joinPoint.proceed();
		}
		System.out.println("權限不足");
		return null;
	}
}
