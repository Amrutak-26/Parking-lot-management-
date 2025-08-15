package services;

import java.util.ArrayList;
import java.util.List;

import enums.VehicleType;
import models.ParkingSpot;

public class ParkingLot {
    private static ParkingLot instance;
    private List<ParkingSpot> spots;

    private ParkingLot() {
        spots = new ArrayList<>();
    }

    public static ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addSpot(ParkingSpot spot) {
        spots.add(spot);
    }

    public ParkingSpot getAvailableSpot(VehicleType type) {
        for (ParkingSpot spot : spots) {
            if (spot.isAvailable() && spot.getType() == type) {
                return spot;
            }
        }
        return null;
    }
}
