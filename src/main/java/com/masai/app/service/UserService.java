package com.masai.app.service;

import java.util.List;

import com.masai.app.entity.FIR;
import com.masai.app.entity.User;

public interface UserService {

	public List<User> registerUser(User user);
	public User loginUser(String firstname,String lastname,String password);
	public List<FIR> getAllFirs(int userId);
	
}
