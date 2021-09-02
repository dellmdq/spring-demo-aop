package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call methods to find the accounts
		List<Account> theAccounts = null;
		
		try{
			boolean tripWire = false;
			theAccounts = theAccountDAO.findsAccounts(tripWire);
		}
		catch (Exception exc){
			System.out.println("\n\nMain Program caught exception: " + exc);
		}
		
		//display the accounts
		System.out.println("\n\nMain Program: AfterThrowingDemoApp");
		System.out.println("-----");
		
		System.out.println("The accounts are:\n" + theAccounts);
		
		System.out.println("\n");
		
		//close context
		context.close();
		
	}

}
