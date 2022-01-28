package com.movie.sns.post.controller;
// 이승윤

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
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
		Post post = new Post();
		post.setMemberNo(1);
		post.setPostContent((String)postVO.get("postContent"));
		
		List<String> tagArr = (List<String>)postVO.get("tagArr");

		Map<String, Object> movieMap = new HashMap<String, Object>();
		movieMap = (Map<String, Object>)postVO.get("movie");
		Movie temp = new Movie();
		Movie movie = (Movie)Util.convertMapToObject(movieMap, temp);
		movie.setMemberNo(1);
		
		String webPath = "/resources/images/post/";
		
		String serverPath = session.getServletContext().getRealPath(webPath);
		
		int result = service.insertPost(post, tagArr, movie, fileList, webPath, serverPath);
		
		return result;
	}
}
