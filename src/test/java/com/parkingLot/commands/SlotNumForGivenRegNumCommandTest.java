package com.parkingLot.commands;

import com.parkingLot.ParkingLot;
import com.parkingLot.constants.Messages;
import com.parkingLot.constants.VehicleType;
import com.parkingLot.vehicle.Car;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SlotNumForGivenRegNumCommandTest {

    @Test
    public void invalidNumberOfCmdTokens(){
        String[] cmdTokens = new String[1];
        cmdTokens[0] = "command";
        SlotNumForGivenRegNumCommand cmd = new SlotNumForGivenRegNumCommand();
        boolean result = cmd.isValidCommand(cmdTokens);
        assertFalse(result);
    }

    @Test
    public void  nullOrEmptyRegNum(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "command";
        cmdTokens[1] = null;

        SlotNumForGivenRegNumCommand cmd = new SlotNumForGivenRegNumCommand();

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
        cmdTokens[1] = "Reg-Num-1";

        SlotNumForGivenRegNumCommand cmd = new SlotNumForGivenRegNumCommand();

        boolean result = cmd.isValidCommand(cmdTokens);
        assertTrue(result);
    }

    @Test
    public void executeCommandWhenParkingLotEmpty(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "command";
        cmdTokens[1] = "Reg-Num-1";
        try {
            ParkingLot.initializeParkingLot(1);
            SlotNumForGivenRegNumCommand cmd = new SlotNumForGivenRegNumCommand();
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
    public void executeCommandWhenRegNumNotFound(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "command";
        cmdTokens[1] = "Reg-Num-2";
        try {
            ParkingLot.initializeParkingLot(1);
            SlotNumForGivenRegNumCommand cmd = new SlotNumForGivenRegNumCommand();
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Reg-Num-1", "black"));
            boolean result =  cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            String resultStr = cmd.executeCommand();
            assertEquals(Messages.NOT_FOUND, resultStr);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void validExecute(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "command";
        cmdTokens[1] = "Reg-Num-1";
        try {
            ParkingLot.initializeParkingLot(1);
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Reg-Num-1", "yellow"));
            SlotNumForGivenRegNumCommand cmd = new SlotNumForGivenRegNumCommand();
            boolean result =  cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            String resultStr = cmd.executeCommand();
            assertEquals("1", resultStr);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }

}