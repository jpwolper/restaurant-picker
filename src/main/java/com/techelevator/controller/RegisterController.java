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
	
	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String showRegisterPage(Map<String, Object> model) {
		return "register";
	}
	
	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String postRegisterPage(Map<String, Object> model) {
		return "register";
	}
}
