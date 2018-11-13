package com.esen.netschool.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class TestPageAction {

	@RequestMapping(value="/courseware")
	public String courseware() {
		return "/index";
	}
}
