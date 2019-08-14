package com.parkingLot.input;

import java.io.BufferedReader;

public class CommandLineInputProcessor extends BaseInputProcessor{

    CommandLineInputProcessor(BufferedReader inputReader) {
        super(inputReader);
    }

    @Override
    public void readInputAndProcess() throws Exception {
        while (true) {
            String inputString = this.getInputReader().readLine();
            processInputLine(inputString);
        }
    }

}
