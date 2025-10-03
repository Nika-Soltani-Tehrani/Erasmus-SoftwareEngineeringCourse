public class Motorcycle extends Vehicle {
    private double engineDisplacement; // in cc

    public Motorcycle(String plateNumber, String maker, String model, double engineDisplacement) {
        super(plateNumber, maker, model);
        this.engineDisplacement = engineDisplacement;
    }

    public double getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(double engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    @Override
    public double calculateTax() {
        return engineDisplacement * 0.10; // 10% of displacement
    }

    @Override
    public String toString() {
        return super.toString() + " [Motorcycle, " + engineDisplacement + "cc]";
    }
}
