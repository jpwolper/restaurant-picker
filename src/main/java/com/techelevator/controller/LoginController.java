package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.PasswordHasher;
import com.techelevator.Security;
import com.techelevator.dao.RestaurantPickerDAO;
import com.techelevator.model.User;

@Controller
public class LoginController {

	private RestaurantPickerDAO rpDAO;

	@Autowired
	public LoginController(RestaurantPickerDAO rpDAO) {
		this.rpDAO = rpDAO;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String loginPageGet() {
		return "login";
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String loginPagePost(ModelMap model, HttpServletRequest request) {
		String jspPage = "login";
		
		try {
			User user = new User();
			user.setUserName(request.getParameter("userName"));
			User dbUser = rpDAO.getUser(user.getUserName());
			if (Security.IsUserValid(dbUser, request.getParameter("password"))) {
				List<String> foodTypes = rpDAO.getFoodTypes();
				model.put("foodTypes", foodTypes);
				
				jspPage = "RestaurantPicker";
				model.put("user", dbUser);
			}
			else {
				model.put("error", "Invalid Password");
			}
		}
		catch(Exception ex){
			model.put("error", ex.getMessage());
		}
	
		return jspPage;
	}

}
