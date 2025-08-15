package services;

public class CarFeeCalculator implements FeeCalculator {
    @Override
    public double calculateFee(long hours) {
        return hours * 20; // ₹20 per hour
    }
}
