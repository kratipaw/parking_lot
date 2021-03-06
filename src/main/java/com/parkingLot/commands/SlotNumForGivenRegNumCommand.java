package com.parkingLot.commands;

import com.parkingLot.ParkingLot;
import com.parkingLot.constants.Messages;
import com.parkingLot.parkingFloor.ParkingSpot;
import com.parkingLot.vehicle.Car;

public class SlotNumForGivenRegNumCommand extends BaseCommand {

    private String registrationNumber = "";

    @Override
    protected boolean isValidCommand(String[] cmdTokens) {
        if(cmdTokens.length != 2)
            return false;

        if(cmdTokens[1] == null || cmdTokens[1].isEmpty())
            return false;

        registrationNumber = cmdTokens[1];

        return true;
    }

    @Override
    protected String executeCommand() {

        int n = ParkingLot.getOccupiedSpotsForCar().size();

        if(n == 0)
            return Messages.PARKING_LOT_EMPTY;

        for(ParkingSpot pSpot : ParkingLot.getOccupiedSpotsForCar().values()){
            Car car = pSpot.getVehicleCar();

            if(car.getRegistrationNumber().equalsIgnoreCase(registrationNumber))
                return String.valueOf(pSpot.getSpotId());
        }

        return Messages.NOT_FOUND;
    }
}
