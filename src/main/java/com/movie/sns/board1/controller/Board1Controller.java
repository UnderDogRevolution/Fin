package com.movie.sns.board1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.movie.sns.board1.model.Service.Board1Service;
import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.vo.Post;







@Controller
@RequestMapping("/board1/*")
@SessionAttributes({"loginMember"})
public class Board1Controller {
	
	@Autowired
	private Board1Service service;
	
	@RequestMapping(value="myBoard/{memberNo}", method=RequestMethod.GET)
	public String myboard(@PathVariable("memberNo") int memberNo, Model model, Member member, HttpSession session, Post post
			) {
		
		

	  member = service.selectProfile(memberNo);
	  model.addAttribute("memberName", member.getMemberName());
	  
	  
	  
//	  String path = null;
//		if(member != null) { // 조회 성공 시 
//			
//			// 게시글 목록 조회 Service 호출
//			List<Post> pList = service.selectList(memberNo);
//			
//			model.addAttribute("pList",pList);
//			
//			
//			path = "board1/myBoard";
//			
//		}else { // 조회 실패 시 
//			
//			path="redirect:../list";
//			
//			
//		}
	  
	  
	  
	  
		
		return "board1/myBoard";
	}
	
	
	
	
	
}
