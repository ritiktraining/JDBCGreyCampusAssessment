package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateCustomerDetails {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String sql = "insert into customer_details values(?,?,?,?,?,?,?,?,?,?,?,?)";

		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer_details", "c##bms", "abc");
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, 1);
			prepareStatement.setString(2, "Ritik");
			prepareStatement.setString(3, "Kumar");
			prepareStatement.setString(4, "Street No. 25");
			prepareStatement.setString(5, "Rajpura");
			prepareStatement.setString(6, "Punjab");
			prepareStatement.setInt(7, 140401);
			prepareStatement.setString(8, "GreyCampus");
			prepareStatement.setDate(9, date);
			prepareStatement.setString(10, "Ritik");
			prepareStatement.setDate(11, date);
			prepareStatement.setString(12, "admin");
			int count = prepareStatement.executeUpdate();
			System.out.println(count);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
