package com.revature.security;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.revature.models.ErsUser;

import lombok.Data;

@Data
public class RegistrationPage {
	
	  @Column(unique=true)
	  @NotEmpty(message="Username is required")
	  private String username; //Username of the user not null
	
	
	  @NotEmpty(message="Passwprd is required")
	  private String password; //Password of user not null
	  
	  private boolean enabled = true;
	  
	  private String role; //User role: ROLE_USER by default
	
	
	  @NotEmpty(message="First Name is required")
	  private String firstName; //User first name not null
	
	
	  @NotBlank(message="Last Name is required")
	  private String lastName; //User last name not null
	
	  private String gender; //Gender of the user: Male or female
	
	  @NotEmpty(message = "Email cannot be empty")
	  private String email; //User email address not null and unique
	
	  @Pattern(regexp="([0-9]{3}-[0-9]{3}-[0-9]{4})", message="Phone number format: xxx-xxx-xxxx")
	  private String phoneNumber; //User phone number
	
	  private String address; // Address of the user
	  
	  @Column(updatable=false)
	  private LocalDateTime creationDate;
	  
	public ErsUser toUser(PasswordEncoder passwordEncoder) {
	
		return new ErsUser(username, passwordEncoder.encode(password), role, firstName, lastName,
				gender, email, phoneNumber, address, creationDate);
	}
}
