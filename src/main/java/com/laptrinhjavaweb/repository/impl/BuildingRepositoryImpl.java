package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.feed.RssChannelHttpMessageConverter;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.Converter.BuildingConverter;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchReponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.utils.StringUtils;
import com.laptrinhjavaweb.utils.ValidateUtils;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	private final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private final String USER = "root";
	private final String PASS = "123456";

	@Override
	public List<BuildingEntity> buildingSearch(Map<String, Object> params, List<String> types) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BuildingEntity> buildingSearch = new ArrayList<>();
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			if (conn != null) {
				System.out.println("success connected");
				
				StringBuilder sql = new StringBuilder("SELECT bd.name,bd.floorarea,bd.street,bd.ward,bd.districtid,"
						+ "bd.rentprice,bd.brokeragefee,bd.servicefee\r\n"
						+ " FROM building as bd INNER JOIN district as ds on bd.districtid = ds.id");

				StringBuilder joinSql = new StringBuilder();
				StringBuilder whereSql = new StringBuilder();
				buildingSqlWithJoin(params, types, whereSql, joinSql);
				buildingSqlWithOutJoin(params, whereSql);
				sql.append(joinSql).append(" where 1=1 ").append(whereSql).append(" GROUP BY bd.id");
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql.toString());
				
				while (rs.next()) {   // hứng kết quả
					BuildingEntity building = new BuildingEntity();
					building.setDistrictid(rs.getInt("bd.districtid"));
					building.setName(rs.getString("bd.name"));
					building.setStreet(rs.getString("bd.street"));
					building.setWard(rs.getString("bd.ward"));
					building.setRentprice(rs.getInt("bd.rentprice"));
					building.setBrokeragefee(rs.getInt("bd.brokeragefee"));
					building.setFloorarea(rs.getInt("bd.floorarea"));
					building.setServicefee(rs.getInt("bd.servicefee"));
					buildingSearch.add(building);
				}
			}
			return buildingSearch;

		} catch (SQLException | ArithmeticException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new ArrayList<>();
	}

	private void buildingSqlWithOutJoin(Map<String, Object> params, StringBuilder whereSql) {
		if (ValidateUtils.isValid(params.get("name"))) {
			whereSql.append("and bd.name like '%").append(params.get("name")).append("%'");
		}
		if (ValidateUtils.isValid(params.get("street"))) {
			whereSql.append("and bd.street like '%").append(params.get("street")).append("%'");
		}
		if (ValidateUtils.isValid(params.get("ward"))) {
			whereSql.append("and bd.ward like '%").append(params.get("ward")).append("%'");
		}
		if (ValidateUtils.isValid(params.get("level"))) {
			whereSql.append(" and bd.level like '%").append(params.get("level")).append("%'");
		}
		if (ValidateUtils.isValid(params.get("direction"))) {
			whereSql.append(" and bd.direction like '%").append(params.get("direction")).append("%'");
		}
		// floorarea
		if (ValidateUtils.isValid(params.get("floorArea"))) {
			whereSql.append(" and bd.floorarea =").append(params.get("floorArea"));
		}
		// rentprice
		if (ValidateUtils.isValid(params.get("rentPriceFrom"))) {
			whereSql.append(" and bd.rentprice >= ").append(params.get("rentPriceFrom"));
		}
		if (ValidateUtils.isValid(params.get("rentPriceTo"))) {
			whereSql.append(" and bd.rentprice <= ").append(params.get("rentPriceTo"));
		}

		// numberofbasement
		if (ValidateUtils.isValid(params.get("numberofbasement"))) {
			whereSql.append("and bd.numberofbasement = ").append(params.get("numberofbasement"));
		}

	}

	private void buildingSqlWithJoin(Map<String, Object> params, List<String> types, StringBuilder whereSql,
			StringBuilder joinSql) {
		if (ValidateUtils.isValid(params.get("AreaRentFrom")) || ValidateUtils.isValid(params.get("AreaRentTo"))) {
			joinSql.append(" inner join rentarea as ra on ra.id = bd.id");
			if (ValidateUtils.isValid(params.get("AreaRentFrom"))) {
				whereSql.append(" ra.value >=").append(params.get("AreaRentFrom"));
			}
			if (ValidateUtils.isValid(params.get("AreaRentTo"))) {
				whereSql.append(" ra.value <=").append(params.get("AreaRentTo"));
			}
		}

		if (ValidateUtils.isValid(params.get("AreaRentFrom")) || ValidateUtils.isValid(params.get("AreaRentTo"))) {
			joinSql.append(" inner join rentarea as ra on ra.id = bd.id");
			if (ValidateUtils.isValid(params.get("AreaRentFrom"))) {
				whereSql.append(" ra.value >=").append(params.get("AreaRentFrom"));
			}
			if (ValidateUtils.isValid(params.get("AreaRentTo"))) {
				whereSql.append(" ra.value <=").append(params.get("AreaRentTo"));
			}
		}
		if (ValidateUtils.isValid(params.get("staffId"))) {
			joinSql.append(" inner join assignmentbuilding as ab on ab.buildingid = bd.id inner join user as u on ab.staffid = u.id ");
			whereSql.append(" and staffid = ").append(params.get("staffId"));
		}
		
		// BuildingTypes()
		if (types != null && !types.isEmpty()) {
			joinSql.append(" inner join buildingrenttype as brt on brt.buildingid = bd.id\n "
					+ " inner join renttype as rt on brt.renttypeid = rt.id");
			List<String> buildingtypes = new ArrayList<>();
			for (String item : types) {
				buildingtypes.add(" rt.code like '%" + item + "%'");
			}
			whereSql.append(" and( ").append(String.join(" OR ", buildingtypes)).append(")");
		} }
}