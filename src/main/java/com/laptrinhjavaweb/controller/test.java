package com.laptrinhjavaweb.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class test {
	public static Connection getConnections() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/estatebasic?useSSL=false";
			String user = "root";
			String password = "123456";
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			return null;
		}
	}
	public static void main(String[] args) {
		if (getConnections() != null) {
			System.out.println("Truy cap thanh cong");
		}
		if (getConnections() == null) {
			System.out.println("Truy cap that bai");
		}
	}

}
