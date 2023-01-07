package com.masai.app.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Pattern(regexp = "^[a-zA-Z]+$",message = "{firstname.invalid}")
	private String firstname;
	@Pattern(regexp = "^[a-zA-Z]+$",message = "{lastname.invalid}")
	private String lastname;
	@Size(min = 10,max = 10,message = "{mobileNumber.invalid}")
	private String mobileNumber;
	private String address;
	@Min(value=8,message="{age.invalid}")
	private Integer age;
	private String gender;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{6,12}$).*$",
			message = "{password.invalid")
	private String password;
	
	/**A user can file multiple fir's but an fir will be filed by a particular user only **/
	@OneToMany(cascade = CascadeType.ALL,mappedBy="user")
	@JsonIgnore
	private List<FIR> firs=new ArrayList<>();
	
	
	
}
