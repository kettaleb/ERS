package com.revature.models;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Entity
@Data
public class ErsUser implements UserDetails{
	
	//private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId; //User ID is auto-generated in the database
	
	
	/*
	 * @NotEmpty(message="Username is required")
	 * 
	 * @Size(min = 2, message = "Username must be 2 characters or more")
	 */
	  @Column(unique=true)	
	  private String username; //Username of the user not null
	  
	  @Column(updatable=false)
	  private String password; //Password of user not null
	  
	  private boolean enabled = true;
	  
	  private String role; //User role: USER_ROLE by default
	
	  private String firstName; //User first name not null
	
	  private String lastName; //User last name not null
	
	  private String gender; //Gender of the user: Male or female
	
	
	  //@Column(unique = true)
	  private String email; //User email address not null and unique
	 
	  private String phoneNumber; //User phone number
	
	  private String address; // Address of the user
	
	@Column(updatable=false)
	private LocalDateTime creationDate;
	
	public ErsUser() {
		setRole("USER_ROLE");
	}
	
	public ErsUser(String username, String password, String role, String firstName, String lastName, String gender,
			String email, String phoneNumber, String address, LocalDateTime creationDate) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.creationDate = creationDate;
	}

	
	@PrePersist
	void createdAt() {
		this.creationDate = LocalDateTime.now();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	
	
}
