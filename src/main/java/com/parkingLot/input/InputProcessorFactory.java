package com.parkingLot.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class InputProcessorFactory {

    public static BaseInputProcessor getInputProcessor(File inputFile) throws Exception {

        BaseInputProcessor inputType;

        BufferedReader br;

        if(inputFile != null) {
            br = new BufferedReader(new FileReader(inputFile));
            inputType = new FileInputProcessor(br);
        }

        else {
            br = new BufferedReader(new InputStreamReader(System.in));
            inputType = new CommandLineInputProcessor(br);
        }

        return inputType;
    }
}
