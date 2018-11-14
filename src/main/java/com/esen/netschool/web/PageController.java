package com.esen.netschool.web;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value="/rms/{key}")
	public String rmsPage(@PathVariable(value="key", required=false)String key, HttpServletRequest req) {
		if(key==null || key.equals("")) {
			req.setAttribute("url", mainPath);
		}else if("coursewaremgr".equals(key)) {
			req.setAttribute("url", coursewaremgrPath);
		}else if("learnresourcesmgr".equals(key)) {
			req.setAttribute("url", learnresourcesmgrPath);
		}
		return "rmsPage";
	}
	
	@RequestMapping(value="/courseCenter")
	public String courseCenterPage() {
		return "courseCenterPage";
	}
	
	@RequestMapping(value="/teachCenter")
	public String teachCenterPage() {
		return "teachCenterPage";
	}

}
