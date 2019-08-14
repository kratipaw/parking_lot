package com.parkingLot.commands;

import com.parkingLot.ParkingLot;

public class LeaveCommand extends BaseCommand{

    private int spotId = -1;

    @Override
    protected boolean isValidCommand(String[] cmdTokens) {

        if (cmdTokens.length != 2)
            return false;

        if(cmdTokens[1] == null || cmdTokens[1].isEmpty())
            return false;

        spotId = Integer.parseInt(cmdTokens[1]);

        return spotId >= 1;
    }

    @Override
    protected String executeCommand() {
        return ParkingLot.leaveCarFromGivenSpotId(spotId);
    }
}
