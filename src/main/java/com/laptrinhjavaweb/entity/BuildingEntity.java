package com.laptrinhjavaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {
    // id,  createdDate ....
    // nullable = false => y/c k đc null
    // nullable = true  => nó sẽ định nghĩa gtri đó là duy nhất

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "ward", nullable = false)
    private String ward;

    @Column(name = "district")
    private String district;

    @Column(name = "structure")
    private String structure;

    @Column(name = "numberofbasement")
    private String numberOfBasement;

    @Column(name = "floorarea")
    private Integer floorArea; // diện tích sàn;

    @Column(name = "direction")
    private String direction; // hướng

    @Column(name = "level")
    private String level; // hạng

    @Column(name = "rentprice")
    private Integer rentPrice; //

    @Column(name = "rentpricedescription")
    private Integer rentPriceDescription;

    @Column(name = "rentareadescription")
    private Integer rentAreaDescription;

    @Column(name = "type")
    private String type;

    @Column(name = "servicefee")
    private Integer serviceFee;

    @Column(name = "carfee")
    private String carFee;

    @Column(name = "createddate")
    private String motorbikefee;

    @Column(name = "overtimeFee")
    private String overtimefee;

    @Column(name = "waterfee")
    private String waterFee;

    @Column(name = "electricityfee")
    private String electricityFee;

    @Column(name = "deposit")
    private String deposit;

    @Column(name = "payment")
    private String payment;

    @Column(name = "renttime")
    private String rentTime;

    @Column(name = "decorationtime")
    private String decorationTime;

    @Column(name = "brokeragefee")
    private Integer brokeragefee;

    @Column(name = "note")
    private String note;

    @Column(name = "linkofbuilding")
    private String linkOfBuilding;

    @Column(name = "map")
    private String map;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "managerphone")
    private String managerPhone;

    @Column(name = "managername")
    private String managerName;

    @OneToMany(mappedBy = "assignmentBuilding")
    private List<AssignmentBuildingEntity> assignmentBuildings = new ArrayList<>();

    @OneToMany(mappedBy = "rentArea")
    private List<RentAreaEntity>  rentAreas = new ArrayList<>();

    public List<AssignmentBuildingEntity> getAssignmentBuildings() {
        return assignmentBuildings;
    }

    public void setAssignmentBuildings(List<AssignmentBuildingEntity> assignmentBuildings) {
        this.assignmentBuildings = assignmentBuildings;
    }

    public List<RentAreaEntity> getRentAreas() {
        return rentAreas;
    }

    public void setRentAreas(List<RentAreaEntity> rentAreas) {
        this.rentAreas = rentAreas;
    }

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

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(String numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
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

    public Integer getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(Integer rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Integer getRentPriceDescription() {
        return rentPriceDescription;
    }

    public void setRentPriceDescription(Integer rentPriceDescription) {
        this.rentPriceDescription = rentPriceDescription;
    }

    public Integer getRentAreaDescription() {
        return rentAreaDescription;
    }

    public void setRentAreaDescription(Integer rentAreaDescription) {
        this.rentAreaDescription = rentAreaDescription;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(Integer serviceFee) {
        this.serviceFee = serviceFee;
    }

    public String getCarFee() {
        return carFee;
    }

    public void setCarFee(String carFee) {
        this.carFee = carFee;
    }

    public String getMotorbikefee() {
        return motorbikefee;
    }

    public void setMotorbikefee(String motorbikefee) {
        this.motorbikefee = motorbikefee;
    }

    public String getOvertimefee() {
        return overtimefee;
    }

    public void setOvertimefee(String overtimefee) {
        this.overtimefee = overtimefee;
    }

    public String getWaterFee() {
        return waterFee;
    }

    public void setWaterFee(String waterFee) {
        this.waterFee = waterFee;
    }

    public String getElectricityFee() {
        return electricityFee;
    }

    public void setElectricityFee(String electricityFee) {
        this.electricityFee = electricityFee;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public String getDecorationTime() {
        return decorationTime;
    }

    public void setDecorationTime(String decorationTime) {
        this.decorationTime = decorationTime;
    }

    public Integer getBrokeragefee() {
        return brokeragefee;
    }

    public void setBrokeragefee(Integer brokeragefee) {
        this.brokeragefee = brokeragefee;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLinkOfBuilding() {
        return linkOfBuilding;
    }

    public void setLinkOfBuilding(String linkOfBuilding) {
        this.linkOfBuilding = linkOfBuilding;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }
}
