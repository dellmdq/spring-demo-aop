package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	//let's start with an @Before advice
	
	//fully qualified name com.luv2code.aopdemo.dao.AccountDAO
	/**@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")//pointcut expression. predicate expression where advice should be applied. On AccountDAO class only.
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ======> Executing @Before advice on addAccount()");
	}*/

	/**@Before("execution(public void addAccount())")//pointcut expression. predicate expression where advice should be applied. On ALL addAccount executions on ANY CLASS.
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ======> Executing @Before advice on addAccount()");
	}*/
	
	/**@Before("execution(public void add*())")//pointcut expression. predicate expression where advice should be applied. On ANY METHOD starting with add on ANY CLASS.
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ======> Executing @Before advice on method");
	}*/

	
	//remember modifier is optional. * (wildcard)
	/**@Before("execution(void add*())")//execution only on void return methods on ANY METHOD starting with add on ANY CLASS.
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ======> Executing @Before advice on method");
	}*/
	
	/**@Before("execution(* add*())") //ANY RETURN TYPE, on ANY METHOD starting with add on ANY CLASS. WILDCARDS!!!
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ======> Executing @Before advice on method");
	}*/
	
	//with one parameter
	/*@Before("execution(* add*(com.luv2code.aopdemo.Account))") //ANY RETURN TYPE, on ANY METHOD starting with add ON ANY CLASS with a ACCOUNT CLASS object as PARAMETER.
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ======> Executing @Before advice on method");
	}*/
	
	//breaking it without using the fully qualified classname
	/*@Before("execution(* add*(Account))") //ANY RETURN TYPE, on ANY METHOD starting with add ON ANY CLASS with a ACCOUNT CLASS object as PARAMETER.
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ======> Executing @Before advice on method");
	}*/
	
	//with more than one parameter
	/*@Before("execution(* add*(com.luv2code.aopdemo.Account,..))") //ANY RETURN TYPE, on ANY METHOD starting with add ON ANY CLASS with a ACCOUNT CLASS object as PARAMETER and ANY NUMBER OF PARAMETER.
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ======> Executing @Before advice on method");
	}*/
	
	//passing any parameter amount
	/*@Before("execution(* add*(..))") //ANY RETURN TYPE, on ANY METHOD starting with add ON ANY CLASS and ANY NUMBER OF PARAMETERS.
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ======> Executing @Before advice on method");
	}*/
	
	//Match methods in a given Package!
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") //ANY RETURN TYPE, Any class,method, and any parameter ONLY WITHIN SPECIFIC PACKAGE.
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ======> Executing @Before advice on method");
	}
}
