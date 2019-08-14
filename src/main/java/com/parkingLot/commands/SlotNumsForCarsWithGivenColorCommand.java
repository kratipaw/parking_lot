package com.parkingLot.commands;

import com.parkingLot.commands.BaseCommand;
import com.parkingLot.ParkingLot;
import com.parkingLot.constants.Messages;
import com.parkingLot.parkingFloor.ParkingSpot;
import com.parkingLot.vehicle.Car;

public class SlotNumsForCarsWithGivenColorCommand extends BaseCommand {

    private String color = "";

    @Override
    protected boolean isValidCommand(String[] cmdTokens) {
        if(cmdTokens.length == 2){
            color = cmdTokens[1];
            return true;
        }

        return false;
    }

    @Override
    protected String executeCommand() {

        int numberOfOccupiedSpots = ParkingLot.getOccupiedSpotsForCar().size();

        if(numberOfOccupiedSpots == 0)
            return Messages.PARKING_LOT_EMPTY;

        StringBuilder slotIdsWithGivenColor = new StringBuilder();

        for(ParkingSpot pSpot : ParkingLot.getOccupiedSpotsForCar().values()){
            Car car = pSpot.getVehicleCar();

            if(car.getColor().equalsIgnoreCase(color))
                slotIdsWithGivenColor.append(pSpot.getSpotId()).append(", ");
        }

        int resultLength = slotIdsWithGivenColor.length();

        return slotIdsWithGivenColor.substring(0, resultLength - 2);
    }
}
