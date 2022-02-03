package com.movie.sns.post.model.service;

import java.util.List;

import com.movie.sns.post.model.vo.Reply;

public interface ReplyService {

	int insertReply(Reply reply);

	List<Reply> selectReply(int postNo);

	int insertComment(Reply reply);

}
