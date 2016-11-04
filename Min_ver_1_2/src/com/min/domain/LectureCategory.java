package com.min.domain;

import org.springframework.web.multipart.MultipartFile;

public class LectureCategory {
	private int lectureCategory_id;
	private String title;
	private String instructor;
	private String content;
	private String summary;
	private String img;
	private String summaryimg;
	private int rank;
	private String lang;
	private String ide;
	private int price;
	private int isSummary;
	private int numOfLecture;
	private int sort;
	private MultipartFile imgFile;
	private MultipartFile summaryImgFile;
	
	public int getLectureCategory_id() {
		return lectureCategory_id;
	}
	public void setLectureCategory_id(int lectureCategory_id) {
		this.lectureCategory_id = lectureCategory_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getSummaryimg() {
		return summaryimg;
	}
	public void setSummaryimg(String summaryimg) {
		this.summaryimg = summaryimg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getIde() {
		return ide;
	}
	public void setIde(String ide) {
		this.ide = ide;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getIsSummary() {
		return isSummary;
	}
	public void setIsSummary(int isSummary) {
		this.isSummary = isSummary;
	}
	public int getNumOfLecture() {
		return numOfLecture;
	}
	public void setNumOfLecture(int numOfLecture) {
		this.numOfLecture = numOfLecture;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public MultipartFile getImgFile() {
		return imgFile;
	}
	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}
	public MultipartFile getSummaryImgFile() {
		return summaryImgFile;
	}
	public void setSummaryImgFile(MultipartFile summaryImgFile) {
		this.summaryImgFile = summaryImgFile;
	}
}
