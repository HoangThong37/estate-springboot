package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.custom.impl.RentAreaRepositoryImpl;

import java.util.List;

public interface RentAreaRepositoryCustom {
    void saveAllByBuilding(List<RentAreaEntity> rentAreaEntities, BuildingEntity buildingEntity); // diện tích thuê
}
