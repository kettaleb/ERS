package com.revature.api.controllers;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.UserRepository;
import com.revature.models.ErsUser;


@RestController
@RequestMapping("/api/users")
public class UserApiController {
	
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping
	public Iterable<ErsUser> getUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public ErsUser getUserById(@PathVariable("id") Integer id) {
		return userRepo.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ErsUser create(@RequestBody @Valid ErsUser ersUser) {
		return userRepo.save(ersUser);
	}
	
	@PutMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ErsUser update(@RequestBody @Valid ErsUser ersUser) {
		return userRepo.save(ersUser);
	}
	
	@PatchMapping(path="/{id}", consumes= "application/json")
	public ErsUser partialUpdate(@PathVariable("id") int id, @RequestBody @Valid ErsUser patchUser) {
		ErsUser ersUser = userRepo.findByUserId(id);
		
		if(patchUser.getFirstName() != null) {
			ersUser.setFirstName(patchUser.getFirstName());
		}
		if(patchUser.getLastName() != null) {
			ersUser.setLastName(patchUser.getLastName());
		}
		if(patchUser.getEmail() != null) {
			ersUser.setEmail(patchUser.getEmail());
		}
		
		
		return userRepo.save(ersUser);
		
	}
	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") int id) {
		try {
			userRepo.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
				System.out.println("No record to delete found!");
			}
		catch(ConstraintViolationException e) {
			System.out.println("Delete method violates the foreign key constraint!!");
		}
	}
	
	/*
	 * @GetMapping(params= {"page", "size"})
	 * 
	 * @ResponseStatus(HttpStatus.OK) public Iterable<ErsUser>
	 * findPaginatedUsers(@RequestParam("page") int page,
	 * 
	 * @RequestParam("size") int size){ Pageable pageAndSize = PageRequest.of(page,
	 * size);
	 * 
	 * return userService.findAll(pageAndSize); }
	 */
	

}
