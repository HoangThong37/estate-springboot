package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.custom.UserRepositoryCustom;
import com.sun.org.apache.xpath.internal.operations.String;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserRepositoryCustom  {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UserEntity> getAllStaff() {
        StringBuilder sql = new StringBuilder(" Select * from user as u inner join user_role as ur on u.id = ur.userid ");
        Query query = entityManager.createNativeQuery(sql.toString(),UserEntity.class);
        return query.getResultList();
    }

    @Override
    public List<UserEntity> getAllStaffByBuildingId(Long buildingId) {
        StringBuilder sql = new StringBuilder(" Select * from user as u inner join assignmentbuilding as ab on u.id = ab.staffid");
        sql.append(" where ab.buildingid = ").append(buildingId).append(" and u.status = 1 ");
        Query query = entityManager.createNativeQuery(sql.toString(),UserEntity.class);
        return query.getResultList();
    }

/*    @Override
    public List<UserEntity> getAllBuildingByStaffId(Long staffId) {
        StringBuilder sql = new StringBuilder(" Select * from user as u inner join assignmentcustomer as ac on u.id = ac.customerid ");
        sql.append( " where ac.customerid = ").append(staffId).append(" and u.status = 1 ");
        Query query = entityManager.createNativeQuery(sql.toString(),UserEntity.class);
        return query.getResultList();
    }*/
}
