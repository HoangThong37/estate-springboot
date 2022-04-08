package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepsitoryCustom;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BuildingRepositoryImpl implements BuildingRepsitoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> buildingSearch(Map<String, String> params, List<String> types) {
//        List<BuildingEntity> buildingSearch = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT bd.name,bd.floorarea,bd.street,bd.ward,bd.districtid,"
                + "bd.rentprice,bd.brokeragefee,bd.servicefee\r\n"
                + " FROM building as bd INNER JOIN district as ds on bd.districtid = ds.id");
        // bđ
        StringBuilder joinSql = new StringBuilder();
        StringBuilder whereSql = new StringBuilder();
        buildingSqlWithJoin(params, types, whereSql, joinSql);
        buildingSqlWithOutJoin(params, whereSql);
        sql.append(joinSql).append(" where 1=1 ").append(whereSql).append(" GROUP BY bd.id");
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
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

    @Override
    public void insert(BuildingEntity buildingEntity) {

    }
}
