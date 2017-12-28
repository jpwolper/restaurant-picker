package com.techelevator.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

	@RequestMapping(path = "/picker", method = RequestMethod.POST)
	public String restaurantPickerPagePost(ModelMap model, HttpServletRequest request, HttpSession session) {
		String jspPage = "login";
		try {
			Object user = session.getAttribute("user");
			if (user != null) {
				model.put("user", (String) user);
			
				int rating = Integer.parseInt(request.getParameter("stars"));
				String type = request.getParameter("typeOfFood");
				List<Restaurant> restaurants = rpDAO.getRestaurants(type, rating);
				int randomNum = ThreadLocalRandom.current().nextInt(0, restaurants.size());
				model.put("restaurant", restaurants.get(randomNum));
				
				jspPage = "Details";
			}
			else {
				throw new Exception("User not logged in.");
			}
		}
		catch(Exception ex) {
			model.put("error", ex.getMessage());
		}
		return jspPage;
	}
}
