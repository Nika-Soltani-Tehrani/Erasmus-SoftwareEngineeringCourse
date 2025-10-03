public class PetrolCar extends Car {
    public PetrolCar(String plateNumber, String maker, String model, double co2Emissions) {
        super(plateNumber, maker, model, co2Emissions);
    }

    @Override
    public double calculateTax() {
        return getCo2Emissions() * 1.4;
    }

    @Override
    public String toString() {
        return super.toString() + " [PetrolCar, CO2=" + getCo2Emissions() + "]";
    }
}
