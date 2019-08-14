package com.parkingLot.commands;

import com.parkingLot.ParkingLot;

public class CreateParkingLotCommand extends BaseCommand{

    private int parkingLotCapacity = 0;

    @Override
    protected boolean isValidCommand(String[] cmdTokens) {

        if(cmdTokens.length != 2)
            return false;

        if(Integer.parseInt(cmdTokens[1]) <= 0)
            return false;

        parkingLotCapacity = Integer.parseInt(cmdTokens[1]);

        return true;
    }

    @Override
    protected String executeCommand() throws Exception {

        return ParkingLot.initializeParkingLot(parkingLotCapacity);
    }
}
