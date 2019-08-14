package com.parkingLot.commands;

import com.parkingLot.commands.BaseCommand;
import com.parkingLot.ParkingLot;
import com.parkingLot.constants.Messages;
import com.parkingLot.parkingFloor.ParkingSpot;

public class StatusCommand extends BaseCommand {
    @Override
    protected boolean isValidCommand(String[] cmdTokens) {

        return cmdTokens.length == 1;

    }

    @Override
    protected String executeCommand() {

        System.out.println(Messages.PRINT_STATUS);
        for(ParkingSpot pSpot : ParkingLot.getOccupiedSpotsForCar().values()){
            System.out.println(pSpot.toString());
        }

        return "";
    }
}
