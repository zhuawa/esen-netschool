package com.esen.netschool.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/page")
public class PageController {
	
	@Value("${rms.mainPath}")
	String mainPath;
	
	@Value("${rms.coursewaremgrPath}")
    String coursewaremgrPath;
	
	@Value("${rms.learnresourcesmgrPath}")
    String learnresourcesmgrPath;
	
	@Value("${lms.courseCenterListPath}")
    String courseCenterListPath;
	
	@Value("${lms.mycoursePath}")
    String myCoursePath;
	
	@Value("${lms.coursefavoritesPath}")
    String courseFavoritesPath;
	
	@Value("${live.teacherPath}")
    String teacherPath;
	
	@Value("${live.studentPath}")
    String studentPath;
	
	@Value("${bbs.bbsPath}")
    String bbsPath;
	
	@Value("${rms.examquestionPath}")
    String examquestionPath;
	
	@Value("${rms.testpaperPath}")
    String testpaperPath;
	
	@Value("${rms.questionbankPath}")
    String questionbankPath;
	
	@RequestMapping(value="/rms/{key}")
	public String rmsPage(@PathVariable(value="key", required=false)String key, HttpServletRequest req) {
		if(key==null || key.equals("")) {
			req.setAttribute("url", mainPath);
		}else if("coursewaremgr".equals(key)) {
			req.setAttribute("url", coursewaremgrPath);
			return "/netschool-rms/index";
		}else if("learnresourcesmgr".equals(key)) {
			req.setAttribute("url", learnresourcesmgrPath);
			return "/pages/leanresourcesmgr/leanresourcesmgr.ftl";
		}else if("examquestionmgr".equals(key)) {//试题管理
			req.setAttribute("url", examquestionPath);
		}else if("testpapermgr".equals(key)) {//试卷管理
			req.setAttribute("url", testpaperPath);
		}else if("questionbankmgr".equals(key)) {//题库管理
			req.setAttribute("url", questionbankPath);
		}
		return "rmsPage";
	}
	
	@RequestMapping(value="/courseCenter/{key}")
	public String courseCenterPage(@PathVariable(value="key", required=false)String key, HttpServletRequest req) {
		if(key==null || key.equals("")) {//课程中心(默认为课程检索页面)
			req.setAttribute("url", courseCenterListPath);
		}else if("courselist".equals(key)) {//课程检索
			req.setAttribute("url", courseCenterListPath);
		}else if("mycourse".equals(key)) {//我的课程
			req.setAttribute("url", myCoursePath);
		}else if("coursefavorites".equals(key)) {//课程收藏夹
			req.setAttribute("url", courseFavoritesPath);
		}
		return "/netschool-coursecenter/index";
	}
	
	@RequestMapping(value="/exam")
	public String exam() {
		return "/netschool-exam/index";
	}
	
	@RequestMapping(value="/wk")
	public String wk() {
		return "/netschool-wk/index";
	}
	
	@RequestMapping(value="/bbs")
	public String bbs() {
		return "/netschool-bbs/index";
	}
	
	@RequestMapping(value="/trainmgr")
	public String trainMgr() {
		return "/netschool-trainmgr/index";
	}
	
	@RequestMapping(value="/live/{key}")
	public String livePage(@PathVariable(value="key", required=false)String key, HttpServletRequest req,
			HttpServletResponse resp) {
		resp.setHeader("Access-Control-Allow-Headers", "Access-Control-Allow-Origin");
		resp.setHeader("header Access-Control-Allow-Origin", "*");
		if(key==null || key.equals("")) {//课程中心(默认为课程检索页面)
			throw new RuntimeException("页面不存在");
		}else if("teacher".equals(key)) {//教师直播
			req.setAttribute("url", teacherPath);
		}else if("student".equals(key)) {//学生观看
			req.setAttribute("url", studentPath);
		}
		return "livePage";
	}
	
//	@RequestMapping(value="/bbs")
//	public String bbsPage(HttpServletRequest req) {
//		req.setAttribute("url", bbsPath);
//		return "bbsPage";
//	}
	
	@RequestMapping(value="/teachCenter")
	public String teachCenterPage() {
		return "teachCenterPage";
	}

}
