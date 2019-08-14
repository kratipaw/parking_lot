package com.parkingLot.commands;

import com.parkingLot.ParkingLot;
import com.parkingLot.constants.Messages;
import com.parkingLot.constants.VehicleType;
import com.parkingLot.vehicle.Car;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegNumForCarsWithGivenColorCommandTest {

    @Test
    public void invalidNumberOfCmdTokens(){
        String[] cmdTokens = new String[1];
        cmdTokens[0] = "command";
        RegNumForCarsWithGivenColorCommand cmd = new RegNumForCarsWithGivenColorCommand();
        boolean result = cmd.isValidCommand(cmdTokens);
        assertFalse(result);
    }

    @Test
    public void  nullOrEmptyColor(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "command";
        cmdTokens[1] = null;

        RegNumForCarsWithGivenColorCommand cmd = new RegNumForCarsWithGivenColorCommand();

        boolean result = cmd.isValidCommand(cmdTokens);
        assertFalse(result);

        cmdTokens[1] = "";
        boolean resultEmpty = cmd.isValidCommand(cmdTokens);
        assertFalse(resultEmpty);
    }

    @Test
    public void validCmdTokens(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "command";
        cmdTokens[1] = "yellow";

        RegNumForCarsWithGivenColorCommand cmd = new RegNumForCarsWithGivenColorCommand();

        boolean result = cmd.isValidCommand(cmdTokens);
        assertTrue(result);
    }

    @Test
    public void executeCommandWhenParkingLotEmpty(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "command";
        cmdTokens[1] = "yellow";
        try {
            ParkingLot.initializeParkingLot(1);
            RegNumForCarsWithGivenColorCommand cmd = new RegNumForCarsWithGivenColorCommand();
            boolean result =  cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            String resultStr = cmd.executeCommand();
            assertEquals(Messages.PARKING_LOT_EMPTY, resultStr);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void validExecute(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "command";
        cmdTokens[1] = "yellow";
        try {
            ParkingLot.initializeParkingLot(1);
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Reg-Num-1", "yellow"));
            RegNumForCarsWithGivenColorCommand cmd = new RegNumForCarsWithGivenColorCommand();
            boolean result =  cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            String resultStr = cmd.executeCommand();
            assertEquals("Reg-Num-1", resultStr);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }
}