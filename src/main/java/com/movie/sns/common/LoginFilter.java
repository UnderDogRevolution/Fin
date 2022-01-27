package com.movie.sns.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.sns.member.model.vo.Member;


// 로그인 하면 접근 못하도록하는 url


 

@WebFilter(	filterName = "loginFilter" ,
			urlPatterns = { "/member/login", "/member/signUp" } )
public class LoginFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("필터 실행");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		// 로그인이 되어있는 경우
		if(loginMember != null) {
			
			// 피드 홈으로 보내도록 주소 변경하기
			System.out.println("[로그인 필터 적용] 피드 페이지로 이동");
			resp.sendRedirect(req.getContextPath()+"/main");
			
		}else {
			
			chain.doFilter(request, response);
			
		}
		
		
		
	}

	public void destroy() {
		
	}
	
	
	
	
	
}


