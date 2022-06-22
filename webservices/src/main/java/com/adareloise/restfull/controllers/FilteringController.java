package com.adareloise.restfull.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adareloise.restfull.model.SomeBean;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value1", "value2", "value3" );
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListSomeBean() {
		SomeBean bean1 = new SomeBean("value1", "value2", "value3" );
		SomeBean bean2 = new SomeBean("value11", "value22", "value33" );
		
		return Arrays.asList(bean1,bean2);
	}
}
