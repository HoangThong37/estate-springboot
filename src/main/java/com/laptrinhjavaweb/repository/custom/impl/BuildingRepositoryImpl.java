package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.entity.UserEntity;
//import com.laptrinhjavaweb.repository.AssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.AssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.repository.custom.BuildingRepsitoryCustom;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BuildingRepositoryImpl implements BuildingRepsitoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;

    @Override
    public List<BuildingEntity> findAll(BuildingSearchBuilder builder) {
        try {
            StringBuilder sql = new StringBuilder("SELECT * from building as b ");
            sql = buildingJoinQuerry(builder, sql);
            sql.append(" where 1 = 1 ");
            sql = buildingSqlPart1WithBuilder(builder, sql);
            sql = buildingSqlPart2WithBuilder(builder, sql);
            sql.append(" group by b.id");
            Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
            return query.getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private StringBuilder buildingJoinQuerry(BuildingSearchBuilder builder, StringBuilder sql) {
        if (ValidateUtils.isValid(builder.getRentAreaFrom()) || ValidateUtils.isValid(builder.getRentAreaFrom())) {
            sql.append(" inner join rentarea as ra on ra.id = b.id");
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
                    if (objectValue != null) {
                        if (objectValue instanceof String) {
                            sql.append(" and b." + fieldName.toLowerCase() + " like '%" + objectValue + "%'");

                        } else if (objectValue instanceof Integer) {
                            sql.append(" and b." + fieldName.toLowerCase() + " = " + objectValue + "");
                        }
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
    public void assignmentBuilding(List<UserEntity> userEntities, BuildingEntity buildingEntity) {
    }*/

    /*@Transactional
    @Override
    public void assignmentBuilding(List<UserEntity> userEntities, BuildingEntity buildingEntity) {
        for (UserEntity item : userRepository.getAllStaffByBuildingId(buildingEntity.getId())) {
            int i = 0;
            for (UserEntity item1 : userEntities) {
                if (item.getId() == item1.getId()) {
                    i++;
                }
            }
            if (i == 0) {
                AssignmentBuildingEntity assignmentBuildingEntity
                        = assignmentBuildingRepository.findByBuildingEntityAndUserEntity(buildingEntity, item);
                entityManager.remove(assignmentBuildingEntity); // xóa
            }
        }
        for (UserEntity item : userEntities) {
            int i = 0;
            for (UserEntity item2 : userRepository.getAllStaffByBuildingId(buildingEntity.getId())) {
                if (item.getId() == item2.getId()) {
                    i++;
                }
            }
            if (i == 0) {
                AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity();
                assignmentBuildingEntity.setBuildingEntity(buildingEntity);
                assignmentBuildingEntity.setUserEntity(item);
                entityManager.persist(assignmentBuildingEntity); // thêm mới
            }
        }
    }*/

   /* @Transactional
    @Override
    public void deleteBuilding(BuildingEntity buildingEntity) { // xóa building
        if (buildingEntity.getRentAreaEntities().size() > 0) {
           for (RentAreaEntity item : buildingEntity.getRentAreaEntities()) {
               RentAreaEntity rentAreaEntity = rentAreaRepository.findOne(item.getId());
               entityManager.remove(rentAreaEntity);
           }
        }
        if (buildingEntity.getAssignmentBuildingEntities().size() > 0) {
            for (AssignmentBuildingEntity item1 : buildingEntity.getAssignmentBuildingEntities()) {
                AssignmentBuildingEntity assignmentBuilding = assignmentBuildingRepository.findOne(item1.getId());
                entityManager.remove(assignmentBuilding);
            }
        }
        entityManager.remove(buildingEntity);
    }*/


}