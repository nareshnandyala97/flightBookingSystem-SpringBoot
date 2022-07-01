package com.admin.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.entity.userEntity;


@Repository
public interface userRepository extends JpaRepository<userEntity,Integer>{
	
	userEntity findByUserName(String username);

}
