package main.java.com.parkingLot.commands;

import main.java.com.parkingLot.ParkingLot;

public class CreateParkingLotCommand extends BaseCommand{

    private int parkingLotCapacity = 0;

    @Override
    protected boolean isValidCommand(String[] cmdTokens) {

        if(cmdTokens.length != 2)
            return false;

        parkingLotCapacity = Integer.parseInt(cmdTokens[1]);

        return true;
    }

    @Override
    protected String executeCommand() throws Exception {

        return ParkingLot.initializeParkingLot(parkingLotCapacity);
    }
}
