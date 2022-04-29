package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.UserEntity;

import java.util.List;

public interface UserRepositoryCustom {
    List<UserEntity> getAllStaff();
    List<UserEntity> getAllStaffByBuildingId(Long buildingId);
    List<UserEntity> getAllBuildingByStaffId(Long staffId);
}
