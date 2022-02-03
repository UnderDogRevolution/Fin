package com.movie.sns.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.service.ReplyService;
import com.movie.sns.post.model.vo.Reply;

@Controller
@RequestMapping("/reply/*")
@SessionAttributes({"loginMember"})
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	
	@RequestMapping(value="insert", method = RequestMethod.POST)
	@ResponseBody
	public int insertReply(Reply reply, @ModelAttribute("loginMember") Member loginMember ) {
		reply.setMemberNo(loginMember.getMemberNo());
		int result = service.insertReply(reply);
		
		return result;
	}

}
