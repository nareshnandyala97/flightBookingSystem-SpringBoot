package com.admin.secure.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.admin.entity.userEntity;
import com.admin.service.userRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	userRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		userEntity user=userRepo.findByUserName(username);
		// TODO Auto-generated method stub
		return new User(user.getUserName(),user.getPassword(),new ArrayList<>());
	}

}
