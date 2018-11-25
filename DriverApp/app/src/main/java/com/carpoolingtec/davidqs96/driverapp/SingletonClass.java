package com.carpoolingtec.davidqs96.driverapp;

class SingletonClass{

    private static SingletonClass singleton;
    private static Driver driver = new Driver();
    private static Vehicle vehicle = new Vehicle();

    private SingletonClass(){}

    public static Driver getDriver() {
        return driver;
    }

    public static Vehicle getVehicle() {
        return vehicle;
    }

    public static synchronized SingletonClass getSingleton(){
        if (singleton == null){
            singleton = new SingletonClass();
        }
        return singleton;
    }


}
