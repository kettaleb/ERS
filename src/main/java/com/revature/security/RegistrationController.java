package com.revature.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revature.dao.UserRepository;
import com.revature.models.ErsUser;

import lombok.extern.slf4j.Slf4j;

/**
 * @Slf4j Simple Logging Facade for Java (abbreviated SLF4J) acts as a facade 
 * for different logging frameworks (e.g., java.util.logging, logback, Log4j). 
 * It offers a generic API, making the logging independent of the actual implementation.
 */
@Slf4j 
@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	private PasswordEncoder passwordEncoder;
	private UserRepository userRepo;
	
	@Autowired
	public RegistrationController (UserRepository userRepo, PasswordEncoder passwordEncoder) {
		this.userRepo = userRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping
	public String registerPage(Model model) {
			
		/*
		 * RegistrationPage aRegisterPage = new RegistrationPage();
		 * model.addAttribute("registration", aRegisterPage);
		 */
		
		return "register";
	}
	
	@ModelAttribute(name = "registerationPage")
	public RegistrationPage addRegistrationToModel() {
		return new RegistrationPage();
	}
	
	@PostMapping
	public String registerationProcess(@Valid @ModelAttribute(name = "registerationPage") 
										RegistrationPage registrationPage, Errors error) {
		
		if(error.hasErrors())
			return "register";
		try {
			userRepo.save(registrationPage.toUser(passwordEncoder));
		}catch(DataIntegrityViolationException e) {
				error.rejectValue("username", "invaliUsername", "Username is not available. Please try another one.");
				return "register";
			}
		return "redirect:/login";
		}
		
}

