package com.carpoolingtec.davidqs96.driverapp;


import java.util.Objects;

class Driver {

    private String name = "Name";
    private String surname = "";
    private String id = "1234ffff";
    private String placeResidence = "";
    private boolean infoFilled = false;

    public boolean isInfoFilled() {
        return infoFilled;
    }

    public Driver(){
        checkInfoFilled();
    }

    private void checkInfoFilled(){
        if ((Objects.equals(name, "") || Objects.equals(surname, "") || Objects.equals(id, "") || Objects.equals(placeResidence, ""))){
            infoFilled = false;
        }else{
            infoFilled = true;
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getId() {
        return id;
    }

    public String getPlaceResidence() {
        return placeResidence;
    }

    public void setName(String name) {
        this.name = name;
        checkInfoFilled();
    }

    public void setSurname(String surname) {
        this.surname = surname;
        checkInfoFilled();
    }

    public void setId(String id) {
        this.id = id;
        checkInfoFilled();
    }

    public void setPlaceResidence(String placeResidence) {
        this.placeResidence = placeResidence;
        checkInfoFilled();
    }
}
