package com.movie.sns.common.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutCollection {
	
	// Pointcut 모아놓기
	
	@Pointcut("execution(* com.movie.sns..*Controller.*(..))")
	public void controllerPointcut() { }

	@Pointcut("execution(* com.movie.sns..*ServiceImpl.*(..))")
	public void serviceImplPointcut() { }
	
}
