package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {

List<BuildingEntity> buildingSearch(Map<String, Object> params, List<String> types);
}
