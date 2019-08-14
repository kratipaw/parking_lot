package com.parkingLot;

import com.parkingLot.input.BaseInputProcessor;
import com.parkingLot.input.InputProcessorFactory;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws Exception {

        File inputFile = null;

        if(args != null && args.length > 0) {
            String fileName = args[0];
            if (fileName == null || fileName.isEmpty()) {
                throw new Exception("Invalid input file name.");
            }

            inputFile = new File(fileName);
            if (!inputFile.exists()) {
                throw new FileNotFoundException();
            }
        }

        BaseInputProcessor input = InputProcessorFactory.getInputProcessor(inputFile);

        input.readInputAndProcess();
    }

}
