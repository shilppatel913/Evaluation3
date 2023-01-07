package com.masai.app.helper;



import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Credentials {
	
	@Pattern(regexp = "^[a-zA-Z]+$")
	String firstname;
	@Pattern(regexp = "^[a-zA-Z]+$")
	String lastname;
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=.{6,12}$).*$")
	String password;
	
}
