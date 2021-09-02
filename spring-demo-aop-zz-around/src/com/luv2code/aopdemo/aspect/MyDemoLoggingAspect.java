package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		//print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @Around on method: " + method);
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//now, let's execute the method
		Object result = theProceedingJoinPoint.proceed();
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//compute duration and display it
		long duration = end - begin;
		System.out.println("\n====> Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
		
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findsAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @After (finally) on method: " + method);
	} 
	
	@AfterThrowing(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findsAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @AfterThrowing on method: " + method);

		//log the exception
		System.out.println("\n====>  The exception is: " + theExc);
	}

	//add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning(
			pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findsAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		//print out which methods we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @AfterReturning on method: " + method);
		
		//print out the results of the method call
		System.out.println("\n====> result is: " + result);
		
		//lets post-process the data... lets modify it 
		
		//convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
		System.out.println("\n====> result is: " + result);
		
		
		
	}
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		for(Account tempAccount : result) {
			//get the uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			//update the name on the account
			tempAccount.setName(theUpperName);
		}
		
	}


	@Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDaoPackageNoGetterSetter()") 
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>> Executing @Before advice on method");
		
		//display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		//display method arguments
		
			//get args
		Object[] args = theJoinPoint.getArgs();
			//loop thru args
		for(Object tempArg : args) {
			System.out.println(tempArg);//print account and boolean parameters
			
			if(tempArg instanceof Account) {
				//downcast and print account specific info. (didnt modify toString method)
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
		
		
	}
	

	

	
	
	
	
}
