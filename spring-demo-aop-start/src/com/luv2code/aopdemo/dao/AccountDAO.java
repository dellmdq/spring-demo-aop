package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	public void addAccount() {
		
		System.out.println(getClass() + ": Doing my DB work: addding account.\n");
	
	}
	
	//one parameter
	public void addAccount(Account theAccount) {
		
		System.out.println(getClass() + ": Doing my DB work: addding account.\n");
	
	}
	
	//more than one parameter
	public void addAccount(Account theAccount, boolean vipFlag) {
		
		System.out.println(getClass() + ": Doing my DB work: addding account. VIP Member.\n");
	
	}
	
	//more than one parameter
	public boolean doWork() {
		
		System.out.println(getClass() + ": doWork()\n");
		return false;
	}

}
