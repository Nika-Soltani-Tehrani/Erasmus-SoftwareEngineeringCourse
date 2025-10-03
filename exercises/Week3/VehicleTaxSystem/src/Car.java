public class Car extends Vehicle {
    private FuelType fuelType;
    private double co2Emissions; // grams of CO2 per km

    public Car(String plateNumber, String maker, String model, FuelType fuelType, double co2Emissions) {
        super(plateNumber, maker, model);
        this.fuelType = fuelType;
        this.co2Emissions = co2Emissions;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public double getCo2Emissions() {
        return co2Emissions;
    }

    public void setCo2Emissions(double co2Emissions) {
        this.co2Emissions = co2Emissions;
    }

    @Override
    public double calculateTax() {
        switch (fuelType) {
            case PETROL:
                return co2Emissions * 1.4;
            case DIESEL:
                return co2Emissions * 1.8;
            case HYBRID:
                return co2Emissions * 1.2;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " [Car, " + fuelType + ", CO2=" + co2Emissions + "]";
    }
}
