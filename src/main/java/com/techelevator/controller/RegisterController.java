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
public class RegisterController {

	private RestaurantPickerDAO rpDAO;

	@Autowired
	public RegisterController(RestaurantPickerDAO rpDAO) {
		this.rpDAO = rpDAO;
	}

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String showRegisterPage(Map<String, Object> model) {
		return "register";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String postRegisterPage(ModelMap model, HttpServletRequest request) {
		User newUser = new User();
		newUser.setFirstName(request.getParameter("firstName"));
		newUser.setLastName(request.getParameter("lastName"));
		newUser.setPassword(request.getParameter("password"));
		newUser.setUserId(Integer.parseInt(request.getParameter("userId")));
		newUser.setSalt(request.getParameter("salt"));
		newUser.setUserName(request.getParameter("userName"));
		model.put("user", rpDAO.saveUser(newUser));
		return "register";
	}
}
