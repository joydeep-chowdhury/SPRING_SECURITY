package com.joydeep.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.joydeep.security.dao.UserRepository;
import com.joydeep.security.model.User;

@Service
public class UserPrincipalDetailsService implements UserDetailsService
  {
     @Autowired
	 private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=this.userRepository.findByUsername(username);
		UserPrincipal userPrincipal=new UserPrincipal(user);
		return userPrincipal;
	}



  }
