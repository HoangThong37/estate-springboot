package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.custom.RentAreaRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentAreaRepository extends RentAreaRepositoryCustom, JpaRepository<RentAreaEntity, Long>  {
    List<RentAreaEntity> findByBuildingEntity(BuildingEntity buildingEntity);
}








/*
Trong Spring JPA, cơ chế xây dựng truy vấn thông qua tên của method được quy định bởi các tiền tố sau:

find…By, read…By, query…By, count…By, và get…By.

phần còn lại sẽ được parse theo tên của thuộc tính (viết hoa chữ cái đầu).
Nếu chúng ta có nhiều điều kiện, thì các thuộc tính có thể kết hợp với nhau bằng chữ And hoặc Or.

*/