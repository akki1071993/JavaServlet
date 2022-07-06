package com.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.Admin;
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
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return isAdminValid;

	}

}
