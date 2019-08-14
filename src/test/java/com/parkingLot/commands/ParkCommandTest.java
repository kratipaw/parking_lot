package com.parkingLot.commands;

import com.parkingLot.ParkingLot;
import com.parkingLot.constants.Messages;
import com.parkingLot.constants.VehicleType;
import com.parkingLot.vehicle.Car;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkCommandTest {

    @Test
    public void invalidNumberOfCmdTokens(){
        String[] cmdTokens = new String[1];
        cmdTokens[0] = "park";
        ParkCommand cmd = new ParkCommand();
        boolean result = cmd.isValidCommand(cmdTokens);
        assertFalse(result);
    }

    @Test
    public void nullOrEmptyRegistrationNumber(){
        String[] cmdTokens = new String[3];
        cmdTokens[0] = "park";
        cmdTokens[1] = null;
        cmdTokens[2] = "orange";

        ParkCommand cmd = new ParkCommand();

        boolean result = cmd.isValidCommand(cmdTokens);
        assertFalse(result);

        cmdTokens[1] = "";
        boolean resultEmpty = cmd.isValidCommand(cmdTokens);
        assertFalse(resultEmpty);
    }

    @Test
    public void  nullOrEmptyColor(){
        String[] cmdTokens = new String[3];
        cmdTokens[0] = "park";
        cmdTokens[1] = "Reg-Num-1";
        cmdTokens[2] = null;

        ParkCommand cmd = new ParkCommand();

        boolean result = cmd.isValidCommand(cmdTokens);
        assertFalse(result);

        cmdTokens[2] = "";
        boolean resultEmpty = cmd.isValidCommand(cmdTokens);
        assertFalse(resultEmpty);
    }

    @Test
    public void validCmdTokens(){
        String[] cmdTokens = new String[3];
        cmdTokens[0] = "park";
        cmdTokens[1] = "Reg-Num-1";
        cmdTokens[2] = "orange";

        ParkCommand cmd = new ParkCommand();

        boolean result = cmd.isValidCommand(cmdTokens);
        assertTrue(result);
    }

    @Test
    public void validExecute(){
        String[] cmdTokens = new String[3];
        cmdTokens[0] = "park";
        cmdTokens[1] = "Reg-Num-1";
        cmdTokens[2] = "orange";
        try {
            ParkingLot.initializeParkingLot(1);
            ParkCommand cmd = new ParkCommand();
            boolean result =  cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            String resultStr = cmd.executeCommand();
            assertEquals(Messages.CAR_PARK + 1, resultStr);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }

}