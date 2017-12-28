package com.techelevator.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.techelevator.dao.RestaurantPickerDAO;
import com.techelevator.model.Restaurant;

@Controller
public class RestaurantPickerController {

	private RestaurantPickerDAO rpDAO;

	@Autowired
	public RestaurantPickerController(RestaurantPickerDAO rpDAO) {
		this.rpDAO = rpDAO;
	}

	@RequestMapping(path = "/picker", method = RequestMethod.GET)
	public String restaurantPickerPageGet(ModelMap model) {
		
		try {
			List<String> types = rpDAO.getFoodTypes();
			model.put("foodTypes", types);
		}
		catch(Exception ex) {
			model.put("error", ex.getMessage());
		}
		return "RestaurantPicker";
	}

	@RequestMapping(path = "/picker", method = RequestMethod.POST)
	public String restaurantPickerPagePost(ModelMap model, HttpServletRequest request) {
		try {
			int rating = Integer.parseInt(request.getParameter("stars"));
			String type = request.getParameter("typeOfFood");
			List<Restaurant> restaurants = rpDAO.getRestaurants(type, rating);
			int randomNum = ThreadLocalRandom.current().nextInt(0, restaurants.size());
			model.put("restaurant", restaurants.get(randomNum));
		}
		catch(Exception ex) {
			model.put("error", ex.getMessage());
		}
		return "Details";
	}
}
