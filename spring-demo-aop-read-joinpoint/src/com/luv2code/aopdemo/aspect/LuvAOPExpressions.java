package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAOPExpressions {//to share this common expressions with other aspects.
	
	//pointcut declaration
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")//ANY RETURN TYPE, Any class,method, and any parameter ONLY WITHIN SPECIFIC PACKAGE.
	public void forDaoPackage() {}
	
	//create pointcut for getter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")//match methods starting with get
	public void getter() {}
 	
	//create pointcut for setter methods
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")//match methods starting with set
	public void setter() {}
	
	//create pointcut to include package, and exclude getter/setters. COMBINATION!
	@Pointcut("forDaoPackage() && !(getter() || setter())")//excluding setters and getters from advice execution
	public void forDaoPackageNoGetterSetter() {}
	
}
