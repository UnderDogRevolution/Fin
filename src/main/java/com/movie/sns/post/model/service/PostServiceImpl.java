package com.movie.sns.post.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.member.model.vo.Member;
import com.movie.sns.post.model.dao.PostDAO;
import com.movie.sns.post.model.vo.Tag;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostDAO dao;	

	@Override
	public List<Tag> selectTag(String tagName) {
		return dao.selectTag(tagName);
	}

	@Override
	public List<Member> selectUser(String tagName) {
		return dao.selectUser(tagName);
	}
	
	
}
