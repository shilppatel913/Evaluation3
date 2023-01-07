package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.entity.FIR;
import com.masai.app.entity.User;
import com.masai.app.helper.Credentials;
import com.masai.app.service.UserServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/masaifir/user")
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody User user){
		if(user.getGender().equalsIgnoreCase("male") ||
				user.getGender().equalsIgnoreCase("female") ||
				user.getGender().equalsIgnoreCase("transgender")) {
		List<User> users=this.userServiceImpl.registerUser(user);
		return new ResponseEntity<List<User>>(users,HttpStatus.CREATED);}
		else {
			throw new IllegalArgumentException("gender must be male female or transgender");
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody Credentials credentials){
		String firstname=credentials.getFirstname();
		String lastname=credentials.getLastname();
		String password=credentials.getPassword();
		User user=this.userServiceImpl.loginUser(firstname,
			lastname,password);
		if(user==null)
			throw new IllegalArgumentException("User not registered");
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@GetMapping("/{userId}/fir/")
	public ResponseEntity<List<FIR>> getListFirByUser(@PathVariable("userId") int userId){
		List<FIR> firs=this.userServiceImpl.getAllFirs(userId);
		if(firs==null) {
			throw new IllegalArgumentException("Register first to file an FIR");
		}
		return new ResponseEntity<List<FIR>>(firs,HttpStatus.OK);
	}
}
