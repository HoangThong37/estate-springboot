package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.laptrinhjavaweb.repository.DistrictRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.DistrictEntity;
import com.mysql.jdbc.PreparedStatement;

public class DistrictRepositoryImpl implements DistrictRepository {
	private final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private final String USER = "root";
	private final String PASS = "123456";

	@Override
	public DistrictEntity findByCode(Integer id) {
		Connection conn = null;
		java.sql.PreparedStatement stmt = null;
		ResultSet rs = null;
		DistrictEntity districtEntity = new DistrictEntity();
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (id != null) {
				StringBuilder query = new StringBuilder("Select id, name from district where 1 = 1");
				stmt = conn.prepareStatement(query.toString());
				stmt.setInt(1, id);
				rs = stmt.executeQuery();
				while (rs.next()) {
					districtEntity.setName(rs.getString("name")); // set gtri name cho building
				}
			}
			return districtEntity;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new DistrictEntity();
	}
}
