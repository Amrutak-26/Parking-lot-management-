package models;

import enums.VehicleType;

public class ParkingSpot {
    private int spotId;
    private VehicleType type;
    private boolean isAvailable;

    public ParkingSpot(int spotId, VehicleType type) {
        this.spotId = spotId;
        this.type = type;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void occupySpot() {
        isAvailable = false;
    }

    public void freeSpot() {
        isAvailable = true;
    }

    public VehicleType getType() {
        return type;
    }

    public int getSpotId() {
        return spotId;
    }
}
