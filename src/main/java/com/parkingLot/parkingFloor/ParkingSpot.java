package main.java.com.parkingLot.parkingFloor;

public class ParkingSpot {

    private int spotId;

    private boolean free;

    public ParkingSpot(int spotId, boolean free){
        this.spotId = spotId;
        this.free = free;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public int getSpotId() {
        return spotId;
    }
}
