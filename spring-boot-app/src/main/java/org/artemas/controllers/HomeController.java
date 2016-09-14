package org.artemas.controllers;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/resource")
	  public Map<String,Object> home() {
	    Map<String,Object> model = new HashMap<String,Object>();
	    model.put("id", UUID.randomUUID().toString());
	    model.put("content", "Hello World");
	    return model;
	  }
	 
	
	/**
	 * To service the authenticate() function 
	 * we need to add a new endpoint here in the backend.
	 * 
	 * If the “/user” resource is reachable then it will 
	 * return the currently authenticated user 
	 * (an Authentication), and otherwise Spring Security 
	 * will intercept the request and send a 401 response 
	 * through an AuthenticationEntryPoint.
	 * 
	 * @param user
	 * @return user Principal Obj
	 */
	 @RequestMapping("/user")
	 public Principal user(Principal user){
		 return user;
	 }

}
