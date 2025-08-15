package services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import enums.VehicleType;
import models.*;

public class ParkingLotManager {
    private Map<String, Ticket> activeTickets = new HashMap<>();
    private ParkingLot parkingLot = ParkingLot.getInstance();

    public Ticket parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = parkingLot.getAvailableSpot(vehicle.getType());
        if (spot == null) {
            System.out.println("No available spot for " + vehicle.getType());
            return null;
        }
        spot.occupySpot();
        String ticketId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, vehicle);
        activeTickets.put(ticketId, ticket);
        System.out.println("Vehicle parked. Ticket ID: " + ticketId);
        return ticket;
    }

    public void unparkVehicle(String ticketId) {
        Ticket ticket = activeTickets.get(ticketId);
        if (ticket == null) {
            System.out.println("Invalid ticket ID");
            return;
        }
        ticket.setExitTime(LocalDateTime.now());
        long hours = Duration.between(ticket.getEntryTime(), ticket.getExitTime()).toHours();
        if (hours == 0) hours = 1;

        FeeCalculator calculator;
        if (ticket.getVehicle().getType() == VehicleType.CAR) {
            calculator = new CarFeeCalculator();
        } else if (ticket.getVehicle().getType() == VehicleType.BIKE) {
            calculator = new BikeFeeCalculator();
        } else {
            calculator = new BusFeeCalculator();
        }

        double fee = calculator.calculateFee(hours);
        ticket.setFee(fee);

        System.out.println("Vehicle with plate " + ticket.getVehicle().getLicensePlate() +
                           " unparked. Fee: ₹" + fee);

        activeTickets.remove(ticketId);
    }
}
