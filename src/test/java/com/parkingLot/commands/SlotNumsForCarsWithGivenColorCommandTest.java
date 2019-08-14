package com.parkingLot.commands;

import com.parkingLot.ParkingLot;
import com.parkingLot.constants.Messages;
import com.parkingLot.constants.VehicleType;
import com.parkingLot.vehicle.Car;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SlotNumsForCarsWithGivenColorCommandTest {

    @Test
    public void invalidNumberOfCmdTokens(){
        String[] cmdTokens = new String[1];
        cmdTokens[0] = "command";
        SlotNumsForCarsWithGivenColorCommand cmd = new SlotNumsForCarsWithGivenColorCommand();
        boolean result = cmd.isValidCommand(cmdTokens);
        assertFalse(result);
    }

    @Test
    public void  nullOrEmptyColor(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "command";
        cmdTokens[1] = null;

        SlotNumsForCarsWithGivenColorCommand cmd = new SlotNumsForCarsWithGivenColorCommand();

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
        cmdTokens[1] = "grey";

        SlotNumsForCarsWithGivenColorCommand cmd = new SlotNumsForCarsWithGivenColorCommand();

        boolean result = cmd.isValidCommand(cmdTokens);
        assertTrue(result);
    }

    @Test
    public void executeCommandWhenParkingLotEmpty(){
        String[] cmdTokens = new String[2];
        cmdTokens[0] = "command";
        cmdTokens[1] = "grey";
        try {
            ParkingLot.initializeParkingLot(1);
            SlotNumsForCarsWithGivenColorCommand cmd = new SlotNumsForCarsWithGivenColorCommand();
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
        cmdTokens[1] = "grey";
        try {
            ParkingLot.initializeParkingLot(5);
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Reg-Num-1", "grey"));
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Reg-Num-2", "pink"));
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Reg-Num-3", "grey"));
            SlotNumsForCarsWithGivenColorCommand cmd = new SlotNumsForCarsWithGivenColorCommand();
            boolean result =  cmd.isValidCommand(cmdTokens);
            assertTrue(result);
            String resultStr = cmd.executeCommand();
            assertEquals("1, 3", resultStr);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }
}