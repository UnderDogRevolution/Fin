package com.movie.sns.common.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {

	
	private Logger logger = LoggerFactory.getLogger(AroundAspect.class);
	
	@Around("PointcutCollection.serviceImplPointcut()")
	public Object aroundControllerLog(ProceedingJoinPoint pp) throws Throwable{
		
		
		// 클래스명
		String className = pp.getTarget().getClass().getSimpleName(); 
      
		// 메소드명
		String methodName = pp.getSignature().getName();  

		String str = "";
      
		str += "[Service]" +  className + "-" + methodName + "()";
		
		long startMs = System.currentTimeMillis(); // 서비스 시작 시의 ms 값
		
		
		Object obj = pp.proceed();
		
		
		long endMs = System.currentTimeMillis(); // 서비스 종료 시의 ms 값
		
		// 걸린 시간
		str += " [Running Time]" + (endMs - startMs) + "ms";
		
		// 서비스 수행 시 사용된 파라미터
		str += " [Param]" + Arrays.toString(pp.getArgs());
		
		logger.debug(str);
		
		
		return obj;

	}
	
	
}
