package com.laptrinhjavaweb.repository.custom.impl;

import com.laptrinhjavaweb.builder.CustomerSearchBuilder;
import com.laptrinhjavaweb.entity.CustomerEntity;
import com.laptrinhjavaweb.repository.custom.CustomerRepositoryCustom;
import com.laptrinhjavaweb.utils.ValidateUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.Field;
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
            sql = customerJoinQuery(builder, sql);
            sql.append(" where 1 = 1 ");
            sql = customerJoinQuerySearch(builder, sql); // search like
            sql = customerJoinQuerySearchUser(builder, sql);
            sql.append(" GROUP BY c.id ");
            Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
            System.out.println("Thông querry : " + sql);
            return query.getResultList();
        } catch (Exception exception) {
            exception.printStackTrace();
            return new ArrayList<>();
        }
    }

    private StringBuilder customerJoinQuerySearchUser(CustomerSearchBuilder builder, StringBuilder sql) {
//                if (ValidateUtils.isValid(builder.getStaffId())) {
//                sql.append(" inner join assignmentcustomer as ac on ac.customerid = c.id")
//                   .append(" and ac.staffid = ")
//                   .append(builder.getStaffId()).append(",");
//        }
                    if (ValidateUtils.isValid(builder.getStaffId())) {
                        sql.append(" and u.id = " + builder.getStaffId());
                    }
              return sql;
    }

    private StringBuilder customerJoinQuery(CustomerSearchBuilder builder, StringBuilder sql) {
        if (ValidateUtils.isValid(builder.getStaffId())) {
            sql.append(" inner join assignmentcustomer as ac on ac.customerid = c.id inner join user as u on ac.staffid = u.id ");
        }
        return sql;
    }

    private StringBuilder customerJoinQuerySearch(CustomerSearchBuilder builder, StringBuilder sqlSearch) {
        Field[] fields = CustomerSearchBuilder.class.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = field.getName();
                if (!fieldName.equals("staffid")) {
                    // getValue
                    Object objectValue = field.get(builder);
                    if (objectValue != null) {
                        if (objectValue instanceof String) {
                            sqlSearch.append(" and c." + fieldName.toLowerCase() + " like '%" + objectValue + "%'");
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return sqlSearch;
    }

}
