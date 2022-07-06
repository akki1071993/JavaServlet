package com.dao;

import java.math.BigDecimal;
import java.sql.Date;

public class Booking {
	
	private int b_id;
	private int c_id;
	private int f_id;
	private Date date_of_travel;
	private int no_of_passenger;
	private String type;
	private BigDecimal total_fare;
	
	public Booking() {
		// TODO Auto-generated constructor stub
	}

	public Booking(int c_id, int f_id, Date date_of_travel, int no_of_passenger, String type, BigDecimal total_fare) {
		super();
		this.c_id = c_id;
		this.f_id = f_id;
		this.date_of_travel = date_of_travel;
		this.no_of_passenger = no_of_passenger;
		this.type = type;
		this.total_fare = total_fare;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}

	public Date getDate_of_travel() {
		return date_of_travel;
	}

	public void setDate_of_travel(Date date_of_travel) {
		this.date_of_travel = date_of_travel;
	}

	public int getNo_of_passenger() {
		return no_of_passenger;
	}

	public void setNo_of_passenger(int no_of_passenger) {
		this.no_of_passenger = no_of_passenger;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getTotal_fare() {
		return total_fare;
	}

	public void setTotal_fare(BigDecimal total_fare) {
		this.total_fare = total_fare;
	}
	
	

}
