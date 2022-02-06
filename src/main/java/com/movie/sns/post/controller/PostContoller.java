package com.movie.sns.post.controller;
// 이승윤

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.movie.sns.post.model.service.ReplyService;
import com.movie.sns.post.model.vo.Movie;
import com.movie.sns.post.model.vo.Post;
import com.movie.sns.post.model.vo.Reply;
import com.movie.sns.post.model.vo.Report;
import com.movie.sns.post.model.vo.Tag;


@Controller
@RequestMapping("/post/*")
@SessionAttributes({"loginMember"})
public class PostContoller {
	@Autowired
	private PostService service;
	@Autowired
	private ReplyService replyService;
	
	
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
	@RequestMapping(value="searchMemberNo", method = RequestMethod.POST)
	@ResponseBody
	public int searchMemberNo(String memberName) {
		int memberNo = service.searchMemberNo(memberName);
		return memberNo;
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
	
	@RequestMapping("view/{postNo}")
	public String postView(@PathVariable("postNo") int postNo, Model model, HttpSession session){
		int memberNo = 0;
		if(session.getAttribute("loginMember") != null) {
			memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			
		}
		Post tempPost = new Post();
		Reply reply = new Reply();
		tempPost.setPostNo(postNo);
		tempPost.setMemberNo(memberNo);
		Post post = service.selectPostOne(tempPost);
		
		reply.setPostNo(postNo);
		reply.setMemberNo(memberNo);
		List<Reply> listReply = replyService.selectReply(reply);
		model.addAttribute("post", post);
		model.addAttribute("listReply", listReply);
		// toString 메소드를 정의해야 EL로 객체를 선언할 시 주소가아닌 형태로 나타난다.
		return "post/postView";
		
	}
	
	@RequestMapping(value="report", method = RequestMethod.POST)
	@ResponseBody
	public int insertReport(Report report, @ModelAttribute("loginMember") Member loginMember){
		report.setMemberNo(loginMember.getMemberNo());
		
		return service.insertReport(report);
		
	}

	@RequestMapping("searchPost")
	@ResponseBody
	public String searchPost(String searchWord, HttpSession session){
		int memberNo = 0;
		if(session.getAttribute("loginMember") != null) {
			memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchWord", searchWord);
		map.put("memberNo", memberNo);
		List<Post> listPost = service.searchPostList(map);
		
		
		return new Gson().toJson(listPost);
		
	}

	@RequestMapping("popularPost")
	@ResponseBody
	public String popularPostList(String searchWord, HttpSession session){
		int memberNo = 0;
		if(session.getAttribute("loginMember") != null) {
			memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchWord", searchWord);
		map.put("memberNo", memberNo);
		List<Post> listPost = service.popularPostList(map);
		
		
		return new Gson().toJson(listPost);
		
	}

	@RequestMapping("searchMovie")
	@ResponseBody
	public String searchMoviePostList(String searchWord, HttpSession session){
		int memberNo = 0;
		if(session.getAttribute("loginMember") != null) {
			memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchWord", searchWord);
		map.put("memberNo", memberNo);
		List<Post> listPost = service.searchMoviePostList(map);
		
		
		return new Gson().toJson(listPost);
		
	}
}
