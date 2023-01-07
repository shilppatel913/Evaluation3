package com.masai.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByFirstnameAndLastnameAndPassword(String firstname,String lastname,String password);
}
