package com.bob.app.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationService {

	@Value("${fi.url}")
	private String fiUrl; 
	
	public String getfiUrl() {
		return fiUrl;
	}
	

	@Value("${fi.dedup}")
	private String fiDedup; 
	
	public String getfiDedup() {
		return fiDedup;
	}
}
