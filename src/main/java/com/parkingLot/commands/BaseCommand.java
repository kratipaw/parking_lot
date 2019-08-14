package com.parkingLot.commands;

public abstract class BaseCommand {

    protected abstract boolean isValidCommand(String[] cmdTokens);

    protected abstract String executeCommand() throws Exception;

    public String validateAndExecuteCommand(String[] cmdTokens) throws Exception {

        if(isValidCommand(cmdTokens))
            return executeCommand();

        return "";
    }

}
