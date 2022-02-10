package com.laptrinhjavaweb.Converter;

import com.laptrinhjavaweb.dto.response.BuildingSearchReponse;
import com.laptrinhjavaweb.repository.DistrictRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.DistrictEntity;
import com.laptrinhjavaweb.repository.impl.DistrictRepositoryImpl;


public class BuildingConverter {
	private final DistrictRepository districtRepository = new DistrictRepositoryImpl();

	public static BuildingSearchReponse ConvertBuilding(BuildingEntity entity) {
		DistrictRepository districtRepository = new DistrictRepositoryImpl();		
		BuildingSearchReponse model = new BuildingSearchReponse();
		
		DistrictEntity districtEntity = districtRepository.findByCode(entity.getDistrictid());
		model.setName(entity.getName());
		model.setAddress(entity.getStreet() + " , " + entity.getWard() + " , " + entity.getName());
		model.setFloorArea(entity.getFloorarea());
		model.setRentPrice(entity.getRentprice());
		model.setServiceFee(entity.getServicefee());
		model.setBrokerageFee(entity.getBrokeragefee());
		return model;
	}
}
