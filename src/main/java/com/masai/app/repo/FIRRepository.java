package com.masai.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.entity.FIR;
import com.masai.app.entity.User;

@Repository
public interface FIRRepository extends JpaRepository<FIR, Integer> {
	
	public List<FIR> findByUser(User user);
}
