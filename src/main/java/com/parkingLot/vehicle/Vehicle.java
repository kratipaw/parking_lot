package main.java.com.parkingLot.vehicle;

import main.java.com.parkingLot.constants.VehicleType;

class Vehicle {

    private String registrationNumber;

    private VehicleType vehicleType;

    Vehicle(VehicleType type, String registrationNumber){
        this.vehicleType = type;
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
