package com.abhiroop.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	@Value("${my.greeting}")
	private String greetingMessage;
	
	@Value("${my.list.values}")
	private List<String> listValues;
	
	@Value("#{${db.connection}}")
	private Map<String,String> dbValues;
	
	@Autowired
	private DbSettings dbSettings;
	
	@GetMapping("/greeting")
	public String greeting() {
		//return greetingMessage+" "+listValues+" "+dbValues;
		return dbSettings.getConnection()+dbSettings.getHost();
	}
}
