package com.techelevator.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.dao.RestaurantPickerDAO;
import com.techelevator.model.User;

@Controller
public class LoginController {

	private RestaurantPickerDAO rpDAO;

	@Autowired
	public LoginController(RestaurantPickerDAO rpDAO) {
		this.rpDAO = rpDAO;
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String showHomePage(ModelMap model, HttpServletRequest request) {
		User user = new User();
		user.setUserName(request.getParameter("userName"));
		model.put("user", rpDAO.getUser(user.getUserName()));
		return "login";
	}

}
