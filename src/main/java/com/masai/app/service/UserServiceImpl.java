package com.masai.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.entity.FIR;
import com.masai.app.entity.User;
import com.masai.app.repo.FIRRepository;
import com.masai.app.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
		
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FIRRepository firRepository;

	@Override
	public List<User> registerUser(User user) {
		this.userRepository.save(user);
		return this.userRepository.findAll();
	}

	@Override
	public User loginUser(String firstname,String lastname,String password) {
		User user=this.userRepository.findByFirstnameAndLastnameAndPassword(firstname, lastname, password);
		if(user!=null) {
			return user;
		}
		return null;
	}

	@Override
	public List<FIR> getAllFirs(int userId) {
		User user=this.userRepository.findById(userId).get();
		if(user!=null) {
			return this.firRepository.findByUser(user);
		}
		return null;
	}
}
