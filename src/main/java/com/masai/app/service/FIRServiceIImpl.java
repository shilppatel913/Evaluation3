package com.masai.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.app.entity.FIR;
import com.masai.app.entity.User;
import com.masai.app.repo.FIRRepository;
import com.masai.app.repo.UserRepository;

@Service
public class FIRServiceIImpl implements FIRService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FIRRepository fIRepository;

	@Override
	public List<FIR> fileFirByUser(FIR fir) {
		User user=this.userRepository.findById(fir.getUser().getId()).get();
		if(user!=null) {
			fir.setUser(user);
			this.fIRepository.save(fir);
			return this.fIRepository.findAll();
		}
		return null;
	}
	
	
}
