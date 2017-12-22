package com.techelevator.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.dao.RestaurantPickerDAO;

@Controller
public class RestaurantPickerController {

	private RestaurantPickerDAO rpDAO;

	@Autowired
	public RestaurantPickerController(RestaurantPickerDAO rpDAO) {
		this.rpDAO = rpDAO;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String showHomePagePost() {
		return "home";
	}
}
