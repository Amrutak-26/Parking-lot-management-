import enums.VehicleType;
import models.*;
import services.*;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = ParkingLot.getInstance();

        // Add parking spots
        lot.addSpot(new ParkingSpot(1, VehicleType.CAR));
        lot.addSpot(new ParkingSpot(2, VehicleType.BIKE));
        lot.addSpot(new ParkingSpot(3, VehicleType.BUS));

        ParkingLotManager manager = new ParkingLotManager();

        // Park a car
        Vehicle car = new Car("MH12AB1234");
        Ticket ticket = manager.parkVehicle(car);

        // Simulate some time passing (for testing fee calculation)
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        // Unpark the vehicle
        if (ticket != null) {
            manager.unparkVehicle(ticket.getTicketId());
        }
    }
}
