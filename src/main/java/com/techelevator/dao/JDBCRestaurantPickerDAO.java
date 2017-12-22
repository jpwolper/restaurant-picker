package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.model.Restaurant;
import com.techelevator.model.User;

public class JDBCRestaurantPickerDAO implements RestaurantPickerDAO {
	
	private JdbcTemplate jdbctemplate;
	
	@Autowired
	public JDBCRestaurantPickerDAO (DataSource dataSource) {
		
		this.jdbctemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveUser(User newUser) {
	String sqlSaveUser = "INSERT INTO users (username, password, firstname, lastname, salt) VALUES (?,?,?,?,?)";
	jdbctemplate.update(sqlSaveUser, newUser.getUserName(), newUser.getPassword(), newUser.getFirstName(), newUser.getLastName(), newUser.getSalt());
	}

	@Override
	public User getUser(String userName) {
		User newUser = new User();
		String sqlGetUser = "Select * FROM users WHERE username = ?";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetUser, userName);
		newUser = mapRowToUser(results);
		return newUser;
	}

	@Override
	public List<Restaurant> getRestaurants(String foodType, int minRating) {
		List<Restaurant> newRestaurants = new ArrayList<Restaurant>();
		String sqlGetRestaurant = "Select * FROM restaurants WHERE foodtype = ? AND rating = ?";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetRestaurant, foodType, minRating);
		while (results.next()) {
			newRestaurants.add(mapRowToRestaurant(results));
			results.next();
		}	
		
		return newRestaurants;
	}

	@Override
	public List<String> getFoodTypes() {
		List<String> allFoodTypes = new ArrayList<String>();
		String sqlGetAllFoodTypes = "Select DISTINCT foodtype FROM restaurant";
		SqlRowSet results = jdbctemplate.queryForRowSet(sqlGetAllFoodTypes);
		while (results.next()) {
			allFoodTypes.add(results.getString("foodtype"));
			results.next();
		}	
		
		return allFoodTypes;
	}

	private User mapRowToUser(SqlRowSet results) {
		User u = new User();
		u.setUserId(results.getLong("userid"));
		u.setUserName(results.getString("username"));
		u.setPassword(results.getString("password"));
		u.setFirstName(results.getString("firstname"));
		u.setLastName(results.getString("lastname"));
		return u;
	}
	private Restaurant mapRowToRestaurant(SqlRowSet results) {
		Restaurant rest = new Restaurant();
		rest.setRestaurantId(results.getLong("restaurantid"));
		rest.setStreetAddress(results.getString("streetAddress"));
		rest.setZipCode(results.getString("zipcode"));
		rest.setFoodType(results.getString("foodtype"));
		rest.setRating(results.getInt("rating"));
		return rest;
	}
}
