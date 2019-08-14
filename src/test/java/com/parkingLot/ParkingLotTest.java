package com.parkingLot;

import com.parkingLot.constants.Messages;
import com.parkingLot.constants.VehicleType;
import com.parkingLot.vehicle.Car;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void getParkingLotInstanceBeforeInitializingIt(){
        try {
            ParkingLot parkingLotInstance = ParkingLot.getParkingLotInstance();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Please initialize the parking lot first.");
        }
    }

    @Test
    public void getParkingLotInstanceAfterInitializingIt(){
        try {
            String message = ParkingLot.initializeParkingLot(3);
            ParkingLot parkingLotInstance = ParkingLot.getParkingLotInstance();
            assertNotNull(parkingLotInstance);
            assertEquals(message, Messages.PARKING_LOT_INITIATED + "3 slots.");
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void getParkingLotAfterMultipleInitialization(){
        try {
            ParkingLot.initializeParkingLot(5);
            ParkingLot.initializeParkingLot(10);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Parking Lot is already initialized.");
        }
    }

    @Test
    public void parkCarWhenParkingLotIsFull(){

        try {
            ParkingLot.initializeParkingLot(1);
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Test-Reg-Num-1", "white"));
            String result = ParkingLot.parkCar(new Car(VehicleType.CAR, "Test-Reg-Num-2", "red"));
            assertEquals(Messages.PARKING_LOT_FULL, result);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void parkCarSuccessfully(){

        try {
            ParkingLot.initializeParkingLot(1);
            String result = ParkingLot.parkCar(new Car(VehicleType.CAR, "Test-Reg-Num-1", "white"));
            assertEquals(Messages.CAR_PARK + 1, result);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void leaveCarFromGivenEmptySpotId(){

        try {
            ParkingLot.initializeParkingLot(2);
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Test-Reg-Num-1", "white"));
            String result = ParkingLot.leaveCarFromGivenSpotId(2);
            assertEquals(Messages.PARKING_SPOT_EMPTY, result);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void leaveCarFromGivenInvalidSpotId(){
        try {
            ParkingLot.initializeParkingLot(1);
            String result = ParkingLot.leaveCarFromGivenSpotId(2);
            assertEquals(Messages.PARKING_SPOT_EMPTY, result);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void leaveCarFromGivenSpotIdSuccessfully(){
        try {
            ParkingLot.initializeParkingLot(2);
            ParkingLot.parkCar(new Car(VehicleType.CAR, "Test-Reg-Num-1", "white"));
            String result = ParkingLot.leaveCarFromGivenSpotId(1);
            assertEquals(Messages.PARKING_SPOT + 1 + " is free", result);
            ParkingLot.destroyParkingLotInstance();
        } catch (Exception e) {
            fail();
        }
    }
}