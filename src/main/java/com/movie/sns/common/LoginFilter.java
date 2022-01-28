package com.movie.sns.common;

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
		
			
		// ---------------- 비회원인 경우 ----------------
		if(loginMember == null) {
			
			// 비회원 + /member/* 인 경우
			if(arr[0].equals("member")) {
				
				// 비회원 + /member/login , /member/signUp , member/findPw 인 경우
				if(arr[1].equals("login") || arr[1].equals("signUp") ||arr[1].equals("findPw")) {
					chain.doFilter(request, response);
				}else {
					// 그 외에는 모두 로그인페이지로
					System.out.println("[필터] : 잘못된 접근입니다. 로그인페이지로 이동합니다.");
					resp.sendRedirect(req.getContextPath() + "/member/login");
				}
				
			// 비회원 + /chat/* 인 경우
			}else if(arr[0].equals("chat")) {
				
				System.out.println("[필터] : 잘못된 접근입니다. 로그인페이지로 이동합니다.");
				resp.sendRedirect(req.getContextPath() + "/member/login");
				
			// 비회원 + 나머지 페이지
			}else {
				chain.doFilter(request, response);
			}
			
			
			
		// ---------------- 회원인 경우 ----------------
		}else {
			
			if(arr[0].equals("member")) {
				
				// 회원 + /member/login , /member/signUp , member/findPw 인 경우
				if(arr[1].equals("login") || arr[1].equals("signUp") ||arr[1].equals("findPw")) {
					resp.sendRedirect(req.getContextPath());
					// resp.sendRedirect(req.getContextPath()+"/main");
				}else {
					chain.doFilter(request, response);
				}
				
			}else {
				chain.doFilter(request, response);
			}
			
		}
		
//			// 피드 홈으로 보내도록 주소 변경하기
//			System.out.println("[로그인 필터 적용] 피드 페이지로 이동");
//			resp.sendRedirect(req.getContextPath()+"/main");
//			
//			// 로그인 페이지로 보내버리기 + sweet alert 가능하면 사용
//			System.out.println("[로그인 필터 적용] 로그인 페이지로 이동");
//			resp.sendRedirect(req.getContextPath()+"/member/login");
		
	}

	public void destroy() {
		
	}
	
	
	
	
	
}


