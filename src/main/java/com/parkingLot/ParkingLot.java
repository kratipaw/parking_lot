package main.java.com.parkingLot;

import main.java.com.parkingLot.constants.Messages;
import main.java.com.parkingLot.parkingFloor.NearestFromEntryComparator;
import main.java.com.parkingLot.parkingFloor.ParkingSpot;
import main.java.com.parkingLot.vehicle.Car;
import main.java.com.parkingLot.vehicle.Vehicle;

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

    public static String initializeParkingLot(int capacity) throws Exception {

        if (parkingLotInstance == null) {
            parkingLotInstance = new ParkingLot(capacity);
            return Messages.PARKING_LOT_INITIATED + capacity + " slots.";
        }
        else
            throw new Exception("Parking Lot is already initialized.");

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

    public static void printStatusOfParkedCar(){

        System.out.println(Messages.PRINT_STATUS);
        for(ParkingSpot pSpot : occupiedSpotsForCar.values()){
            System.out.println(pSpot.toString());
        }
    }

    public static void destroyParkingLotInstance() {
        if (parkingLotInstance != null)
            parkingLotInstance = null;
    }
}
