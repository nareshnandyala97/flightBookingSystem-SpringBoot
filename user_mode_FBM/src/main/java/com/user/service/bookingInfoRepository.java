package com.user.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.entity.bookingInfo;

@Repository
public interface bookingInfoRepository extends JpaRepository<bookingInfo,Integer>{
	
	public List<bookingInfo> findByEmail(String email);
	
	public bookingInfo findBypnrNumber(String pnrNumber);

}
