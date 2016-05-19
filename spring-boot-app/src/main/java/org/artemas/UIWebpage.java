package org.artemas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UIWebpage {
	
	@RequestMapping("/")
	String home(){
		return "hello world !";
	}
	
	public static void main(String[] args){
		SpringApplication.run(UIWebpage.class, args);
	}

}
