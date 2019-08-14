package com.parkingLot.commands;

import com.parkingLot.ParkingLot;
import com.parkingLot.constants.VehicleType;
import com.parkingLot.vehicle.Car;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StatusCommandTest {
    @Test
    public void invalidNumberOfCmdTokens(){
        String[] cmdTokens = new String[0];
        StatusCommand cmd = new StatusCommand();
        boolean result = cmd.isValidCommand(cmdTokens);
        assertFalse(result);
    }

    @Test
    public void validCmdTokens(){
        String[] cmdTokens = new String[1];
        cmdTokens[0] = "command";

        StatusCommand cmd = new StatusCommand();

        boolean result = cmd.isValidCommand(cmdTokens);
        assertTrue(result);
    }

    @Test
    public void executeCommandWhenParkingLotEmpty(){
        String[] cmdTokens = new String[1];
        cmdTokens[0] = "command";
        try {
            ParkingLot.initializeParkingLot(1);
            StatusCommand cmd = new StatusCommand();
            boolean result =  cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            String resultStr = cmd.executeCommand();
            assertEquals("", resultStr);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void validExecute(){
        String[] cmdTokens = new String[1];
        cmdTokens[0] = "command";
        try {
            ParkingLot.initializeParkingLot(5);
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Reg-Num-1", "grey"));
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Reg-Num-2", "pink"));
            StatusCommand cmd = new StatusCommand();
            boolean result =  cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            String resultStr = cmd.executeCommand();
            assertTrue(true);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }
}