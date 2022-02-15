package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.utils.ConnectionUtils;
import com.laptrinhjavaweb.utils.ValidateUtils;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	@Override
	public List<BuildingEntity> buildingSearch(Map<String, String> params, List<String> types) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BuildingEntity> buildingSearch = new ArrayList<>();
		try {
//			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			conn = ConnectionUtils.getConnection();
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

				while (rs.next()) { // hứng kết quả
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

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtils.close(conn, stmt, rs);
		}
		return new ArrayList<>();
	}

	private void buildingSqlWithOutJoin(Map<String, String> params, StringBuilder whereSql) {
		// name
		String name = params.getOrDefault("name", null);
		if (ValidateUtils.isNotBlank(name)) {
			whereSql.append("and bd.name like '%").append(name).append("%'");
		}
		// street
		String street = params.getOrDefault("street", null);
		if (ValidateUtils.isNotBlank(street)) {
			whereSql.append("and bd.street like '%").append(street).append("%'");
		}
		//ward
		String ward = params.getOrDefault("ward", null);
		if (ValidateUtils.isNotBlank(ward)) {
			whereSql.append("and bd.ward like '%").append(params.get("ward")).append("%'");
		
		//level
		String level = params.getOrDefault("level", null);
		if (ValidateUtils.isNotBlank(level)) {
			whereSql.append(" and bd.level like '%").append(params.get("level")).append("%'");
		}
		
		//direction
		String direction = params.getOrDefault("direction", null);
		if (ValidateUtils.isNotBlank(direction)) {
			whereSql.append(" and bd.direction like '%").append(params.get("direction")).append("%'");
		}
		// floorarea
		String floorArea = params.getOrDefault("floorArea", null);
		if (ValidateUtils.isNotBlank(floorArea)) {
			whereSql.append(" and bd.floorarea =").append(params.get("floorArea"));
		}
		
		// rentpriceFrom
		String rentpriceFrom = params.getOrDefault("rentPriceFrom", null);
		if (ValidateUtils.isNotBlank(rentpriceFrom)) {
			whereSql.append(" and bd.rentprice >= ").append(params.get("rentPriceFrom"));
		}
		
		//rentPriceTo
		String rentpriceTo = params.getOrDefault("rentPriceTo", null);
		if (ValidateUtils.isNotBlank(rentpriceTo)) {
			whereSql.append(" and bd.rentprice <= ").append(params.get("rentPriceTo"));
		}

		// numberofbasement
		String numberofbasement = params.getOrDefault("numberofbasement", null);
		if (ValidateUtils.isNotBlank(numberofbasement)) {
			whereSql.append("and bd.numberofbasement = ").append(params.get("numberofbasement"));
		}
	} }

	private void buildingSqlWithJoin(Map<String, String> params, List<String> types, StringBuilder whereSql,
			StringBuilder joinSql) {
		String AreaRentFrom = params.getOrDefault("AreaRentFrom", null);
		String AreaRentTo = params.getOrDefault("AreaRentTo", null);
		
		if (ValidateUtils.isNotBlank(AreaRentFrom) || ValidateUtils.isNotBlank(AreaRentTo)) {
			joinSql.append(" inner join rentarea as ra on ra.id = bd.id");
			if (ValidateUtils.isNotBlank(AreaRentFrom)) {
				whereSql.append(" ra.value >=").append(AreaRentFrom);
			}
			if (ValidateUtils.isNotBlank(AreaRentTo)) {
				whereSql.append(" ra.value <=").append(AreaRentTo);
			}
		}
		
        String staffId = params.getOrDefault("staffId", null);
		if (ValidateUtils.isNotBlank(staffId)) {
			joinSql.append(
					" inner join assignmentbuilding as ab on ab.buildingid = bd.id inner join user as u on ab.staffid = u.id ");
			whereSql.append(" and staffid = ").append(staffId);
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
		}
	}
}