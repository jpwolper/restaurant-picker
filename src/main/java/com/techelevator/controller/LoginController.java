package com.techelevator.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String loginPagePost(ModelMap model, HttpServletRequest request, HttpSession session) {
		String jspPage = "login";
		
		try {
			String userName = request.getParameter("userName");
			User dbUser = rpDAO.getUser(userName);
			if (dbUser.getUserId() != 0 && Security.IsUserValid(dbUser, request.getParameter("password"))) {
				
				model.put("user", dbUser.getFirstName());
				
				List<String> types = rpDAO.getFoodTypes();
				model.put("foodTypes", types);
				
				session.setAttribute("user", dbUser.getFirstName());
				
				jspPage = "RestaurantPicker";
			}
			else {
				model.put("error", "Invalid username/password combination");
			}
		}
		catch(Exception ex){
			model.put("error", ex.getMessage());
		}
	
		return jspPage;
	}

}
