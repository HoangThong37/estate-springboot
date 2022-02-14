package com.laptrinhjavaweb.Converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.response.BuildingSearchReponse;
import com.laptrinhjavaweb.repository.DistrictRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.DistrictEntity;
import com.laptrinhjavaweb.repository.impl.DistrictRepositoryImpl;

@Component
public class BuildingConverter {
	private final DistrictRepository districtRepository = new DistrictRepositoryImpl();

	@Autowired
	private ModelMapper mapper;

/*	public static BuildingSearchReponse ConvertBuilding(BuildingEntity entity) {
		DistrictRepository districtRepository = new DistrictRepositoryImpl();
//		StringBuilder address = new StringBuilder();
		BuildingSearchReponse model = new BuildingSearchReponse();
		DistrictEntity districtEntity = districtRepository.findByCode(entity.getDistrictid());
		model.setName(entity.getName());
		model.setAddress(entity.getStreet() + "," + entity.getWard() + "," + districtEntity.getName());
		model.setFloorArea(entity.getFloorarea());
		model.setRentPrice(entity.getRentprice());
		model.setServiceFee(entity.getServicefee());
		model.setBrokerageFee(entity.getBrokeragefee());
		return model;
	}
	// định nghĩa 
*/
	public BuildingSearchReponse convertBuildingSerachReponse(BuildingEntity entity) {
		
		BuildingSearchReponse buildingSearchReponse = mapper.map(entity, BuildingSearchReponse.class);
		
		DistrictEntity districtEntity = districtRepository.findByCode(entity.getDistrictid());
		buildingSearchReponse
				.setAddress(entity.getStreet() + "," + entity.getWard() + "," + districtEntity.getName());
		return buildingSearchReponse;
	}
}
