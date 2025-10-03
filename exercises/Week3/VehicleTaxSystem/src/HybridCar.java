public class HybridCar extends Car {
    public HybridCar(String plateNumber, String maker, String model, double co2Emissions) {
        super(plateNumber, maker, model, co2Emissions);
    }

    @Override
    public double calculateTax() {
        return getCo2Emissions() * 1.2;
    }

    @Override
    public String toString() {
        return super.toString() + " [HybridCar, CO2=" + getCo2Emissions() + "]";
    }
}
