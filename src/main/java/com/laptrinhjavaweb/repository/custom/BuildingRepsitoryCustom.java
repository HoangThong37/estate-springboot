package com.laptrinhjavaweb.repository.custom;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface BuildingRepsitoryCustom {
    List<BuildingEntity> findAll(BuildingSearchBuilder builder);
//    void assignmentBuilding(List<UserEntity> userEntities, BuildingEntity buildingEntity);
  //  void deleteBuilding(BuildingEntity buildingEntity);
}

