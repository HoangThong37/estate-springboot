package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchReponse;

public interface BuildingService {
	List<BuildingSearchReponse> buildingSearch(Map<String, Object> params, List<String> types);



}
