package main.java.com.parkingLot.commands;

public class ParkCommand extends BaseCommand{

    @Override
    protected boolean isValidCommand(String[] cmdTokens) {
        return false;
    }

    @Override
    protected String executeCommand() {
        return null;
    }
}
