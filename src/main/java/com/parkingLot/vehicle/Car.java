package com.parkingLot.vehicle;

import com.parkingLot.constants.VehicleType;

public class Car extends Vehicle {

    private String color;

    public Car(VehicleType type, String registrationNumber, String color) {
        super(type, registrationNumber);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
