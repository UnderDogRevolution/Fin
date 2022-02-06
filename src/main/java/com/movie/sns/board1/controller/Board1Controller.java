package com.movie.sns.board1.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.movie.sns.board1.model.Service.Board1Service;
import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.vo.Post;

@Controller
@RequestMapping("/board1/*")
@SessionAttributes({ "loginMember" })

public class Board1Controller {

	@Autowired
	private Board1Service service;

	@RequestMapping(value = "myBoard/{memberNo}", method = RequestMethod.GET )
	public String myboard(@PathVariable("memberNo") int memberNo, Model model,  HttpSession session
			) {

		
		Member member = service.selectProfile(memberNo);
		model.addAttribute("memberName", member.getMemberName());

		



		return "board1/myBoard";
	}
	
	@ResponseBody
	@RequestMapping(value = "myBoard/{memberNo}/post", method = RequestMethod.GET)
	public String selectPost(@PathVariable("memberNo") int memberNo, String mode, Model model, HttpSession session) {

		System.out.println("mode: "  + mode);
		List<Post> list = null;
		
		if("post".equals(mode)) {
			System.out.println("*****gd*****");
			// 게시글 목록 조회 Service 호출
			list = service.selectList(memberNo);
	
			model.addAttribute("pList", list);
			
			
			
			System.out.println("=====================================================");
			System.out.println(list);
			System.out.println(memberNo);

		}else if("save".equals(mode)){
			list = service.selectLike(memberNo);
			

			System.out.println("=====================================================");
			System.out.println(list);
			System.out.println(memberNo);


		}
		return new Gson().toJson(list);

		
		
	}
	
//	@ResponseBody
//	@RequestMapping(value = "myBoard/{memberNo}/save", method = RequestMethod.GET)
//	public String selectSave(@PathVariable("memberNo") int memberNo , Model model, HttpSession session) {
//		
//		// 저장된 목록 조회 Service 호출
//		
//		
//	}
	
	
}
