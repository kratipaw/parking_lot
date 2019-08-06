package main.java.com.parkingLot.parkingFloor;

import java.util.Comparator;

public class NearestFromEntryComparator implements Comparator<ParkingSpot> {

    @Override
    public int compare(ParkingSpot o1, ParkingSpot o2) {
        if(o1.getSpotId() > o2.getSpotId())
            return 1;

        else if(o1.getSpotId() < o2.getSpotId())
            return -1;

        return 0;
    }
}
