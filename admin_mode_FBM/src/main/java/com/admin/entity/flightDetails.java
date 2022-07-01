package com.admin.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class flightDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer fId;
	// private Integer flightNumber;
	private String airlineName;
	private String origin;
	private String destination;
	private boolean block;
	private Timestamp startDate;
	private Timestamp endDate;
	private String flightNumber;// A320 A320neo
	private Integer businessClass;
	private Integer economyClass;
	private Integer cost;
	private String meal;

	public flightDetails(Integer fId, String airlineName, String origin, String destination, boolean block,
			Timestamp startDate, Timestamp endDate, String flightNumber, Integer businessClass, Integer economyClass,
			Integer cost, String meal) {
		super();
		this.fId = fId;
		this.airlineName = airlineName;
		this.origin = origin;
		this.destination = destination;
		this.block = block;
		this.startDate = startDate;
		this.endDate = endDate;
		this.flightNumber = flightNumber;
		this.businessClass = businessClass;
		this.economyClass = economyClass;
		this.cost = cost;
		this.meal = meal;
	}

	public flightDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getfId() {
		return fId;
	}

	public void setfId(Integer fId) {
		this.fId = fId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
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

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Integer getBusinessClass() {
		return businessClass;
	}

	public void setBusinessClass(Integer businessClass) {
		this.businessClass = businessClass;
	}

	public Integer getEconomyClass() {
		return economyClass;
	}

	public void setEconomyClass(Integer economyClass) {
		this.economyClass = economyClass;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

}
