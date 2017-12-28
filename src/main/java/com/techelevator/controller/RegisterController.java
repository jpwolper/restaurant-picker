package com.techelevator.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String registerPagePost(ModelMap model, HttpServletRequest request, HttpSession session) {
		
		String jspPage = "register";
		try {
			
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("password");
			String userName = request.getParameter("userName");
			
			if (validateUserData(firstName, lastName, password, userName)) {
				
				PasswordHasher hasher = new PasswordHasher();
				byte[] salt = hasher.generateRandomSalt();
				String hash = hasher.computeHash(password, salt);
				
				User newUser = new User();
				newUser.setFirstName(firstName);
				newUser.setLastName(lastName);
				newUser.setPassword(hash);
				newUser.setSalt(Base64.encodeBytes(salt));
				newUser.setUserName(userName);
				
				rpDAO.saveUser(newUser);
				model.put("user", newUser.getFirstName());
				
				List<String> foodTypes = rpDAO.getFoodTypes();
				model.put("foodTypes", foodTypes);
				
				session.setAttribute("user", newUser.getFirstName());
				
				jspPage = "RestaurantPicker";
			}
			else {
				throw new Exception("Some of the user details are invalid. All fields require a minimum of 1 character and the password field requires a minimum of 6 characters.");
			}
		}
		catch (Exception ex) {
			model.put("error", ex.getMessage());
		}
		
		return jspPage;
	}
	
	private boolean validateUserData(String firstName, String lastName, String password, String userName) {
		boolean isValid = true;
		
		if (firstName.length() < 1 ||
			lastName.length() < 1 ||
			password.length() < 6 ||
			userName.length() < 1) {
			
			isValid = false;
		}
		
		return isValid;
	}
}
