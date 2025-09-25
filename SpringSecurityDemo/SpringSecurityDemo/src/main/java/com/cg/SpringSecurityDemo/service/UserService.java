package com.cg.SpringSecurityDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.SpringSecurityDemo.entity.User;
import com.cg.SpringSecurityDemo.repo.UserRepository;
@Service
public class UserService implements UserDetailsService {

	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = repo.findByUsername(username);
	    if (user == null) {
	        throw new UsernameNotFoundException("User not found");
	    }

	    // Ensure ROLE_ prefix is there
	    String role = user.getRole().startsWith("ROLE_") ? user.getRole() : "ROLE_" + user.getRole();

	    return new org.springframework.security.core.userdetails.User(
	            user.getUsername(),
	            user.getPassword(),
	            AuthorityUtils.createAuthorityList(role));

	}
	public void saveUser(User user)
	{
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

		repo.save(user);
	}
	public List<User>getAllUser()
	{
		return repo.findAll();
	}
	public void deleteUser(Long id)
	{
		repo.deleteById(id);
	}
	
}