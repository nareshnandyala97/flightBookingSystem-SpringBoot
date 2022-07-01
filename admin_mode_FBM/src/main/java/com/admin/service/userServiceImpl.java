package com.admin.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.userEntity;
@Service
public class userServiceImpl implements userService{
	
	@Autowired
	private userRepository userRepo;

	@Transactional
	@Override
	public Integer saveuser(userEntity user) {
		userEntity saveUser=userRepo.save(user);
		return saveUser.getId();
	}

}
