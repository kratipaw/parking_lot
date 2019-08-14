package com.parkingLot.vehicle;

import com.parkingLot.constants.VehicleType;

public class Vehicle {

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
