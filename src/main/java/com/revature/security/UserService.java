package com.revature.security;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.revature.dao.UserRepository;
import com.revature.models.ErsUser;


@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepo;
	
	public ErsUser save(ErsUser ersUser) {
		
		return userRepo.save(ersUser);
	}

	public ErsUser findByUserId(Integer userId) {
		return userRepo.findByUserId(userId);
	}

	public List<ErsUser> getAll() {
		return userRepo.findAll();
	}

    public void delete(ErsUser ersUser) {
		userRepo.delete(ersUser);
		
	}

	public ErsUser deleteByUserId(Integer theId) {
		return userRepo.findByUserId(theId);
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ErsUser ersUser = userRepo.findByUsername(username);
		if(ersUser != null)
			return ersUser;
		throw new UsernameNotFoundException("User"+username+" not found");
	}
	
	
}
