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
	
	//create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")//match methods starting with get
	private void getter() {}
 	
	//create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")//match methods starting with set
	private void setter() {}
	
	//create pointcut to include package, and exclude getter/setters. COMBINATION!
	@Pointcut("forDaoPackage() && !(getter() || setter())")//excluding setters and getters from advice execution
	private void forDaoPackageNoGetterSetter() {}
	
	
	@Before("forDaoPackageNoGetterSetter()") 
	public void beforeAddAccountAdvice() {
		System.out.println("\n=====>> Executing @Before advice on method");
	}
	
	@Before("forDaoPackageNoGetterSetter()")//this and previous advice will be executed Before any method on dao package.
	public void performAPIAnalytics() {
		System.out.println("\n=====>> Performing API analytics...");
	}
	
	
	
	
}
