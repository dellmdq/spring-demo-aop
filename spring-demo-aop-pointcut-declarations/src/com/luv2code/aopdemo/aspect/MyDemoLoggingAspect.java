package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	//pointcut declaration
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")//ANY RETURN TYPE, Any class,method, and any parameter ONLY WITHIN SPECIFIC PACKAGE.
	private void forDaoPackage() {}
	
	@Before("forDaoPackage()") 
	public void beforeAddAccountAdvice() {
		System.out.println("\n ======> Executing @Before advice on method");
	}
	
	@Before("forDaoPackage()")//this and previous advice will be executed Before any method on dao package.
	public void performAPIAnalytics() {
		System.out.println("\n=====>> Performing API analytics...");
	}
	
	
	
	
}
