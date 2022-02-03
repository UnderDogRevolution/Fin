package com.movie.sns.common.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class BeforeAspect {
	
	
	public static String previousUrl;
	
	
	@Before("execution(* com.movie.sns.member.controller.MemberController.login(..))")
	public void getPreviousUrl(Joinpoint jp) {
		
		System.out.println("aop 실행");
		
	}
	
	
	

}
