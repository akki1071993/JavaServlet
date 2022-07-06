package com.services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.dao.Booking;
import com.dao.Flight;
import com.dao.User;
import com.db.DBConfig;

public class UserServices {

	//Check Valid user login
	public static boolean validateUser(User user) {
		boolean isUserValid = false;
		String email = user.getEmail();
		String psw = user.getPassword();

		Connection con = DBConfig.getConnection();

		try {
			if (con != null) {
				PreparedStatement pst = con
						.prepareStatement("select * from customer_info where email = ? and psw = ?;");
				pst.setString(1, email);
				pst.setString(2, psw);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {

					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setEmail(rs.getString(3));
					user.setMobile(rs.getString(4));
					user.setPassword(rs.getString(5));

					isUserValid = true;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isUserValid;

	}

	// Save new user data
	public static boolean saveUser(User user) {
		boolean saveUser = false;
		String name = user.getName();
		String mobile = user.getMobile();
		String email = user.getEmail();
		String psw = user.getPassword();
		Connection con = DBConfig.getConnection();
		try {

			if (con != null) {
				String query = "INSERT INTO customer_info (name,email,mobile_no,psw) VALUES (?,?,?,?)";
				PreparedStatement pt = con.prepareStatement(query);
				pt.setString(1, name);
				pt.setString(2, email);
				pt.setString(3, mobile);
				pt.setString(4, psw);

				int x = pt.executeUpdate();

				if (x != 0) {
					saveUser = true;

				}
			}
		} catch (Exception e) {

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return saveUser;

	}

	// Change user password
	public static boolean changePassword(int id, String newPassword) {

		boolean isChange = false;
		Connection con = DBConfig.getConnection();

		try {
			if (con != null) {
				String query = "UPDATE customer_info SET psw = ? WHERE c_id = ?;";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, newPassword);
				pst.setInt(2, id);
				int rs = pst.executeUpdate();

				if (rs != 0) {
					isChange = true;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return isChange;
	}

	//getBookingByUserId
	public static List<Booking> getBookingByUserId(int uid) {

		
		Connection con = DBConfig.getConnection();
		List<Booking> bookingData = new ArrayList<Booking>();

		try {

			PreparedStatement pstmt = con.prepareStatement("Select * from booking_info where c_id = ? and is_deleted = ?");
			pstmt.setInt(1, uid);
			pstmt.setInt(2, 0);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Booking booking = new Booking();
				
				booking.setB_id(rs.getInt("b_id"));	
				booking.setC_id(rs.getInt("c_id"));	
				booking.setF_id(rs.getInt("f_id"));				
				booking.setDate_of_travel(rs.getDate("date_of_travel"));
				booking.setNo_of_passenger(rs.getInt("no_of_passenger"));
				booking.setType(rs.getString("class"));
				booking.setTotal_fare(rs.getBigDecimal("total_fare"));
				
				bookingData.add(booking);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return bookingData;
	}
	
	public static List<Flight> searchFlights(String departure, String airline) {

		Connection con = DBConfig.getConnection();
		List<Flight> flightData = new ArrayList<Flight>();

		try {

			PreparedStatement pstmt = con.prepareStatement("Select * from flight_info where departure = ? and arrival = ?");
			pstmt.setString(1, departure);
			pstmt.setString(2, airline);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Flight flight = new Flight();
				flight.setF_id(rs.getInt("f_id"));
				flight.setF_code(rs.getString("f_code"));
				flight.setAirline(rs.getString("airline"));
				flight.setDeparture(rs.getString("departure"));
				flight.setArrival(rs.getString("arrival"));
				flight.setWeekdays(rs.getString("weekdays"));
				flight.setBusiness_fare(rs.getBigDecimal("business_fare"));
				flight.setEconomic_fare(rs.getBigDecimal("economic_fare"));
				flight.setPrime_fare(rs.getBigDecimal("prime_fare"));

				flightData.add(flight);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return flightData;
	}
	
	
	public static List<Flight> getFlightById(int id) {

		List<Flight> flightData = new ArrayList<Flight>();
		Connection con = DBConfig.getConnection();
		

		try {

			PreparedStatement pstmt = con.prepareStatement("Select * from flight_info where f_id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Flight flight = new Flight();
				flight.setF_id(rs.getInt("f_id"));
				flight.setF_code(rs.getString("f_code"));
				flight.setAirline(rs.getString("airline"));
				flight.setDeparture(rs.getString("departure"));
				flight.setArrival(rs.getString("arrival"));
				flight.setWeekdays(rs.getString("weekdays"));
				flight.setBusiness_fare(rs.getBigDecimal("business_fare"));
				flight.setEconomic_fare(rs.getBigDecimal("economic_fare"));
				flight.setPrime_fare(rs.getBigDecimal("prime_fare"));
				
				flightData.add(flight);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return flightData;
		
	}

	// Book new Flight data
		public static boolean bookFlight(Booking booking) {
			boolean bookFlight = false;
			int c_ic = booking.getC_id();
			int f_id = booking.getF_id();
			Date date_of_travel = booking.getDate_of_travel();
			int no_of_passenger = booking.getNo_of_passenger();
			String type = booking.getType();
			BigDecimal total_fare = booking.getTotal_fare();
			
			Connection con = DBConfig.getConnection();
			try {

				if (con != null) {
					String query = "INSERT INTO booking_info (c_id,f_id,date_of_travel,no_of_passenger,class,total_fare) VALUES (?,?,?,?,?,?)";
					PreparedStatement pt = con.prepareStatement(query);
					pt.setInt(1, c_ic);
					pt.setInt(2, f_id);
					pt.setDate(3, date_of_travel);
					pt.setInt(4, no_of_passenger);
					pt.setString(5, type);
					pt.setBigDecimal(6, total_fare);

					int x = pt.executeUpdate();

					if (x != 0) {
						bookFlight = true;

					}
				}
			} catch (Exception e) {

			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return bookFlight;

		}

	

	
}