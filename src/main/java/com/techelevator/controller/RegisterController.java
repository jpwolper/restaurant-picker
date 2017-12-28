package com.techelevator.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.postgresql.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.PasswordHasher;
import com.techelevator.Security;
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
	public String registerPageGet(Map<String, Object> model) {
		return "register";
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String registerPagePost(ModelMap model, HttpServletRequest request) {
		
		try {
			String password = request.getParameter("password");
			PasswordHasher hasher = new PasswordHasher();
			byte[] salt = hasher.generateRandomSalt();
			String hash = hasher.computeHash(password, salt);
			
			User newUser = new User();
			newUser.setFirstName(request.getParameter("firstName"));
			newUser.setLastName(request.getParameter("lastName"));
			newUser.setPassword(hash);
			newUser.setSalt(Base64.encodeBytes(salt));
			newUser.setUserName(request.getParameter("userName"));
			
			rpDAO.saveUser(newUser);
			model.put("user", newUser);
			
			List<String> foodTypes = rpDAO.getFoodTypes();
			model.put("foodTypes", foodTypes);
		}
		catch (Exception ex) {
			model.put("error", ex.getMessage());
		}
		
		return "RestaurantPicker";
	}
}
