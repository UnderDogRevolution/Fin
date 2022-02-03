package com.movie.sns.post.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.post.model.dao.ReplyDAO;
import com.movie.sns.post.model.vo.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO dao;
	
	@Override
	public int insertReply(Reply reply) {
		return dao.insertReply(reply);
	}

	@Override
	public List<Reply> selectReply(int postNo) {
		return dao.selectReply(postNo);
	}

	@Override
	public int insertComment(Reply reply) {
		return dao.insertComment(reply);
	}
	
	
}
