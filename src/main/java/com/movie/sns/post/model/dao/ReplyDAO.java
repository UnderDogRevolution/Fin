package com.movie.sns.post.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.sns.post.model.vo.Reply;

@Repository
public class ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public int insertReply(Reply reply) {
		return sqlSession.insert("replyMapper.insertReply", reply);
	}

	public List<Reply> selectReply(Reply reply) {
		return sqlSession.selectList("replyMapper.selectReply", reply);
	}

	public int insertComment(Reply reply) {
		return sqlSession.insert("replyMapper.insertComment", reply);
	}

	public int insertReplyLike(Reply reply) {
		return sqlSession.insert("replyMapper.insertReplyLike", reply);
	}

	public int deleteReplyLike(Reply reply) {
		return sqlSession.delete("replyMapper.deleteReplyLike", reply);
	}

	public int checkDupReplyLike(Reply reply) {
		return sqlSession.selectOne("replyMapper.checkDupReplyLike", reply);
	}

	public int plusReplyLike(Reply reply) {
		return sqlSession.update("replyMapper.plusReplyLike", reply);
	}

	public int minusReplyLike(Reply reply) {
		return sqlSession.update("replyMapper.minusReplyLike", reply);
	}

}
