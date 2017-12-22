package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Restaurant;
import com.techelevator.model.User;

public interface RestaurantPickerDAO {
	
	public User saveUser(User newUser);
	
	public User getUser(String userName);
	
	public Restaurant getRestaurant(long restaurantId);
	
	public List <Restaurant> getRestaurants(String foodType, int minRating);
	
	public List <String> getFoodTypes(); 
	
	

}
