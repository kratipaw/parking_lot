package com.parkingLot.commands;

import com.parkingLot.ParkingLot;
import com.parkingLot.constants.Messages;
import com.parkingLot.constants.VehicleType;
import com.parkingLot.vehicle.Car;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LeaveCommandTest {

    @Test
    public void invalidNumberOfCmdTokens(){
        String[] cmdTokens = new String[1];
        cmdTokens[0] = "leave";
        LeaveCommand cmd = new LeaveCommand();
        boolean result = cmd.isValidCommand(cmdTokens);
        assertFalse(result);
    }

    @Test
    public void nullSpotId(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "leave";
        cmdTokens[1] = null;
        LeaveCommand cmd = new LeaveCommand();
        boolean result = cmd.isValidCommand(cmdTokens);
        assertFalse(result);
    }

    @Test
    public void  invalidOrNegativeSpotId(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "leave";
        cmdTokens[1] = "-1";
        LeaveCommand cmd = new LeaveCommand();
        boolean result = cmd.isValidCommand(cmdTokens);
        assertFalse(result);
        cmdTokens[1] = "0";
        boolean resultZeroSpotId = cmd.isValidCommand(cmdTokens);
        assertFalse(resultZeroSpotId);
    }

    @Test
    public void validCmdTokens(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "leave";
        cmdTokens[1] = "1";
        try {
            LeaveCommand cmd = new LeaveCommand();
            boolean result =  cmd.isValidCommand(cmdTokens);
            assertTrue(result);
        } catch (Exception e) {
            fail();
        }

    }

    @Test
    public void invalidExecute(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "leave";
        cmdTokens[1] = "2";
        try {
            ParkingLot.initializeParkingLot(2);
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Reg-Num-1", "blue"));
            LeaveCommand cmd = new LeaveCommand();
            boolean result =  cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            String resultStr = cmd.executeCommand();
            assertEquals(Messages.PARKING_SPOT_EMPTY , resultStr);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void validExecute(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "leave";
        cmdTokens[1] = "1";
        try {
            ParkingLot.initializeParkingLot(1);
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Reg-Num-1", "blue"));
            LeaveCommand cmd = new LeaveCommand();
            boolean result =  cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            String resultStr = cmd.executeCommand();
            assertEquals(Messages.PARKING_SPOT + "1 is free", resultStr);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }
}