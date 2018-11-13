package com.esen.netschool.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.esen.netschool.service.impl.TestFallBack;

@FeignClient(value="netschool-rms",fallback = TestFallBack.class)
public interface TestService {

	@RequestMapping(method = RequestMethod.GET, value = "/hi")
    String getService(@RequestParam(value="name") String name);
}
