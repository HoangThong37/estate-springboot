package com.laptrinhjavaweb.repository.custom;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;
import java.util.Map;

public interface BuildingRepsitoryCustom {
    List<BuildingEntity> buildingSearch(Map<String, String> params, List<String> types);
    void insert(BuildingEntity buildingEntity);
}

