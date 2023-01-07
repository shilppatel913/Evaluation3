package com.masai.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.app.entity.FIR;
import com.masai.app.service.FIRServiceIImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/masaifir/user")
public class FIRController {

	@Autowired
	private FIRServiceIImpl firServiceIImpl;
	
	@PostMapping("/fir")
	public ResponseEntity<?> fileFir(@Valid @RequestBody FIR fir){
		System.out.println(fir.getUser().getId());
		List<FIR> firs=this.firServiceIImpl.fileFirByUser(fir);
		System.out.println(firs.size());
		if(firs.size()==0) {
			throw new IllegalArgumentException("Register this user to file an fir");
		}
		return new ResponseEntity<List<FIR>>(firs,HttpStatus.CREATED);
	}
}
