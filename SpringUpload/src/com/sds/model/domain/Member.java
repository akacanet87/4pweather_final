package com.sds.model.domain;

import org.springframework.web.multipart.MultipartFile;

public class Member {
	
	private int member_id;
	private String id;
	private String password;
	private String profile;
	private MultipartFile myFile;			//	html ���� ������Ʈ ��� ��ġ�ؾ� �ڵ����� ä����
	private Asset asset;
	
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public MultipartFile getMyFile() {
		return myFile;
	}
	public void setMyFile(MultipartFile myFile) {
		this.myFile = myFile;
	}
	public Asset getAsset() {
		return asset;
	}
	public void setAsset(Asset asset) {
		this.asset = asset;
	}
	
		
}
