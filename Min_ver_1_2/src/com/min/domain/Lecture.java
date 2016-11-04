package com.min.domain;

import org.springframework.web.multipart.MultipartFile;

public class Lecture {
	private int lecture_id;
	private int lecturecategory_id;
	private String title;
	private String content;
	private String link;
	private String thumbnail;
	private String homework;
	private String lecturefile;
	private String regdate;
	private int hit;
	private MultipartFile lectureSlideFile;
	private MultipartFile homeworkFile;
	
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
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getHomework() {
		return homework;
	}
	public void setHomework(String homework) {
		this.homework = homework;
	}
	public String getLecturefile() {
		return lecturefile;
	}
	public void setLecturefile(String lecturefile) {
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
	public MultipartFile getHomeworkFile() {
		return homeworkFile;
	}
	public void setHomeworkFile(MultipartFile homeworkFile) {
		this.homeworkFile = homeworkFile;
	}
	public MultipartFile getLectureSlideFile() {
		return lectureSlideFile;
	}
	public void setLectureSlideFile(MultipartFile lectureSlideFile) {
		this.lectureSlideFile = lectureSlideFile;
	}
}
