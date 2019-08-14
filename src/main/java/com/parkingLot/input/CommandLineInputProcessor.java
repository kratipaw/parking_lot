package com.parkingLot.input;

import java.io.BufferedReader;
import java.io.IOException;

public class CommandLineInputProcessor extends BaseInputProcessor{

    CommandLineInputProcessor(BufferedReader inputReader) {
        super(inputReader);
    }

    @Override
    public void readInputAndProcess() throws Exception {
        while (true) {
            String inputString = this.getInputReader().readLine();
            System.out.println(inputString);
            processInputLine(inputString);
        }
    }

}
