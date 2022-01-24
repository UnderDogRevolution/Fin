package com.movie.sns.member.model.vo;

public class Email {
	
	private String sender;		// 보내는 사람
	private String subject;		// 메일 제목
	private String content;		// 메일 내용
	private String receiver;	// 받는 사람
	
	public Email() {
		// TODO Auto-generated constructor stub
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "Email [sender=" + sender + ", subject=" + subject + ", content=" + content + ", receiver=" + receiver
				+ "]";
	}
	

}
