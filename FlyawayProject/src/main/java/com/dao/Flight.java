package com.dao;

import java.math.BigDecimal;

public class Flight {

	private int f_id;
	private String f_code;
	private String airline;
	private String departure;
	private String arrival;
	private String weekdays;
	private BigDecimal business_fare;
	private BigDecimal economic_fare;
	private BigDecimal prime_fare;

	public Flight() {

	}

	public Flight(String f_code, String airline, String departure, String arrival, String weekdays, BigDecimal business_fare,
			BigDecimal economic_fare, BigDecimal prime_fare) {
		super();
		this.f_code = f_code;
		this.airline = airline;
		this.departure = departure;
		this.arrival = arrival;
		this.weekdays = weekdays;
		this.business_fare = business_fare;
		this.economic_fare = economic_fare;
		this.prime_fare = prime_fare;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public String getF_code() {
		return f_code;
	}

	public void setF_code(String f_code) {
		this.f_code = f_code;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String to) {
		this.arrival = to;
	}

	public String getWeekdays() {
		return weekdays;
	}

	public void setWeekdays(String weekdays) {
		this.weekdays = weekdays;
	}

	public BigDecimal getBusiness_fare() {
		return business_fare;
	}

	public void setBusiness_fare(BigDecimal business_fare) {
		this.business_fare = business_fare;
	}

	public BigDecimal getEconomic_fare() {
		return economic_fare;
	}

	public void setEconomic_fare(BigDecimal economic_fare) {
		this.economic_fare = economic_fare;
	}

	public BigDecimal getPrime_fare() {
		return prime_fare;
	}

	public void setPrime_fare(BigDecimal prime_fare) {
		this.prime_fare = prime_fare;
	}

}
