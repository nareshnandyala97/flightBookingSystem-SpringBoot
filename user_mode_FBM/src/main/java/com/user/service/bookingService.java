package com.user.service;

import java.util.List;

import com.user.entity.bookingInfo;

public interface bookingService {

	public Integer bookFlight(bookingInfo bookingInfo);

	public List<bookingInfoBao> findByEmail(String email);
	
	public List<bookingInfoBao> findBypnrNumber(String pnrNumber);

	public void cancelFlight(String pnr);

}
