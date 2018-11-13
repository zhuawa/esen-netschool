package com.esen.netschool.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esen.netschool.service.TestService;

@RestController
public class TestAction {

	@Autowired
	TestService testService;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test(@RequestParam(value="name") String name) {
		return testService.getService(name);
	}
	
	
}
