package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.Converter.BuildingConverter;
import com.laptrinhjavaweb.dto.response.BuildingSearchReponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.impl.BuildingRepositoryImpl;
import com.laptrinhjavaweb.service.BuildingService;
import com.laptrinhjavaweb.utils.ValidateUtils;

@Service
@Repository
public class BuildingServiceImpl implements BuildingService {
	private BuildingRepository buildingRepository = new BuildingRepositoryImpl();
	private BuildingConverter buildingConverter ;
	
	public BuildingServiceImpl(BuildingConverter buildingConverter) {
		this.buildingConverter = buildingConverter;
	}

//	@Autowired
//	private BuildingRepository buildingRepository;
//	@Autowired
//	private BuildingConverter buildingConverter;

	@Override
	public List<BuildingSearchReponse> buildingSearch(Map<String, Object> params, List<String> types) {
			Map<String, Object> validParams = validateParams(params);	// xem có dữ liệu truyền vào k
			// convert entity -> reponse
			List<BuildingEntity> buildingEntities = buildingRepository.buildingSearch(params, types);
			List<BuildingSearchReponse> buildingResponses = new ArrayList<>();
			for(BuildingEntity entity : buildingEntities) {
				BuildingSearchReponse model = buildingConverter.ConvertBuilding(entity);
				buildingResponses.add(model);
			}
			return buildingResponses;
	}

		private Map<String, Object> validateParams(Map<String, Object> params) {
			Map<String, Object> validParams = new HashMap<>();
			for(Map.Entry<String, Object> entry : params.entrySet()) {  // entrySet : được sử dụng để trả lại đối tượng Set có chứa tất cả các keys và values. 
				if (ValidateUtils.isValid(entry.getValue())) {
					validParams.put(entry.getKey().toLowerCase(), entry.getValue());
				}			
			}
			return validParams;
		}

}
