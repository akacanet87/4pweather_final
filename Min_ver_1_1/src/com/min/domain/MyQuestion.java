package com.min.domain;

public class MyQuestion {
	
	private int myquestion_id;
	private int lecture_id;
	private int member_id;
	private String content;
	private String replyer;
	private String reply;
	private String regdate;
	
	public int getMyquestion_id() {
		return myquestion_id;
	}
	public void setMyquestion_id(int myquestion_id) {
		this.myquestion_id = myquestion_id;
	}
	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
