package com.admin.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.entity.flightDetails;
import com.admin.exception.ResourceNotFoundException;

@Service
public class flightServiceImpl implements flightService{
	
	@Autowired
	flightDetailsRepository flightDetailsRepo;
	
	@Transactional
	@Override
	public Integer addFlight(flightDetails details) {
		// TODO Auto-generated method stub
		flightDetails flight=flightDetailsRepo.save(details);
		Integer fId=flight.getfId();
		return fId;
	}

	@Override
	public List<flightDetails> searchFlight(String origin, String destination, String startDate) {
		// TODO Auto-generated method stub
		String dateTime = startDate;//String dateTime = "2020-12-12 01:24:23";
        Timestamp timestamp = Timestamp.valueOf(dateTime);
        System.out.println(timestamp);
		return flightDetailsRepo.getFlights(origin,destination,timestamp);
	}

	@Override
	public List<flightDetails> getAll() {
		// TODO Auto-generated method stub
		return flightDetailsRepo.findAll();
	}
	@Transactional
	@Override
	public Integer updateFlight(flightDetails flightDetails, Integer id) {
		
		flightDetails existingFlight=flightDetailsRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Flight id","id",id));
		existingFlight.setAirlineName(flightDetails.getAirlineName());
		existingFlight.setFlightNumber(flightDetails.getFlightNumber());
		existingFlight.setOrigin(flightDetails.getOrigin());
		existingFlight.setDestination(flightDetails.getDestination());
		existingFlight.setStartDate(flightDetails.getStartDate());
		existingFlight.setEndDate(flightDetails.getEndDate());
		existingFlight.setBusinessClass(flightDetails.getBusinessClass());
		existingFlight.setEconomyClass(flightDetails.getEconomyClass());
		existingFlight.setBlock(flightDetails.isBlock());
		existingFlight.setMeal(flightDetails.getMeal());
		flightDetailsRepo.save(existingFlight);
		return existingFlight.getfId();
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void deleteFlight(Integer id) {
		flightDetailsRepo.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public flightDetails findById(Integer id) {
		// TODO Auto-generated method stub
		flightDetails flight=flightDetailsRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("flight id","id",id));
//		List<flightDetails> flightDetails=new ArrayList<>();
//		flightDetails.add(flight);
		return flight;
	}

}
