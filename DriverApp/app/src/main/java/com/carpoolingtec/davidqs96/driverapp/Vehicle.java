package com.carpoolingtec.davidqs96.driverapp;

import java.util.Objects;

class Vehicle {

    private String brand = "";
    private String model = "";
    private String licensePlate = "";
    private boolean infoFilled = false;

    public Vehicle(){
        checkInfoFilled();
    }

    public boolean isInfoFilled() {
        return infoFilled;
    }

    public void checkInfoFilled(){
        if (Objects.equals(brand, "") || Objects.equals(model, "") || Objects.equals(licensePlate, "")){
            infoFilled = false;
        }else{
            infoFilled = true;
        }
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
