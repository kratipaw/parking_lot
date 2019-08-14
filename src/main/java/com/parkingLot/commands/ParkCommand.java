package com.parkingLot.commands;

import com.parkingLot.commands.BaseCommand;
import com.parkingLot.ParkingLot;
import com.parkingLot.constants.VehicleType;
import com.parkingLot.vehicle.Car;
import com.parkingLot.vehicle.Vehicle;

public class ParkCommand extends BaseCommand {

    private String registrationNumber = "";
    private String color = "";
    private Vehicle vehicle = null;

    @Override
    protected boolean isValidCommand(String[] cmdTokens) {

        if(cmdTokens.length != 3)
            return false;

        if(cmdTokens[1] == null || cmdTokens[2] == null  || cmdTokens[1].isEmpty() || cmdTokens[2].isEmpty())
            return false;

        registrationNumber = cmdTokens[1];
        color = cmdTokens[2];

        vehicle = new Car(VehicleType.CAR, registrationNumber, color);

        return true;
    }

    @Override
    protected String executeCommand() {
        return ParkingLot.parkCar(vehicle);
    }
}
