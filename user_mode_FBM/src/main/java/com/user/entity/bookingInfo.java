package com.user.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class bookingInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bId;
	private String airlineName;
	private String flightNumber;
	private String origin;
	private String destination;
	private String name;
	private String email;
	private String bookedSeats;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="b_Id")
	private List<userDetails> userDetails;
	private String pnrNumber;
	private String meal;

	public bookingInfo(Integer bId, String airlineName, String flightNumber, String origin, String destination,
			String name, String email, String bookedSeats, String pnrNumber, String meal) {
		super();
		this.bId = bId;
		this.airlineName = airlineName;
		this.flightNumber = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.name = name;
		this.email = email;
		this.bookedSeats = bookedSeats;
		this.pnrNumber = pnrNumber;
		this.meal = meal;
	}

	public bookingInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public List<userDetails> getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(List<userDetails> userDetails) {
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
