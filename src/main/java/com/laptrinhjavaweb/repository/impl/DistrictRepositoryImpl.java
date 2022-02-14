package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import com.laptrinhjavaweb.repository.DistrictRepository;
import com.laptrinhjavaweb.repository.entity.DistrictEntity;
import com.laptrinhjavaweb.utils.ConnectionUtils;

public class DistrictRepositoryImpl implements DistrictRepository {

	@Override
	public DistrictEntity findByCode(Integer id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		DistrictEntity districtEntity = new DistrictEntity();
		try {
			conn = ConnectionUtils.getConnection();
			if (conn != null) {
				System.out.println("Kết nối thành công");
				StringBuilder query = new StringBuilder("Select id, name from district where 1 = 1");
				if (id != null) {
					query.append(" and id = ? ");
					stmt = conn.prepareStatement(query.toString());
					stmt.setInt(1, id);
					rs = stmt.executeQuery();
					while (rs.next()) {
						districtEntity.setName(rs.getString("name")); // set gtri name cho building

					}
				}
				return districtEntity;

			}
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
