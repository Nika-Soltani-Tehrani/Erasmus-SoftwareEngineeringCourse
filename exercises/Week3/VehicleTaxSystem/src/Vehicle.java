public abstract class Vehicle implements Tax {
    private String plateNumber;
    private String maker;
    private String model;
    private Person owner;

    public Vehicle(String plateNumber, String maker, String model) {
        this.plateNumber = plateNumber;
        this.maker = maker;
        this.model = model;
        this.owner = null;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return plateNumber + " (" + maker + " " + model + ")";
    }
}
