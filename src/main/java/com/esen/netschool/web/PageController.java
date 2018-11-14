package com.esen.netschool.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/page")
public class PageController {
	
	@RequestMapping(value="/rms")
	public String rmsPage() {
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
