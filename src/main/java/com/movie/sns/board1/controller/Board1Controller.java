package com.movie.sns.board1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping(value = "myBoard/{memberNo}", method = RequestMethod.GET)
	public String myboard(@PathVariable("memberNo") int memberNo, Model model, HttpSession session, Member member) {

		Member loginMember = (Member) session.getAttribute("loginMember");

		member = service.selectProfile(memberNo);

		System.out.println("loginMember:" + loginMember);
		System.out.println(member);
	

		model.addAttribute("member", member);

		if (loginMember != null) {

			int result = followCheck(loginMember.getMemberNo(), memberNo);
			System.out.println("result:" + result);

			model.addAttribute("follow", result);
			
			int result2 = followCount(memberNo);
			
			model.addAttribute("followCount", result2);
			
			int result3 = followerCount(memberNo);
			
			model.addAttribute("followerCount", result3);
			
			int result4 = postCount(memberNo);
			
			model.addAttribute("postCount", result4);
			
		}

		return "board1/myBoard";
	}

	@ResponseBody
	@RequestMapping(value = "myBoard/{memberNo}/post", method = RequestMethod.GET)
	public String selectPost(@PathVariable("memberNo") int memberNo, String mode, Model model, HttpSession session) {

		System.out.println("mode: " + mode);
		List<Post> list = null;

		if ("post".equals(mode)) {
			System.out.println("*****gd*****");
			// 게시글 목록 조회 Service 호출
			list = service.selectList(memberNo);

			model.addAttribute("pList", list);

			// System.out.println("=====================================================");
			// System.out.println(list);
			// System.out.println(memberNo);

		} else if ("save".equals(mode)) {
			list = service.selectLike(memberNo);

			// System.out.println("=====================================================");
			// System.out.println(list);
			// System.out.println(memberNo);

		}
		return new Gson().toJson(list);

	}

	@ResponseBody
	@RequestMapping(value = "myBoard/{memberNo}/insertFollow", method = RequestMethod.GET)
	public int insertFollow(@PathVariable("memberNo") int friendNo, String mode, Model model, HttpSession session,
			Member member) {

		Member loginMember = (Member) session.getAttribute("loginMember");

//		member.setToUser(loginMember.getMemberNo());
//		
//		member.setMemberNo(memberNo);
		int memberNo = loginMember.getMemberNo();

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("memberNo", memberNo);
		map.put("friendNo", friendNo);

		System.out.println(map);

		int result = service.insertFollow(map);

		return result;

	}

	@ResponseBody
	@RequestMapping(value = "myBoard/{memberNo}/deleteFollow", method = RequestMethod.GET)
	public int deleteFollow(@PathVariable("memberNo") int friendNo, String mode, Model model, HttpSession session,
			Member member) {

		Member loginMember = (Member) session.getAttribute("loginMember");
		
		int memberNo = loginMember.getMemberNo();
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("memberNo", memberNo);
		map.put("friendNo", friendNo);

		int result = service.deleteFollow(map);

		return result;

	}

//	 @RequestMapping(value = "myBoard/{memberNo}/check", method = RequestMethod.GET)
//	public int followCheck(@PathVariable("memberNo") int memberNo, Model model, HttpSession session,
//			@ModelAttribute("loginMember") Member loginMember, Member member) {
//		
//		member.setToUser(loginMember.getMemberNo());
//		
//		int result = service.followCheck(member);
//		
//		
//		return result;
//		
//		
//		
//	}

	public int followCheck(int loginMemberNo, int memberNo) {
		Member member = new Member();

		member.setToUser(memberNo);
		member.setMemberNo(loginMemberNo);
		System.out.println(member);
		int result = service.followCheck(member);

		return result;

	}
	
	
	public int followCount( int memberNo) {
		
		
		
		int result = service.followCount(memberNo);
		
		
		return result;
		
		
		
		
		
	}
	
	public int followerCount( int memberNo) {
		
		
		
		int result = service.followerCount(memberNo);
		
		
		return result;
		
		
		
		
		
	}
	
	public int postCount( int memberNo) {
		
		
		
		int result = service.postCount(memberNo);
		
		
		return result;
		
		
		
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "myBoard/{memberNo}/selectFriend", method = RequestMethod.GET)
	public String selectFriend(@PathVariable("memberNo") int memberNo, String mode, Model model, HttpSession session) {

		System.out.println("mode: " + mode);
		List<Member> list = null;

		if ("follow".equals(mode)) {
			System.out.println("*****gd*****");
			// 게시글 목록 조회 Service 호출
			list = service.selectFollow(memberNo);

			model.addAttribute("pList", list);

			// System.out.println("=====================================================");
			// System.out.println(list);
			// System.out.println(memberNo);

		} else if ("follow".equals(mode)) {
			list = service.selectFollower(memberNo);

			// System.out.println("=====================================================");
			// System.out.println(list);
			// System.out.println(memberNo);

		}
		return new Gson().toJson(list);

	}
	
	
	//
	
	
	
//	@ResponseBody
//	@RequestMapping(value = "myBoard/{memberNo}/save", method = RequestMethod.GET)
//	public String selectSave(@PathVariable("memberNo") int memberNo , Model model, HttpSession session) {
//		
//		// 저장된 목록 조회 Service 호출
//		
//		
//	}

}
