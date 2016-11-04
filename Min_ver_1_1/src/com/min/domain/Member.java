package com.min.domain;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	private int member_id;
	private int membercategory_id;
	private String email;
	private String nickname;
	private int mypoint;
	private String regdate;
	
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public int getMembercategory_id() {
		return membercategory_id;
	}
	public void setMembercategory_id(int membercategory_id) {
		this.membercategory_id = membercategory_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getMypoint() {
		return mypoint;
	}
	public void setMypoint(int mypoint) {
		this.mypoint = mypoint;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
