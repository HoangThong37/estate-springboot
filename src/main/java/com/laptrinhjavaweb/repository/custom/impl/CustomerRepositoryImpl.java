package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomerEntity> findAll(CustomerSearchBuilder builder) {
        try{
            StringBuilder sql = new StringBuilder("select * from customer as c");
            sql = customerJoinQuerry(builder, sql);
            sql.append(" where 1 = 1 ");
            Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
            System.out.println("Thông : " + sql);
            return query.getResultList();

        } catch (Exception exception) {
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }

    private StringBuilder customerJoinQuerry(CustomerSearchBuilder builder, StringBuilder sql) {
        if (ValidateUtils.isValid(builder.getStaffId())) {
            sql.append( " inner join assignmentcustomer as ac on ac.customerid = c.id")
               .append(" and ac.customerid = ")
               .append(builder.getStaffId()).append(",");
        }
        return sql;
    }
}
