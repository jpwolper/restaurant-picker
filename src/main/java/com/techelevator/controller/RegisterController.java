package com.techelevator.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.dao.RestaurantPickerDAO;

@Controller
public class RegisterController {

	private RestaurantPickerDAO rpDAO;
	
	@Autowired
	public RegisterController(RestaurantPickerDAO rpDAO) {
		this.rpDAO = rpDAO;
	}
	
	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String shoRegisterPage() {
		return "register";
	}
	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String showLoginPage() {
		return "login";
	}

}
