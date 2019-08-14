package com.parkingLot;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    public void invalidFileName() {

        try {
            String[] args = new String[1];
            args[0] = null;
            Main.main(args);
        }
        catch(Exception ex) {
            assertEquals(ex.getMessage(), "Invalid input file name.");
        }
    }

    @Test
    public void unavailableFile() {
        try {
            String[] args = new String[1];
            args[0] = "unavailableFile.txt";
            Main.main(args);
        }
        catch(Exception ex) {
            assertEquals(ex.getClass(), FileNotFoundException.class);
        }
    }

}