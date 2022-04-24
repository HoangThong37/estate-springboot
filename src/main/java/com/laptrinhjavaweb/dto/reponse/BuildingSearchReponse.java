package com.laptrinhjavaweb.dto.reponse;

public class BuildingSearchReponse extends  BaseReponse { // đầu ra
    private String name;
    private String address; // = đường + phường + quận
    private Integer floorArea; // diện tích sàn;
    private String areaEmpty; // diện tích trống
    private Integer rentPrice; // giá thuê
    private Integer serviceFee; // phí dịch vụ
    private Integer brokerageFee;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getFloorArea() {
        return floorArea;
    }
    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }
    public String getAreaEmpty() {
        return areaEmpty;
    }
    public void setAreaEmpty(String areaEmpty) {
        this.areaEmpty = areaEmpty;
    }
    public Integer getRentPrice() {
        return rentPrice;
    }
    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }
    public Integer getServiceFee() {
        return serviceFee;
    }
    public void setServiceFee(Integer serviceFee) {
        this.serviceFee = serviceFee;
    }
    public Integer getBrokerageFee() {
        return brokerageFee;
    }
    public void setBrokerageFee(Integer brokerageFee) {
        this.brokerageFee = brokerageFee;
    } // phí môi giới


}
