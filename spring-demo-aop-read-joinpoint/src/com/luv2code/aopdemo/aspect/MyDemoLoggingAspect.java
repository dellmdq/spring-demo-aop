package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
