package main.java.com.parkingLot.parkingFloor;

import main.java.com.parkingLot.vehicle.Vehicle;

public class ParkingSpot {

    private int spotId;

    private boolean free;

    private Vehicle vehicle;

    public ParkingSpot(int spotId, boolean free){
        this.spotId = spotId;
        this.free = free;
        this.vehicle = null;
    }

    public boolean isFree() {
        return free;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.free = false;
    }

    public void removeVehicle(){
        this.vehicle = null;
        this.free = true;
    }

    public int getSpotId() {
        return spotId;
    }
}
