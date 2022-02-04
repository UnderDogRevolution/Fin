package com.movie.sns.post.controller;
// 이승윤

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.movie.sns.common.Util;
import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.service.PostService;
import com.movie.sns.post.model.vo.Movie;
import com.movie.sns.post.model.vo.Post;
import com.movie.sns.post.model.vo.Tag;


@Controller
@RequestMapping("/post/*")
@SessionAttributes({"loginMember"})
public class PostContoller {
	@Autowired
	private PostService service;
	
	
	@RequestMapping(value="searchTag", method = RequestMethod.POST)
	@ResponseBody
	public String searchTag(String tagName) {
		List<Tag> tagList = service.selectTag(tagName);
		
		return new Gson().toJson(tagList);
	}

	@RequestMapping(value="searchUser", method = RequestMethod.POST)
	@ResponseBody
	public String searchUser(String tagName) {
		List<Member> tagList = service.selectUser(tagName);
		
		return new Gson().toJson(tagList);
	}
	@RequestMapping(value="insert", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public int postInsert(@RequestPart(value = "key") Map<String, Object> postVO,
						  @RequestPart(value="image", required = false) List<MultipartFile> fileList,
						  HttpSession session
						 ) {
		postVO.put("memberNo", ((Member)session.getAttribute("loginMember")).getMemberNo());
		String webPath = "/resources/images/post/";
		
		String serverPath = session.getServletContext().getRealPath(webPath);
		
		int result = service.insertPost(postVO, fileList, webPath, serverPath);
		
		return result;
	}
	
	@RequestMapping(value="postView", method = RequestMethod.GET)
	@ResponseBody
	public String selectPostList(HttpSession session ){
		int memberNo = 0;
		if(session.getAttribute("loginMember") != null) {
			memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			
		}
		List<Post> listPost = service.selectPostList(memberNo);
		
		
		return new Gson().toJson(listPost);
	}
	
	@RequestMapping(value="insertLike", method = RequestMethod.POST)
	@ResponseBody
	public int insertLike(int postNo, HttpSession session){
		
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		
		return service.insertLike(postNo, memberNo);
	}
	
	@RequestMapping(value="deleteLike", method = RequestMethod.POST)
	@ResponseBody
	public int deleteLike(int postNo, HttpSession session){
		
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		
		return service.deleteLike(postNo, memberNo);
		
	}
	
	@RequestMapping(value="deletePost", method = RequestMethod.POST)
	@ResponseBody
	public int deletePost(int postNo){
		
		
		return service.deletePost(postNo);
		
	}
}
