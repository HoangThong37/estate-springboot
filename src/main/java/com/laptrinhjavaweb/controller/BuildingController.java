package com.laptrinhjavaweb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingSearchRequest;
import com.laptrinhjavaweb.dto.response.BuildingSearchReponse;
import com.laptrinhjavaweb.service.BuildingService;

@RestController
//@RequestMapping(value = "/api")
public class BuildingController {
	
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping("/api/building")
	public List<BuildingSearchReponse> showBuilding(@RequestParam(required = false) Map<String, Object> params,
			@RequestParam(required = false) List<String> types) {
				return buildingService.buildingSearch(params, types);
	}
			
			
			
			
			/*@RequestParam(value = "floorArea", required = false) String floorArea,
			@RequestParam(value = "ward", required = false) String ward,
			@RequestParam(value = "districtCode", required = false) String districtCode,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "numberOfBasement", required = false) String numberOfBasement,
			@RequestParam(value = "direction", required = false) String direction,
			@RequestParam(value = "level", required = false) String level,
			@RequestParam(value = "areaFrom", required = false) Integer areaFrom,
			@RequestParam(value = "areaTo", required = false) Integer areaTo,
			@RequestParam(value = "rentPriceFrom", required = false) Integer rentPriceFrom,
			@RequestParam(value = "rentPriceTo", required = false) Integer rentPriceTo) {
		
		BuildingSearchRequest buildings = new BuildingSearchRequest();
		buildings.setName(name);
		buildings.setFloorArea(floorArea);
		buildings.setWard(ward);
		buildings.setDistrictCode(districtCode);
		buildings.setStreet(street);
		buildings.setNumberOfBasement(numberOfBasement);
		buildings.setDirection(direction);
		buildings.setLevel(level);
		buildings.setAreaFrom(areaFrom);
		buildings.setAreaTo(areaTo);
		buildings.setRentPriceFrom(rentPriceFrom);
		buildings.setRentPriceTo(rentPriceTo);
		
		
		List<BuildingSearchReponse> result = buildingService.buildingSearch(buildings);
		return result;
	}*/
}
