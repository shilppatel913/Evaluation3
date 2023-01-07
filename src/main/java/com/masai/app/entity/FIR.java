package com.masai.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fir")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FIR {
	
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
			message = "{password.invalid}")
	private String password;
	
	/** which user filed the fir **/
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

}
