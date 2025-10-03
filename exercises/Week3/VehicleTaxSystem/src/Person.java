import java.util.ArrayList;
import java.util.List;

public class Person {
    private String licenseNumber;
    private String name;
    private String surname;
    private String address;
    private List<Vehicle> vehicles;

    public Person(String licenseNumber, String name, String surname, String address) {
        this.licenseNumber = licenseNumber;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.vehicles = new ArrayList<>();
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    // --- Vehicle Management ---
    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        v.setOwner(this);
    }

    public void removeVehicle(Vehicle v) {
        vehicles.remove(v);
        v.setOwner(null);
    }

    public double calculateTotalTax() {
        return vehicles.stream().mapToDouble(Vehicle::calculateTax).sum();
    }

    @Override
    public String toString() {
        return name + " " + surname + " (License: " + licenseNumber + ")";
    }
}
