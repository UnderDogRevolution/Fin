package com.movie.sns.common.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.movie.sns.member.model.vo.Member;

//Aspect : 공통적으로 특정 위치에서 사용될 기능이 작성된 클래스

@Aspect
@Component
public class BeforeAspect {
	
	
	// 로그 (slf4j로 import)
	private Logger logger = LoggerFactory.getLogger(BeforeAspect.class);
	
	@Before("PointcutCollection.controllerPointcut()")
	public void beforeControllerLog(JoinPoint jp) {
		
		// 컨트롤러 수행 전에 로그 출력하기
		
		// 클래스명 얻기
		String className = jp.getTarget().getClass().getSimpleName();
		
		// 메서드명 얻기
		String methodName = jp.getSignature().getName();
		
		// HttpServletRequest 객체 얻기
		HttpServletRequest request = ( (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes() ).getRequest();
		
		// 로그인 회원정보 얻기, 정보가 없는 경우엔 null
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		
		// 로그 변수 생성
		String log = "";
		
		
		// IP 주소는 그냥 가져오지 않았음
		// 편의상 닉네임을 ID로 칭함 (중복 불가능하므로)
		if(loginMember != null) {
			log += "[ID : " + loginMember.getMemberNickName() + "]  ";
		}
		
		log += "[Controller]" + className + "." + methodName + "()";
		
		logger.info(log);
		
	}
	
	
	
	

}





