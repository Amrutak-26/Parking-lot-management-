package services;

public class BikeFeeCalculator implements FeeCalculator {
    @Override
    public double calculateFee(long hours) {
        return hours * 10; // ₹10 per hour
    }
}
