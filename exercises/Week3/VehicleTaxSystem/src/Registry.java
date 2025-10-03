import java.util.*;

public class Registry {
    private List<Person> people = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();

    // --- People ---
    public void addPerson(Person p) { people.add(p); }
    public void deletePerson(String license) {
        people.removeIf(p -> p.getLicenseNumber().equalsIgnoreCase(license));
    }
    public Person searchPersonByLicense(String license) {
        for (Person p : people) {
            if (p.getLicenseNumber().equalsIgnoreCase(license)) return p;
        }
        return null;
    }

    // --- Vehicles ---
    public void addVehicle(Vehicle v) { vehicles.add(v); }
    public void deleteVehicle(String plate) {
        Vehicle v = searchVehicleByPlate(plate);
        if (v != null) {
            vehicles.remove(v);
            // also remove from owner, if any
            for (Person p : people) {
                p.getVehicles().remove(v);
            }
        }
    }
    public Vehicle searchVehicleByPlate(String plate) {
        for (Vehicle v : vehicles) {
            if (v.getPlateNumber().equalsIgnoreCase(plate)) return v;
        }
        return null;
    }

    // --- Report ---
    public void generateYearlyTaxReport() {
        System.out.println("\n--- Yearly Tax Report ---");
        for (Person p : people) {
            double total = 0;
            System.out.println("Person: " + p.getName() + " " + p.getSurname()
                    + " (License: " + p.getLicenseNumber() + ")");
            if (p.getVehicles().isEmpty()) {
                System.out.println("  No vehicles.");
            } else {
                for (Vehicle v : p.getVehicles()) {
                    double tax = v.calculateTax();
                    total += tax;
                    System.out.println("  " + v + " | Tax: " + tax + " €");
                }
                System.out.println("  Total tax: " + total + " €\n");
            }
        }
    }
}