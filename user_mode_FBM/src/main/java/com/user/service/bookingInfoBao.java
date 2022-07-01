package com.user.service;

import java.util.List;

public class bookingInfoBao {
	
	private Integer bId;
	private String airlineName;
	private String flightNumber;
	private String origin;
	private String destination;
	private String name;
	private String email;
	private String bookedSeats;
	private List<userDetailsBao> userDetails;
	private String pnrNumber;
	private String meal;
	public Integer getbId() {
		return bId;
	}
	public void setbId(Integer bId) {
		this.bId = bId;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBookedSeats() {
		return bookedSeats;
	}
	public void setBookedSeats(String bookedSeats) {
		this.bookedSeats = bookedSeats;
	}
	public List<userDetailsBao> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(List<userDetailsBao> userDetails) {
		this.userDetails = userDetails;
	}
	public String getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}

}
