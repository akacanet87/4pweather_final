package com.min.admin.controller.lecturecategory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.min.common.PagingManager;
import com.min.domain.LectureCategory;
import com.min.lecturecategory.service.LectureCategoryService;

@Controller
@RequestMapping("/admin/")
public class AdminLectureCategoryController {
	@Autowired
	private LectureCategoryService lectureCategoryService;
	
	private PagingManager pm = new PagingManager();
	
	@RequestMapping("listleccat.do")
	public ModelAndView selectAll(HttpServletRequest request){
		List list=lectureCategoryService.selectAll();
		request.setAttribute("list", list);
		pm.init(request);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.addObject("pm", pm);
		mav.setViewName("admin/lecture_category_list");
		return mav;
	}
	
	@RequestMapping("addleccat.do")
	public ModelAndView insert(LectureCategory lectureCategory, HttpServletRequest request) {
		lectureCategoryService.insert(lectureCategory);
		int lecturecategory_id = lectureCategoryService.lastInsertId();
		
		MultipartFile imgFile = lectureCategory.getImgFile();
		MultipartFile summaryImgFile = lectureCategory.getSummaryImgFile();
		String fileImgName = summaryImgFile.getOriginalFilename();
		String fileImgNameExt = fileImgName.substring(fileImgName.lastIndexOf("."), fileImgName.length());
		
		String fileSummaryImgName = summaryImgFile.getOriginalFilename();
		String fileSummaryImgNameExt = fileSummaryImgName.substring(fileSummaryImgName.lastIndexOf("."), fileSummaryImgName.length());

		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/data/img/lec_cat/");
		String imgFilePath = "img_" + Integer.toString(lecturecategory_id) + fileImgNameExt;
		String summaryImgFilePath = "sum_" + Integer.toString(lecturecategory_id) + fileSummaryImgNameExt;

		try {
			imgFile.transferTo(new File(realPath+imgFilePath));
			summaryImgFile.transferTo(new File(realPath+summaryImgFilePath));
			lectureCategory.setLectureCategory_id(lecturecategory_id);
			lectureCategory.setImg(imgFilePath);
			lectureCategory.setSummaryimg(summaryImgFilePath);
			lectureCategoryService.update(lectureCategory);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lecturecategory", lectureCategory);
		mav.setViewName("admin/lecture_category_detail");
		return mav;
	}
	
	@RequestMapping("detailleccat.do")
	public ModelAndView select(HttpServletRequest request){
		int lectureCategory_id = Integer.parseInt(request.getParameter("lecturecategory_id"));
		LectureCategory lectureCategory =  lectureCategoryService.select(lectureCategory_id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lectureCategory", lectureCategory);
		mav.setViewName("admin/lecture_category_detail");
		return mav;
	}
	@RequestMapping("modifyleccat.do")
	public ModelAndView modify(LectureCategory lectureCategory, HttpServletRequest request){
		MultipartFile imgFile = lectureCategory.getImgFile();
		MultipartFile summaryImgFile = lectureCategory.getSummaryImgFile();

		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/data/img/lec_cat/");
		System.out.println(realPath);
		if(imgFile.getOriginalFilename() != ""){
			String fileName = imgFile.getOriginalFilename();
			String fileExt = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			String FilePath = "img_" + Integer.toString(lectureCategory.getLectureCategory_id()) + fileExt;
			try {
				imgFile.transferTo(new File(realPath+FilePath));
				lectureCategory.setImg(FilePath);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if(summaryImgFile.getOriginalFilename() != ""){
			String fileName = summaryImgFile.getOriginalFilename();
			String fileExt = fileName.substring(fileName.lastIndexOf("."), fileName.length());
			String FilePath = "sum_" + Integer.toString(lectureCategory.getLectureCategory_id()) + fileExt;
			try {
				summaryImgFile.transferTo(new File(realPath+FilePath));
				lectureCategory.setSummaryimg(FilePath);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		lectureCategoryService.update(lectureCategory);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lectureCategory", lectureCategory);
		mav.setViewName("admin/lecture_category_detail");
		return mav;
	}
	
	@RequestMapping("deletesomeleccat.do")
	@ResponseBody
	public void deleteSome(@RequestBody List<Map<String, Object>> list){
		for(int i=0; i<list.size(); ++i)
			lectureCategoryService.delete(Integer.parseInt(list.get(i).get("lecturecategory_id").toString()));
	}
	
	@RequestMapping("deleteoneleccat.do")
	@ResponseBody
	public void deleteOne(@RequestBody Map<String, Object> map){
		lectureCategoryService.delete(Integer.parseInt(map.get("lecturecategory_id").toString()));
	}
}
