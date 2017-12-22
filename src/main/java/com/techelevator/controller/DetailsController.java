package com.techelevator.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.dao.RestaurantPickerDAO;

@Controller
public class DetailsController {

	private RestaurantPickerDAO rpDAO;

	@Autowired
	public DetailsController(RestaurantPickerDAO rpDAO) {
		this.rpDAO = rpDAO;
	}

	@RequestMapping(path = "/Details", method = RequestMethod.GET)
	public String showRestaurantDetailPage(ModelMap model) {
		
		return "Details";
	}

}
