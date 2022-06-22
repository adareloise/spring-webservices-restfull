package com.adareloise.restfull.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InternazionalizedController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/msg")
	public String internationalMsg() {
		return messageSource.getMessage
				("good.morning.message", null,"Defaul Message", LocaleContextHolder.getLocale());
	}
}
