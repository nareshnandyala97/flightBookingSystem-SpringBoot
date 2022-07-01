package com.admin.service;
import java.util.List;

import com.admin.entity.flightDetails;

public interface flightService {
	
	public Integer addFlight(flightDetails details);
	
	public List<flightDetails> getAll();
	
	public List<flightDetails> searchFlight(String origin, String destination, String startDate);

	public Integer updateFlight(flightDetails flightDetails, Integer id);
	
	public flightDetails findById(Integer id);

	public void deleteFlight(Integer id);

}
//origin,destination,block,startdate