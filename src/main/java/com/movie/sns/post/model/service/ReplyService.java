package com.movie.sns.post.model.service;

import java.util.List;

import com.movie.sns.post.model.vo.Reply;

public interface ReplyService {

	int insertReply(Reply reply);

	List<Reply> selectReply(Reply reply);

	int insertComment(Reply reply);

	int insertReplyLike(Reply reply);

	int deleteReplyLike(Reply reply);

	int deleteReply(int replyNo);

}
