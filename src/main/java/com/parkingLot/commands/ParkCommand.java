package main.java.com.parkingLot.commands;

import main.java.com.parkingLot.ParkingLot;
import main.java.com.parkingLot.constants.VehicleType;
import main.java.com.parkingLot.vehicle.Car;
import main.java.com.parkingLot.vehicle.Vehicle;

public class ParkCommand extends BaseCommand{

    private String registrationNumber = "";
    private String color = "";
    private Vehicle vehicle = null;

    @Override
    protected boolean isValidCommand(String[] cmdTokens) {

        if(cmdTokens.length != 3)
            return false;

        registrationNumber = cmdTokens[1];
        color = cmdTokens[2];

        vehicle = new Car(VehicleType.CAR, registrationNumber, color);

        return true;
    }

    @Override
    protected String executeCommand() {

        return ParkingLot.assignParkingSpotToCar(vehicle);
    }
}
