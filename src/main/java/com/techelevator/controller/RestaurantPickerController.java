package com.techelevator.controller;

import java.util.List;
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

	@RequestMapping(path = "/picker", method = RequestMethod.GET)
	public String restaurantPickerPageGet(ModelMap model) {
		
		List<String> types = rpDAO.getFoodTypes();
		model.put("foodTypes", types);
		return "RestaurantPicker";
	}

	@RequestMapping(path = "/picker", method = RequestMethod.POST)
	public String restaurantPickerPagePost(ModelMap model, HttpServletRequest request) {
		int rating = Integer.parseInt(request.getParameter("rating"));
		String type = request.getParameter("foodType");
		List<Restaurant> restaurants = rpDAO.getRestaurants(type, rating);
		
		model.put("restaurant", restaurants.get(0));
		return "Details";
	}
}
