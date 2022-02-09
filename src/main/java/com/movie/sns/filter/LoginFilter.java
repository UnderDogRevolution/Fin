package com.movie.sns.filter;

import java.io.IOException;
import java.util.Arrays;

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


@WebFilter(	filterName = "loginFilter" ,
			urlPatterns = { "/member/*", "/chat/*" } )
// member/* , 글쓰기,수정,삭제,북마크 등등   chat/* 
// main/* , admin/* 추가 예정 
public class LoginFilter implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("필터 실행");
	}
	
	

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		String[] arr = uri.substring( (contextPath +"/").length()).split("/");	
		
		HttpSession session = req.getSession();
		Member loginMember = (Member)session.getAttribute("loginMember");
		
		// 관리자 필터
		
		// ---------------- 비로그인  ----------------
		if(loginMember == null) {
			
			// 비회원 + /member/* 인 경우
			if(arr[0].equals("member")) {
				
				// 회원만 이용 가능한 주소 값
				if(		arr[1].equals("myPage") || 
						arr[1].equals("update") || 
						arr[1].equals("updatePw") || 
						arr[1].equals("secession") || 
						arr[1].equals("ask") 
					) {
					System.out.println("[필터] : 잘못된 접근입니다. 로그인페이지로 이동합니다.");
					resp.sendRedirect(req.getContextPath() + "/member/login");
				}else {
					chain.doFilter(request, response);
				}
				
				
				
			// 비회원 + /chat/* 인 경우
			}else if(arr[0].equals("chat")) {
				
				System.out.println("[필터] : 잘못된 접근입니다. 로그인페이지로 이동합니다.");
				resp.sendRedirect(req.getContextPath() + "/member/login");
				
			// 비회원 + 나머지 페이지
			}else {
				chain.doFilter(request, response);
			}
			
			
			
		// ---------------- 로그인 ----------------
		}else {
			
			if(arr[0].equals("member")) {
				
				// 회원 + /member/login , /member/signUp , member/findPw 인 경우
				if(arr[1].equals("login") || arr[1].equals("signUp") ||arr[1].equals("findPw") || arr[1].equals("resetPw") ) {
					resp.sendRedirect(req.getContextPath());
					// resp.sendRedirect(req.getContextPath()+"/main");
				}else {
					chain.doFilter(request, response);
				}
				
			}else {
				chain.doFilter(request, response);
			}
			
		}
		
	}

	
	
	public void destroy() {
		
	}
	
	
	
	
	
}


