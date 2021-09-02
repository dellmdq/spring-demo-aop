package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	
	public void addAccount() {
		
		System.out.println(getClass() + ": Doing Stuff: Adding a membership account. \n");
	}

	public boolean addSillyMember() {
		
		System.out.println(getClass() + ": Doing Stuff: Adding a silly member. \n");
	
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() +": I'm going to sleep now...");
	}
}
