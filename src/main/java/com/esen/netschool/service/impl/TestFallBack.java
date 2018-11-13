package com.esen.netschool.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.esen.netschool.service.TestService;

@Component
public class TestFallBack implements TestService {

	@Override
	public String getService(@RequestParam(value="name") String name) {
		return "sorry " + name;
	}

}
