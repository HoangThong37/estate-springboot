package com.laptrinhjavaweb.dto.request;

public class BuildingSearchRequest { // đầu vào
	private String name;
	private String street;
	private String districtCode;
	private String ward; // phường
	private String floorArea;
	private String numberOfBasement;
	private String direction; // hướng
	private String level; // hạng
	private Integer areaFrom; // diện tích từ
	private Integer areaTo; // diện tích đến
	private Integer rentPriceFrom;
	private Integer rentPriceTo;
	private String[] buildingTypes = new String[]{};
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(String floorArea) {
		this.floorArea = floorArea;
	}
	public String getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(String numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getAreaFrom() {
		return areaFrom;
	}
	public void setAreaFrom(Integer areaFrom) {
		this.areaFrom = areaFrom;
	}
	public Integer getAreaTo() {
		return areaTo;
	}
	public void setAreaTo(Integer areaTo) {
		this.areaTo = areaTo;
	}
	public Integer getRentPriceFrom() {
		return rentPriceFrom;
	}
	public void setRentPriceFrom(Integer rentPriceFrom) {
		this.rentPriceFrom = rentPriceFrom;
	}
	public Integer getRentPriceTo() {
		return rentPriceTo;
	}
	public void setRentPriceTo(Integer rentPriceTo) {
		this.rentPriceTo = rentPriceTo;
	}
	public String[] getBuildingTypes() {
		return buildingTypes;
	}
	public void setBuildingTypes(String[] buildingTypes) {
		this.buildingTypes = buildingTypes;
	}
}
	
	