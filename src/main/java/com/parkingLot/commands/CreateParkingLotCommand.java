package main.java.com.parkingLot.commands;

public class CreateParkingLotCommand extends BaseCommand{
    @Override
    protected boolean isValidCommand(String[] cmdTokens) {

        return cmdTokens.length == 2;
    }

    @Override
    protected String executeCommand() {
        return null;
    }
}
