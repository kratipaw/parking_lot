package com.parkingLot.commands;

import com.parkingLot.ParkingLot;
import com.parkingLot.constants.Messages;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateParkingLotCommandTest {

    @Test
    public void invalidNumberOfCmdTokens(){
        String[] cmdTokens = new String[1];

        boolean result = new CreateParkingLotCommand().isValidCommand(cmdTokens);

        assertFalse(result);
    }

    @Test
    public void invalidCapacity(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "create_parking_lot";
        cmdTokens[1] = String.valueOf(-1);

        boolean result = new CreateParkingLotCommand().isValidCommand(cmdTokens);

        assertFalse(result);
    }

    @Test
    public void validCmdToken(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "create_parking_lot";
        cmdTokens[1] = String.valueOf(2);

        boolean result = new CreateParkingLotCommand().isValidCommand(cmdTokens);

        assertTrue(result);
    }

    @Test
    public void invalidExecute(){
        try {
            String[] cmdTokens = new String[2];
            cmdTokens[0] = "create_parking_lot";
            cmdTokens[1] = String.valueOf(2);

            CreateParkingLotCommand cmd = new CreateParkingLotCommand();
            boolean result = cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            cmd.executeCommand();
            cmd.executeCommand();
        } catch (Exception e) {
            assertEquals(Messages.PARKING_LOT_ALREADY_INITIALIZED, e.getMessage());
            ParkingLot.destroyParkingLotInstance();
        }
    }

    @Test
    public void validExecute(){
        try {
            String[] cmdTokens = new String[2];
            cmdTokens[0] = "create_parking_lot";
            cmdTokens[1] = String.valueOf(2);

            CreateParkingLotCommand cmd = new CreateParkingLotCommand();
            boolean result = cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            String resultStr = cmd.executeCommand();
            assertEquals(Messages.PARKING_LOT_INITIATED + 2 + " slots.", resultStr);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }
}