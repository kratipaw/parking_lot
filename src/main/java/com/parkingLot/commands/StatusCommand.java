package main.java.com.parkingLot.commands;

import main.java.com.parkingLot.ParkingLot;

public class StatusCommand extends BaseCommand{
    @Override
    protected boolean isValidCommand(String[] cmdTokens) {

        if (cmdTokens.length != 1)
            return false;

        return false;

    }

    @Override
    protected String executeCommand() {

        ParkingLot.printStatusOfParkedCar();
        return "";
    }
}
