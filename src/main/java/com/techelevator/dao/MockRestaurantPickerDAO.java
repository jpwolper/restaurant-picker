package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.techelevator.model.Restaurant;
import com.techelevator.model.User;

@Component
public class MockRestaurantPickerDAO implements RestaurantPickerDAO {

	@Override
	public User saveUser(User newUser) {
		
		return new User();
	}

	@Override
	public User getUser(String userName) {
		
		User fakeUser = new User();
		fakeUser.setFirstName("Chris");
		fakeUser.setLastName("Rupp");
		fakeUser.setPassword("abc123");
		fakeUser.setSalt("salt");
		fakeUser.setUserName("christopherjrupp");
		fakeUser.setUserId(1);
		
		return fakeUser;
	}

	@Override
	public List<Restaurant> getRestaurants(String foodType, int minRating) {
		
		ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
		Restaurant rest = new Restaurant();
		rest.setFoodType("Asian");
		rest.setRating(1);
		rest.setRestaurantId(1);
		rest.setRestaurantName("Angry Wok");
		rest.setStreetAddress("1123 Busybee Street");
		rest.setZipCode("45333");
		restaurants.add(rest);
		
		rest = new Restaurant();
		rest.setFoodType("Italian");
		rest.setRating(3);
		rest.setRestaurantId(2);
		rest.setRestaurantName("Noodle Time");
		rest.setStreetAddress("9876 Meatball Blvd");
		rest.setZipCode("45333");
		restaurants.add(rest);
		
		return restaurants;
	}

	@Override
	public List<String> getFoodTypes() {
		
		ArrayList<String> types = new ArrayList<String>();		
		types.add("Asian");
		types.add("Italian");
		
		return types;
	}

}
