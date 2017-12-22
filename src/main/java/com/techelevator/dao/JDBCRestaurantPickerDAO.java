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
	SqlRowSet results = jdbctemplate.queryForRowSet(sqlSaveUser, newUser.getUserName(), newUser.getPassword(), newUser.getFirstName(), newUser.getLastName(), newUser.getSalt());
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
