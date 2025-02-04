package com.min.domain;

import org.springframework.web.multipart.MultipartFile;

public class Lecture {
	
	private int lecture_id;
	private int lecturecategory_id;
	private String title;
	private String content;
	private String link;
	private MultipartFile lecturefile;
	private String regdate;
	private int hit;
	
	public int getLecture_id() {
		return lecture_id;
	}
	public void setLecture_id(int lecture_id) {
		this.lecture_id = lecture_id;
	}
	public int getLecturecategory_id() {
		return lecturecategory_id;
	}
	public void setLecturecategory_id(int lecturecategory_id) {
		this.lecturecategory_id = lecturecategory_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public MultipartFile getLecturefile() {
		return lecturefile;
	}
	public void setLecturefile(MultipartFile lecturefile) {
		this.lecturefile = lecturefile;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
}
