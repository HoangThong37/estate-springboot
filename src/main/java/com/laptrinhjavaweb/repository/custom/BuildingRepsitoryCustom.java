package com.laptrinhjavaweb.repository.custom;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;

import java.util.List;
import java.util.Map;

public interface BuildingRepsitoryCustom {
    /*List<BuildingEntity> findAll(Map<String, Object> params, List<String> types);*/
    List<BuildingEntity> findAll(BuildingSearchBuilder builder);
}

