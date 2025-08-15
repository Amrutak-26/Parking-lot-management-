package services;

public class BusFeeCalculator implements FeeCalculator {
    @Override
    public double calculateFee(long hours) {
        return hours * 50; // ₹50 per hour
    }
}
