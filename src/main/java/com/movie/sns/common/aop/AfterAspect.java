package com.movie.sns.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterAspect {


	private Logger logger = LoggerFactory.getLogger(AfterAspect.class);
	
	@After("PointcutCollection.controllerPointcut()")
	public void afterControllerLog() {
		
		// 로그 사이에 구분선 넣기
		logger.info("----------------------------------------\n");
		
	}
	
	@AfterReturning(pointcut="PointcutCollection.serviceImplPointcut()", returning = "returnObj")
	public void afterReturnLog(JoinPoint jp, Object returnObj) {
		
		// returnObj이 null이면 errorPage로 강제이동 되므로 조건 걸어주기
		
		// 반환값 출력하기
		if(returnObj != null) {
			
			logger.debug(" [반환값] " + returnObj.toString());
			
		}
		
	}
	
	@AfterThrowing(pointcut="PointcutCollection.serviceImplPointcut()", throwing = "e")
	public void afterExceptionLog(JoinPoint jp, Exception e) {
		
		// 로그에 예외 찍어놓기
		String str = "[Exception]";
		
		if(e instanceof NullPointerException) {
			
			str += "Null 객체를 참조\n";
			
		}else if(e instanceof IllegalArgumentException) {
			
			str += "부적절한 값 입력\n";
			
		}else {
			str += "예외 발생\n";
		}
		
		logger.error(str + e.toString() );
		
	}
	
	
}



