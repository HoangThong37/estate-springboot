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
//		StringBuilder address = new StringBuilder();
		BuildingSearchReponse model = new BuildingSearchReponse();
		
		DistrictEntity districtEntity = districtRepository.findByCode(entity.getDistrictid());
		
//		address.append(entity.getName()).append(entity.getStreet()).append(",").append(entity.getWard()).append(",").append(entity.getDistrictid())
//		.append(entity.getFloorarea()).append(entity.getRentprice()).append(entity.getServicefee()).append(entity.getBrokeragefee());
//		model.setAddress(entity.getStreet() + "," + entity.getWard() + "," + entity.getName());

		model.setName(entity.getName());
		  
		model.setAddress(entity.getStreet() + " , " + entity.getWard() + " , " + districtEntity.getName());
		model.setFloorArea(entity.getFloorarea());
		model.setRentPrice(entity.getRentprice());
		model.setServiceFee(entity.getServicefee());
		model.setBrokerageFee(entity.getBrokeragefee());
		
		return model;
	}
}