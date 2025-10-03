public class DieselCar extends Car {
    public DieselCar(String plateNumber, String maker, String model, double co2Emissions) {
        super(plateNumber, maker, model, co2Emissions);
    }

    @Override
    public double calculateTax() {
        return getCo2Emissions() * 1.8;
    }

    @Override
    public String toString() {
        return super.toString() + " [DieselCar, CO2=" + getCo2Emissions() + "]";
    }
}
