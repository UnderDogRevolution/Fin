package com.movie.sns.post.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.sns.common.Util;
import com.movie.sns.post.model.dao.ReplyDAO;
import com.movie.sns.post.model.vo.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO dao;
	
	@Override
	public int insertReply(Reply reply) {
//		reply.setReplyContent(Util.XSS(reply.getReplyContent()));
//		reply.setReplyContent(Util.changeNewLine(reply.getReplyContent()));
		return dao.insertReply(reply);
	}

	@Override
	public List<Reply> selectReply(Reply reply) {
		return dao.selectReply(reply);
	}

	@Override
	public int insertComment(Reply reply) {
		return dao.insertComment(reply);
	}

	@Override
	public int insertReplyLike(Reply reply) {

		int result = dao.checkDupReplyLike(reply);
		if(result == 0) {
			result = dao.insertReplyLike(reply);
			result = dao.plusReplyLike(reply);
		}
		return  result;
	}

	@Override
	public int deleteReplyLike(Reply reply) {
		
		
		int result = dao.checkDupReplyLike(reply);
		if(result == 1) {
			result = dao.deleteReplyLike(reply);
			result = dao.minusReplyLike(reply);
		}
		return result;
	}

	@Override
	public int deleteReply(int replyNo) {
		return dao.deleteReply(replyNo);
	}
	
	
	
}
