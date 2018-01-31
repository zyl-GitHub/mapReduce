package com.zhao.spring.aop.xml.transaction;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Repository;
@Repository
@Aspect
public class Transaction
{
	@Pointcut("execution(* com.zhao.spring.aop.xml.transaction.PersonImpl.*(..))" )
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
}
