package com.revature.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.revature.models.ErsUser;
import com.revature.security.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	/*
	 * @Autowired UserRepository userRepo;
	 */
	 
	@Autowired
	UserService userService; 

	@GetMapping("/signup")
	public String userSignupForm(Model model) {
		
		 ErsUser anUser = new ErsUser();
		 model.addAttribute("user", anUser);
		 
		 
		return "users/signup"; //return the user form 
	}
	
	
	@PostMapping("save")
	public String createUser(@Valid ErsUser ersUser, Errors error) {
		if (error.hasErrors()) {
			return "redirect:/users/signup";
        }
		//save to the database using a user CRUD repository
		userService.save(ersUser);
		//use a redirect to prevent duplicate submission 
		return "redirect:/users/list";
	}
	
	
	@GetMapping("/update")
	public String updateUserForm(@RequestParam("id") Integer userId, Model model) {
		
		ErsUser ersUser = userService.findByUserId(userId);
		model.addAttribute("user", ersUser);
		return "users/update";
	}
	
	
	@GetMapping("/delete")
	public String deleteAnUser(@RequestParam("id") Integer userId) {
		
		ErsUser ersUser = userService.findByUserId(userId);
		userService.delete(ersUser);
		return "redirect:/users/list";
	}
	

	  @GetMapping("/list") 
	  public String displayUserList(Model model) {
	  List<ErsUser> anUser = userService.getAll();
	  model.addAttribute("user",anUser); 
	  return "users/user-list"; 
	}

}
