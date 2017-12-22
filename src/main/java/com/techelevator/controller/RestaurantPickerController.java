package com.techelevator.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String showHomePagePost(ModelMap model, HttpServletRequest request) {
		Restaurant theRestaurant = new Restaurant();
		theRestaurant.setRating(Integer.parseInt(request.getParameter("rating")));
		theRestaurant.setFoodType(request.getParameter("foodType"));
		model.put("allRestaurants", rpDAO.getRestaurants(theRestaurant.getFoodType(), theRestaurant.getRating()));
		return "home";
	}
}
