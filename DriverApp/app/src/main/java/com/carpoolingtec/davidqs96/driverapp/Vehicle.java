package com.carpoolingtec.davidqs96.driverapp;

import java.util.Objects;

class Vehicle {

    private String brand = "";
    private String model = "";
    private String licensePlate = "";
    private boolean infoFilled = false;

    public boolean isInfoFilled() {
        return infoFilled;
    }

    public Vehicle(){
        checkInfoFilled();
    }

    private void checkInfoFilled(){
        if (Objects.equals(brand, "") || Objects.equals(model, "") || Objects.equals(licensePlate, "")){
            infoFilled = false;
        }else{
            infoFilled = true;
        }
    }

    public void setBrand(String brand) {
        this.brand = brand;
        checkInfoFilled();
    }

    public void setModel(String model) {
        this.model = model;
        checkInfoFilled();
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
        checkInfoFilled();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
