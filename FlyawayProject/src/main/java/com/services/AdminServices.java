package com.services;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.Admin;
import com.dao.Booking;
import com.dao.Flight;
import com.dao.User;
import com.db.DBConfig;

public class AdminServices {

	public static boolean validateAdmin(Admin admin) {
		boolean isAdminValid = false;
		String email = admin.getEmail();
		String psw = admin.getPassword();

		Connection con = DBConfig.getConnection();

		try {
			if (con != null) {
				PreparedStatement pst = con.prepareStatement("select * from admin_login where uname = ? and psw = ?;");
				pst.setString(1, email);
				pst.setString(2, psw);
				ResultSet rs = pst.executeQuery();

				if (rs.next()) {

					isAdminValid = true;
					admin.setId(rs.getInt(1));
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return isAdminValid;

	}

	public static boolean changePassword(int id, String newPassword) {

		boolean isChange = false;
		Connection con = DBConfig.getConnection();

		try {
			if (con != null) {
				String query = "UPDATE admin_login SET psw = ? WHERE id = ?;";
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

	public static List<User> getAllUser() {

		Connection con = DBConfig.getConnection();
		List<User> userData = new ArrayList<User>();

		try {

			PreparedStatement pstmt = con.prepareStatement("Select * from customer_info");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("c_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setMobile(rs.getString("mobile_no"));
				userData.add(user);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return userData;
	}

	public static List<Flight> getAllFlights() {

		Connection con = DBConfig.getConnection();
		List<Flight> flightData = new ArrayList<Flight>();

		try {

			PreparedStatement pstmt = con.prepareStatement("Select * from flight_info");
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

	public static List<Booking> getAllBooking() {

		Connection con = DBConfig.getConnection();
		List<Booking> bookingData = new ArrayList<Booking>();

		try {

			PreparedStatement pstmt = con.prepareStatement("Select * from booking_info where is_deleted = ?");
			pstmt.setInt(1, 0);
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

	// Save new Flight data
	/**
	 * @param flightData
	 * @return
	 */
	/**
	 * @param flightData
	 * @return
	 */
	public static boolean saveFlight(Flight flightData) {
		boolean saveFlight = false;
		Connection con = DBConfig.getConnection();
		try {

			String f_code = flightData.getF_code();
			String airline = flightData.getAirline();
			String departure = flightData.getDeparture();
			String arrival = flightData.getArrival();
			String weekdays = flightData.getWeekdays();
			BigDecimal business_fare = flightData.getBusiness_fare();
			BigDecimal economic_fare = flightData.getEconomic_fare();
			BigDecimal prime_fare = flightData.getPrime_fare();

		
			if (con != null) {
				String query = "INSERT INTO flight_info (f_code,airline,departure,arrival,weekdays,business_fare,economic_fare,prime_fare) VALUES (?,?,?,?,?,?,?,?)";
				
				PreparedStatement pt = con.prepareStatement(query);
				pt.setString(1, f_code);
				pt.setString(2, airline);
				pt.setString(3, departure);
				pt.setString(4, arrival);
				pt.setString(5, weekdays);
				pt.setBigDecimal(6, business_fare);
				pt.setBigDecimal(7, economic_fare);
				pt.setBigDecimal(8, prime_fare);

				int x = pt.executeUpdate();

				if (x != 0) {
					saveFlight = true;
				}
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return saveFlight;

	}

}
