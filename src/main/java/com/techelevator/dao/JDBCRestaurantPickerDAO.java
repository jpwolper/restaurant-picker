package com.techelevator.dao;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getFoodTypes() {
		// TODO Auto-generated method stub
		return null;
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
	
}
