package com.parkingLot.input;

import com.parkingLot.commands.BaseCommand;
import com.parkingLot.commands.CommandFactory;
import com.parkingLot.exceptions.InvalidCommand;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class BaseInputProcessor {

    private BufferedReader inputReader;

    BaseInputProcessor(BufferedReader inputReader) {
        super();
        this.inputReader = inputReader;
    }

    BufferedReader getInputReader() {
        return inputReader;
    }

    private boolean isValid(String line) {
        return line != null && !line.isEmpty();
    }

    void processInputLine(String line) throws Exception {

        if (!isValid(line)) {
            throw new InvalidCommand("Invalid Command line !!");
        }

        String[] cmdTokens = line.split("\\s+");
        BaseCommand cmd = CommandFactory.generateCommand(cmdTokens);
        System.out.println(cmd.validateAndExecuteCommand(cmdTokens));

    }

    public abstract void readInputAndProcess() throws Exception;

}
