package main.java.com.parkingLot;

import main.java.com.parkingLot.parkingFloor.NearestFromEntryComparator;
import main.java.com.parkingLot.parkingFloor.ParkingSpot;

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

    private static ParkingLot getParkingLotInstance() throws Exception {

        if (parkingLotInstance == null) {
            throw new Exception("Please initialize the parking lot first.");
        }
        return parkingLotInstance;
    }

    private static void initializeParkingLot(int capacity) throws Exception {

        if (parkingLotInstance == null)
            parkingLotInstance = new ParkingLot(capacity);

        else
            throw new Exception("Parking Lot is already initialized.");
    }

    public static void destroy() {
        if (parkingLotInstance != null)
            parkingLotInstance = null;
    }
}
