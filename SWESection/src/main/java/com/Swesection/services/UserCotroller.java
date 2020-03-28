package com.Swesection.services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCotroller {
	@RequestMapping("/hello")
	public String welcome() {
		return "hello nour";
		
	}

}
