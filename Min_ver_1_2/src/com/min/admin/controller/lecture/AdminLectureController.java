package com.min.admin.controller.lecture;

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
import com.min.domain.Lecture;
import com.min.domain.LectureCategory;
import com.min.lecture.service.LectureService;

@Controller
@RequestMapping("/admin/")
public class AdminLectureController {
	@Autowired
	private LectureService lectureService;
	PagingManager pm = new PagingManager();
	
	@RequestMapping("insertlec.do")
	public ModelAndView getLectureCategory(){
		List list=lectureService.getLectureCategoryAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("admin/lecture_insert");
		return mav;
	}
	
	@RequestMapping("addlec.do")
	public ModelAndView insert(Lecture lecture , HttpServletRequest request){
		lectureService.insert(lecture);
		lecture.setLecture_id(lectureService.getLastInsertId());
		int curLectureNum = lectureService.getCurLectureNum(lecture);

		LectureCategory lectureCategory = lectureService.getLectureCategory(lecture.getLecturecategory_id());
		List listLecCat = lectureService.getLectureCategoryAll();
		
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/data/file/lec/");
		
		MultipartFile file = lecture.getLectureSlideFile();
		String originName = file.getOriginalFilename();

		if(!originName.equals("")){
			String fileExt = originName.substring(originName.lastIndexOf("."), originName.length());
			String fileName = "["+lectureCategory.getTitle()+"] "+Integer.toString(curLectureNum)+"_lecture_slide"+fileExt;
			try {
				file.transferTo(new File(realPath+fileName));
				lecture.setLecturefile(fileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		file = lecture.getHomeworkFile();
		originName = file.getOriginalFilename();
		
		if(!originName.equals("")){
			String fileExt = originName.substring(originName.lastIndexOf("."), originName.length());
			String fileName = "["+lectureCategory.getTitle()+"] "+Integer.toString(curLectureNum)+"_homework"+fileExt;
			try {
				file.transferTo(new File(realPath+fileName));
				lecture.setHomework(fileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		lectureService.update(lecture);
		lectureService.increaseNumOfLecture(lecture.getLecturecategory_id());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lecture", lecture);
		mav.addObject("listLecCat", listLecCat);
		mav.setViewName("admin/lecture_detail");
		return mav;
	}
	
	@RequestMapping("listlec.do")
	public ModelAndView selectAll(HttpServletRequest request){
		int lecturecategory_id = Integer.parseInt(request.getParameter("select"));
		List listLec = null;
		if(lecturecategory_id == 0){
			listLec = lectureService.selectAll();
		}else{
			listLec = lectureService.selectAll(lecturecategory_id);
		}
		
		List listLecCat = lectureService.getLectureCategoryAll();
		request.setAttribute("list", listLec);
		pm.init(request);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("listLec", listLec);
		mav.addObject("listLecCat", listLecCat);
		mav.addObject("pm", pm);
		mav.addObject("select", lecturecategory_id);
		mav.setViewName("admin/lecture_list");
		return mav;
	}
	
	@RequestMapping("detaillec.do")
	public ModelAndView select(HttpServletRequest request){
		int lecture_id = Integer.parseInt(request.getParameter("lecture_id"));
		Lecture lecture = lectureService.select(lecture_id);
		List listLecCat = lectureService.getLectureCategoryAll();
		ModelAndView mav = new ModelAndView();
		mav.addObject("lecture", lecture);
		mav.addObject("listLecCat", listLecCat);
		mav.setViewName("admin/lecture_detail");
		return mav;
	}
	
	@RequestMapping("modifylec.do")
	public ModelAndView update(Lecture lecture , HttpServletRequest request){
		int curLectureNum = lectureService.getCurLectureNum(lecture);
		LectureCategory lectureCategory = lectureService.getLectureCategory(lecture.getLecturecategory_id());
		List listLecCat = lectureService.getLectureCategoryAll();
		
		ServletContext application = request.getServletContext();
		String realPath = application.getRealPath("/data/file/lec/");
		
		MultipartFile file = lecture.getLectureSlideFile();
		String originName = file.getOriginalFilename();
		
		if(!originName.equals("")){
			System.out.println("here1");
			String fileExt = originName.substring(originName.lastIndexOf("."), originName.length());
			String fileName = "["+lectureCategory.getTitle()+"] "+Integer.toString(curLectureNum)+"_lecture_slide"+fileExt;
			try {
				file.transferTo(new File(realPath+fileName));
				lecture.setLecturefile(fileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		file = lecture.getHomeworkFile();
		originName = file.getOriginalFilename();
		
		if(!originName.equals("")){
			System.out.println("here2");
			String fileExt = originName.substring(originName.lastIndexOf("."), originName.length());
			String fileName = "["+lectureCategory.getTitle()+"] "+Integer.toString(curLectureNum)+"_homework"+fileExt;
			try {
				file.transferTo(new File(realPath+fileName));
				lecture.setHomework(fileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("lecture_id: "+lecture.getLecture_id());
		System.out.println("lecturecategory_id: "+lecture.getLecturecategory_id());
		System.out.println("title: "+lecture.getTitle());
		System.out.println("content: "+lecture.getContent());
		System.out.println("link: "+lecture.getLink());
		System.out.println("thumnail: "+lecture.getThumbnail());
		System.out.println("lecturefile: "+lecture.getLecturefile());
		System.out.println("homework: "+lecture.getHomework());
		lectureService.update(lecture);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("lecture", lecture);
		mav.addObject("listLecCat", listLecCat);
		mav.setViewName("admin/lecture_detail");
		return mav;
	}
	
	@RequestMapping("deletesomelec.do")
	@ResponseBody
	public void deleteSome(@RequestBody List<Map<String, Object>> list){
		int lecture_id = 0;
		Lecture lecture = null;
		for(int i=0; i<list.size(); ++i){
			lecture_id = Integer.parseInt(list.get(i).get("lecture_id").toString());
			lecture = lectureService.select(lecture_id);
			lectureService.decreaseNumOfLecture(lecture.getLecturecategory_id());
			lectureService.delete(lecture_id);
		}
	}
	
	@RequestMapping("deleteonelec.do")
	@ResponseBody
	public void deleteSome(@RequestBody Map<String, Object> map){
		int lecture_id = Integer.parseInt(map.get("lecture_id").toString());
		Lecture lecture = lectureService.select(lecture_id);
		lectureService.decreaseNumOfLecture(lecture.getLecturecategory_id());
		lectureService.delete(lecture_id);
	}
}
