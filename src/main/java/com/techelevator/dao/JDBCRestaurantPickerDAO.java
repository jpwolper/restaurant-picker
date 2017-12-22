package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Restaurant;
import com.techelevator.model.User;

public class JDBCRestaurantPickerDAO implements RestaurantPickerDAO {

	@Override
	public User saveUser(User newUser) {
		return newUser;
	}

	@Override
	public User getUser(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Restaurant> getRestaurants(String foodType, int minRating) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getFoodTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
