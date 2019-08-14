package com.parkingLot;

import com.parkingLot.constants.Messages;
import com.parkingLot.parkingFloor.NearestFromEntryComparator;
import com.parkingLot.parkingFloor.ParkingSpot;
import com.parkingLot.vehicle.Car;
import com.parkingLot.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Parking Lot class : Singleton class to initiate the parking lot and handle application state.
 * <p>
 * Note : This class is not thread-safe.
 */
public class ParkingLot {

    private static int maxCapacity = 0;

    private static ParkingLot parkingLotInstance = null;

    private static Map<Integer, ParkingSpot> occupiedSpotsForCar = null;

    private static TreeSet<ParkingSpot> unoccupiedSpotsForCar = null;

    private ParkingLot(int capacity) {
        maxCapacity = capacity;
        occupiedSpotsForCar = new HashMap<>();
        unoccupiedSpotsForCar = new TreeSet<>(new NearestFromEntryComparator());

        for (int i = 1; i <= maxCapacity; i++) {
            unoccupiedSpotsForCar.add(new ParkingSpot(i, true));
        }
    }

    static ParkingLot getParkingLotInstance() throws Exception {

        if (parkingLotInstance == null) {
            throw new Exception(Messages.PARKING_LOT_NOT_INITIALIZED);
        }
        return parkingLotInstance;
    }

    public static String initializeParkingLot(int capacity) throws Exception {

        if (parkingLotInstance == null) {
            parkingLotInstance = new ParkingLot(capacity);
            return Messages.PARKING_LOT_INITIATED + capacity + " slots.";
        }
        else
            throw new Exception(Messages.PARKING_LOT_ALREADY_INITIALIZED);

    }

    public static String parkCar(Vehicle car){

        if(unoccupiedSpotsForCar.isEmpty())
            return Messages.PARKING_LOT_FULL;

        ParkingSpot pSpot = unoccupiedSpotsForCar.first();
        unoccupiedSpotsForCar.remove(pSpot);
        pSpot.assignVehicle(car);
        occupiedSpotsForCar.put(pSpot.getSpotId(), pSpot);

        return Messages.CAR_PARK + pSpot.getSpotId();
    }

    public static Map<Integer, ParkingSpot> getOccupiedSpotsForCar() {
        return occupiedSpotsForCar;
    }

    public static String leaveCarFromGivenSpotId(int spotId){

        if(spotId > maxCapacity)
            return Messages.NOT_FOUND;

        if(!occupiedSpotsForCar.containsKey(spotId))
            return Messages.PARKING_SPOT_EMPTY;

        ParkingSpot parkingSpot = occupiedSpotsForCar.get(spotId);
        parkingSpot.removeVehicle();
        occupiedSpotsForCar.remove(spotId);
        unoccupiedSpotsForCar.add(parkingSpot);
        return Messages.PARKING_SPOT + spotId + " is free";
    }

    public static void destroyParkingLotInstance() {
        if (parkingLotInstance != null)
            parkingLotInstance = null;
    }
}
