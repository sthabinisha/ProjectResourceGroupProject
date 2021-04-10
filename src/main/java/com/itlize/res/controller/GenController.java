package com.itlize.res.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GenController {

	@GetMapping("/user")
	@PreAuthorize("hasRole('role_user')")
	public String forUser() {

		return "welcome user";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('role_admin')")
	public String forAdmin() {

		return "welcome admin";
	}
	
	

}
