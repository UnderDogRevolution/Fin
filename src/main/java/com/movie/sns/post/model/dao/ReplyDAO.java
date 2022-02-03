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

	public List<Reply> selectReply(int postNo) {
		return sqlSession.selectList("replyMapper.selectReply", postNo);
	}

	public int insertComment(Reply reply) {
		return sqlSession.insert("replyMapper.insertComment", reply);
	}

}
