package com.admin.service;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.admin.entity.flightDetails;

@Repository
public interface flightDetailsRepository extends JpaRepository<flightDetails,Integer>{
	
	@Query("select f from flightDetails f where f.origin=:origin and f.destination=:destination and f.block!=true and f.startDate>=:startDate")
	public List<flightDetails> getFlights(String origin,String destination,Timestamp startDate);

}
