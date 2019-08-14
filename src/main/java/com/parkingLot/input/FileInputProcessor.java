package com.parkingLot.input;

import java.io.BufferedReader;
import java.io.IOException;

public class FileInputProcessor extends BaseInputProcessor {

    FileInputProcessor(BufferedReader inputReader) {
        super(inputReader);
    }

    @Override
    public void readInputAndProcess() throws Exception{
        String line;
        while ((line = this.getInputReader().readLine()) != null) {
            processInputLine(line);
        }
    }
}
