package com.movie.sns.post.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
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

	@RequestMapping(value="select", method = RequestMethod.POST)
	@ResponseBody
	public String selectReply(Reply reply, HttpSession session ) {
		int memberNo = 0;
		if(session.getAttribute("loginMember") != null) {
			memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			
		}
		reply.setMemberNo(memberNo);
		List<Reply> replyList = service.selectReply(reply);
		
		return new Gson().toJson(replyList);
	}

	@RequestMapping(value="comment", method = RequestMethod.POST)
	@ResponseBody
	public int insertComment(Reply reply, @ModelAttribute("loginMember") Member loginMember) {
		reply.setMemberNo(loginMember.getMemberNo());
		int result = service.insertComment(reply);
		
		return result;
	}

	@RequestMapping(value="insertReplyLike", method = RequestMethod.POST)
	@ResponseBody
	public int insertReplyLike(Reply reply, @ModelAttribute("loginMember") Member loginMember) {
		reply.setMemberNo(loginMember.getMemberNo());
		int result = service.insertReplyLike(reply);
		
		return result;
	}

	@RequestMapping(value="deleteReplyLike", method = RequestMethod.POST)
	@ResponseBody
	public int deleteReplyLike(Reply reply, @ModelAttribute("loginMember") Member loginMember) {
		reply.setMemberNo(loginMember.getMemberNo());
		int result = service.deleteReplyLike(reply);
		
		return result;
	}

	@RequestMapping(value="deleteReply", method = RequestMethod.POST)
	@ResponseBody
	public int deleteReply(int replyNo) {
		int result = service.deleteReply(replyNo);
		
		return result;
	}

}
