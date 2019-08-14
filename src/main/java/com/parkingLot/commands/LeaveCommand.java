package com.parkingLot.commands;

import com.parkingLot.ParkingLot;

public class LeaveCommand extends BaseCommand{

    private int spotId = -1;

    @Override
    protected boolean isValidCommand(String[] cmdTokens) {

        if(cmdTokens.length == 2){
            spotId = Integer.parseInt(cmdTokens[1]);
            return true;
        }

        return false;
    }

    @Override
    protected String executeCommand() {
        return ParkingLot.leaveCarFromGivenSpotId(spotId);
    }
}
