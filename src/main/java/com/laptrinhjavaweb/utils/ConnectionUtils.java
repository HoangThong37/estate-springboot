package com.laptrinhjavaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.laptrinhjavaweb.constant.BuildingConstant;

public class ConnectionUtils {
	   public  static Connection getConnection() throws SQLException {
	        try {
	            Class.forName(BuildingConstant.DRIVER);
	            return DriverManager.getConnection(BuildingConstant.DB_URL, BuildingConstant.USER, BuildingConstant.PASS);

	        } catch (ClassNotFoundException | SQLException e) {
	            throw new SQLException("Could not get connection!");
	        }
	    } 
	   
	   public static void close (Connection conn, Statement stmt, ResultSet rs){
	        try {
	            if (conn!=null){
	                conn.close();
	            }
	            if (rs!=null){
	                rs.close();
	            }
	            if (stmt!=null){
	                stmt.close();
	            }
	        }catch (Exception e){
	            e.getMessage();
	        }
/*	public static Connection getConnections() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/estatebasic?useSSL=false";
			String user = "root";
			String password = "123456";
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			return null;
		}
	}*/
	   }}
