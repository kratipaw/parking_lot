package main.java.com.parkingLot.commands;

public abstract class BaseCommand {

    protected abstract boolean isValidCommand(String[] cmdTokens);

    protected abstract String executeCommand();

    public String validateAndExecuteCommand(String[] cmdTokens){

        if(isValidCommand(cmdTokens))
            executeCommand();

        return "";
    }

}
