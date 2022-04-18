package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.custom.BuildingRepsitoryCustom;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepsitoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder builder) {
        StringBuilder sql = new StringBuilder("SELECT * from building as b ");
        sql = buildingJoinQuerry(builder, sql);
        sql.append(" where 1 = 1 ");
        sql = buildingSqlPart1WithBuilder(builder, sql);
        sql = buildingSqlPart2WithBuilder(builder, sql);
        sql.append(" group by b.id");
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    private StringBuilder buildingJoinQuerry(BuildingSearchBuilder builder, StringBuilder sql) {
        if (ValidateUtils.isValid(builder.getRentAreaFrom()) || ValidateUtils.isValid(builder.getRentAreaFrom())) {
            sql.append(" inner join rentarea as ra on ra.id = bd.id");
        }
        if (ValidateUtils.isValid(builder.getStaffID())) {
            sql.append( " inner join assignmentbuilding as ab on ab.buildingid = b.id inner join user as u on ab.staffid = u.id ");
        }
        return sql;
    }

    // sử dụng java reflection
    private StringBuilder buildingSqlPart1WithBuilder(BuildingSearchBuilder builder, StringBuilder sql) {
        Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (!fieldName.equals("types") && !fieldName.equals("staffid")
                        && !fieldName.startsWith("costrent")
                        && !fieldName.startsWith("arearent")) {
                    // getValue
                    Object objectValue = field.get(builder);
                    if (objectValue != null)
                    if (objectValue instanceof String) {
                        sql.append(" and b." + fieldName.toLowerCase() + " like '%" + objectValue + "%'");

                    } else if (objectValue instanceof Integer) {
                        sql.append(" and b." + fieldName.toLowerCase() + " = " + objectValue + "");
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return sql;
    }

    private StringBuilder buildingSqlPart2WithBuilder(BuildingSearchBuilder builder, StringBuilder sql) {
        // rentare from
        if (ValidateUtils.isValid(builder.getRentAreaFrom())) {
            sql.append(" and EXISTS (select * from rentarea as ra where b.id = ra.buildingid and ra.value >= " + builder.getRentAreaFrom() + ")");
        }
        // rentare to
        if (ValidateUtils.isValid(builder.getRentAreaTo())) {
            sql.append(" and EXISTS (select * from rentarea as ra where b.id = ra.buildingid and ra.value <= " + builder.getRentAreaTo() + ")");
        }
        // rentprice from
        if (ValidateUtils.isValid(builder.getRentPriceFrom())) {
            sql.append(" and b.rentprice >= " + builder.getRentPriceFrom());
        }
        if (ValidateUtils.isValid(builder.getRentPriceTo())) {
            sql.append(" and b.rentprice <= " + builder.getRentPriceTo());
        }
        // types
        if (builder.getTypes() != null && builder.getTypes().size() > 0) {
            sql.append(" and (");
            String types = builder.getTypes().stream().map(item -> (" b.type like '%" + item + "%'")).collect(Collectors.joining(" or "));
            sql.append(types);
            sql.append(" )");
        }
        if (ValidateUtils.isValid(builder.getStaffID())) {
            sql.append(" and u.id = " + builder.getStaffID());
        }
        return sql;
    }

    /*@Override
    public List<BuildingEntity> findAll(Map<String, Object> params, List<String> types) {
        StringBuilder sql = new StringBuilder("SELECT * from building as b ");
        sql = buildingJoinQuerry(params, types, sql);
        sql.append(" where 1 = 1 ");
        sql = buildingSqlPart1(params, types, sql);
        sql = buildingSqlPart2(params, types, sql);
        sql.append(" group by b.id");
        Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
        return query.getResultList();
    }

    private StringBuilder buildingJoinQuerry(Map<String, Object> params, List<String> types, StringBuilder sql) {
        Integer staffId = params.containsKey("staffid") ? Integer.parseInt((String) params.get("staffid")) : null;
        if (staffId != null) {
            sql.append(" inner join assignmentbuilding as ab on ab.buildingid = b.id ");
        }



        return sql;
    }

    // sql bình thường
    private StringBuilder buildingSqlPart1(Map<String, Object> params, List<String> types, StringBuilder sql) {
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (!entry.getKey().equals("types") && !entry.getKey().equals("staffid")
                    && !entry.getKey().startsWith("costrent")
                    && !entry.getKey().startsWith("arearent")) {
                if (entry.getValue() instanceof String) {
                    sql.append(" and b." + entry.getKey().toLowerCase() + " like '%" + entry.getValue() + "%'");

                } else if (entry.getValue() instanceof Integer) {
                    sql.append(" and b." + entry.getKey().toLowerCase() + " = " + entry.getValue() + "");
                }

            }
        }
        return sql;
    }

    // sql đặc biệt
    private StringBuilder buildingSqlPart2(Map<String, Object> params, List<String> types, StringBuilder sql) {
        // rentarea
        // types
        // staffid
        // costrent
        Integer costRentFrom = params.containsKey("costRentFrom") ? Integer.parseInt((String) params.get("costRentFrom")) : null;
        Integer costRentTo = params.containsKey("costRentTo") ? Integer.parseInt((String) params.get("costRentTo")) : null;

        Integer areaRentFrom = params.containsKey("areaRentFrom") ? Integer.parseInt((String) params.get("areaRentFrom")) : null;
        Integer areaRentTo = params.containsKey("areaRentTo") ? Integer.parseInt((String) params.get("areaRentTo")) : null;

        if (costRentFrom != null) {
            sql.append(" and v.costrent >= " + costRentFrom + "");
        } else if (costRentFrom != null) {
            sql.append(" and v.costrent <= " + costRentTo + "");
        }
        if (areaRentFrom != null || areaRentTo != null) {
            sql.append(" and EXISTS (select * from rentarea as ra where b.id = ra.buildingid");
            if (areaRentFrom != null) {
                sql.append(" and ra.value >= " + areaRentFrom + "");
            }
            if (areaRentTo != null) {
                sql.append(" and ra.value <= " + areaRentTo + "");
            }
            sql.append(")");
        }*/


        // java 7
/*        if (types != null && types.size() > 0) {
            sql.append(" and (");
            int i = 0;
            for (String item : types) {
                // dùng mảng
                types[i] = (" rt.code = '" + item + "'");
                i++;
            }
            String sqlType = String.join(" or ", types);
            sql.append(sqlType);
            sql.append(")");
        }
        }
*/
        // java 8
/*        if (types != null && types.size() > 0) {
            sql.append(" and (");
            String sqlTypes = Arrays.stream().map(item -> " rt.code = '" + item + "'").collect(Collectrs.joining(" or "));
            sql.append(sqlTypes);
            sql.append(")");
        }
*/


    /*private void buildingSqlWithOutJoin(Map<String, String> params, StringBuilder whereSql) {
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
    }*/

}