import java.util.*;

public class Main {
    private static final String ADMIN_PASSWORD = "admin123"; // simple password
    private static Registry registry = new Registry();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== City Vehicle Tax System ===");
            System.out.print("Are you admin? (yes/no/exit): ");
            String role = scanner.nextLine().trim().toLowerCase();

            if (role.equals("exit")) {
                System.out.println("Goodbye!");
                break;
            } else if (role.equals("yes")) {
                adminLogin();
            } else if (role.equals("no")) {
                userLogin();
            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    private static void adminLogin() {
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();
        if (password.equals(ADMIN_PASSWORD)) {
            System.out.println("Welcome, Admin!");
            adminMenu();
        } else {
            System.out.println("Wrong password. Try again.");
        }
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\n--- Admin Menu ---");
            System.out.println("1. Vehicle Services");
            System.out.println("2. People Services");
            System.out.println("3. Search Vehicle by Plate");
            System.out.println("4. Search Person by License");
            System.out.println("5. Generate Yearly Tax Report");
            System.out.println("6. Back");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> vehicleServices();
                case 2 -> peopleServices();
                case 3 -> {
                    System.out.print("Enter plate number: ");
                    String plate = scanner.nextLine();
                    Vehicle v = registry.searchVehicleByPlate(plate);
                    if (v != null) {
                        System.out.println("Vehicle found: " + v + " | Tax: " + v.calculateTax());
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                }
                case 4 -> {
                    System.out.print("Enter license number: ");
                    String license = scanner.nextLine();
                    Person p = registry.searchPersonByLicense(license);
                    if (p != null) {
                        System.out.println("Person found: " + p);
                        double total = p.calculateTotalTax();
                        for (Vehicle v : p.getVehicles()) {
                            System.out.println(" - " + v + " | Tax: " + v.calculateTax());
                        }
                        System.out.println("Total tax: " + total + " €");
                    } else {
                        System.out.println("Person not found.");
                    }
                }
                case 5 -> registry.generateYearlyTaxReport();
                case 6 -> { return; }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void userLogin() {
        System.out.print("Enter your license number: ");
        String license = scanner.nextLine().trim();
        Person person = registry.searchPersonByLicense(license);

        if (person == null) {
            System.out.println("No record found. Let's create a new user.");
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();
            System.out.print("Enter your surname: ");
            String surname = scanner.nextLine();
            System.out.print("Enter your address: ");
            String address = scanner.nextLine();
            person = new Person(license, name, surname, address);
            registry.addPerson(person);
            System.out.println("User created successfully!");
        } else {
            System.out.println("Welcome back, " + person.getName() + "!");
        }
        userMenu(person);
    }

    private static void userMenu(Person person) {
        while (true) {
            System.out.println("\n--- User Menu (" + person.getName() + ") ---");
            System.out.println("1. Edit Personal Info");
            System.out.println("2. Add Vehicle");
            System.out.println("3. View Vehicles & Tax");
            System.out.println("4. Back");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("New name: "); person.setName(scanner.nextLine());
                    System.out.print("New surname: "); person.setSurname(scanner.nextLine());
                    System.out.print("New address: "); person.setAddress(scanner.nextLine());
                    System.out.println("Info updated.");
                    break;
                case 2:
                    Vehicle v = createVehicle();
                    person.addVehicle(v);
                    registry.addVehicle(v);
                    System.out.println("Vehicle added.");
                    break;
                case 3:
                    System.out.println("Your Vehicles:");
                    for (Vehicle v2 : person.getVehicles()) {
                        System.out.println("- " + v2 + " | Tax: " + v2.calculateTax());
                    }
                    System.out.println("Total tax: " + person.calculateTotalTax());
                    break;
                case 4: return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    // ---------------- Vehicle & People Services -----------------

    private static void vehicleServices() {
        while (true) {
            System.out.println("\n--- Vehicle Services ---");
            System.out.println("1. Add Vehicle");
            System.out.println("2. Edit Vehicle");
            System.out.println("3. Delete Vehicle");
            System.out.println("4. Back");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    Vehicle v = createVehicle();
                    registry.addVehicle(v);
                    System.out.println("Vehicle added.");
                    break;
                case 2:
                    System.out.print("Enter plate number: ");
                    String plate = scanner.nextLine();
                    Vehicle ve = registry.searchVehicleByPlate(plate);
                    if (ve != null) {
                        System.out.print("New maker: "); ve.setMaker(scanner.nextLine());
                        System.out.print("New model: "); ve.setModel(scanner.nextLine());
                        System.out.println("Updated.");
                    } else {
                        System.out.println("Not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter plate number: ");
                    String pl = scanner.nextLine();
                    registry.deleteVehicle(pl);
                    System.out.println("Vehicle deleted.");
                    break;
                case 4: return;
            }
        }
    }

    private static void peopleServices() {
        while (true) {
            System.out.println("\n--- People Services ---");
            System.out.println("1. Add Person");
            System.out.println("2. Delete Person");
            System.out.println("3. Back");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("License number: "); String lic = scanner.nextLine();
                    System.out.print("Name: "); String n = scanner.nextLine();
                    System.out.print("Surname: "); String s = scanner.nextLine();
                    System.out.print("Address: "); String a = scanner.nextLine();
                    registry.addPerson(new Person(lic, n, s, a));
                    System.out.println("Person added.");
                    break;
                case 2:
                    System.out.print("License number: "); String l = scanner.nextLine();
                    registry.deletePerson(l);
                    System.out.println("Person deleted.");
                    break;
                case 3: return;
            }
        }
    }

    // ---------------- Vehicle Creation Helper -----------------

    private static Vehicle createVehicle() {
        System.out.println("Choose vehicle type: 1. PetrolCar 2. DieselCar 3. HybridCar 4. Motorcycle");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.print("Plate number: "); String plate = scanner.nextLine();
        System.out.print("Maker: "); String maker = scanner.nextLine();
        System.out.print("Model: "); String model = scanner.nextLine();

        Vehicle vehicle = null;
        switch (type) {
            case 1:
                System.out.print("CO2 emissions: "); double e1 = Double.parseDouble(scanner.nextLine());
                vehicle = new PetrolCar(plate, maker, model, e1);
                break;
            case 2:
                System.out.print("CO2 emissions: "); double e2 = Double.parseDouble(scanner.nextLine());
                vehicle = new DieselCar(plate, maker, model, e2);
                break;
            case 3:
                System.out.print("CO2 emissions: "); double e3 = Double.parseDouble(scanner.nextLine());
                vehicle = new HybridCar(plate, maker, model, e3);
                break;
            case 4:
                System.out.print("Engine displacement (cc): "); double cc = Double.parseDouble(scanner.nextLine());
                vehicle = new Motorcycle(plate, maker, model, cc);
                break;
            default:
                System.out.println("Invalid type, returning null.");
                return null;
        }

        // --- Assign Vehicle to Owner ---
        System.out.print("Enter owner's license number: ");
        String license = scanner.nextLine().trim();
        Person owner = registry.searchPersonByLicense(license);

        if (owner == null) {
            System.out.println("No person found with this license. Creating a new person.");
            System.out.print("Enter owner's name: "); String name = scanner.nextLine();
            System.out.print("Enter owner's surname: "); String surname = scanner.nextLine();
            System.out.print("Enter owner's address: "); String address = scanner.nextLine();
            owner = new Person(license, name, surname, address);
            registry.addPerson(owner);
        }

        owner.addVehicle(vehicle);  // Add vehicle to person's list
        registry.addVehicle(vehicle); // Register vehicle in the system

        System.out.println("Vehicle linked to owner: " + owner.getName() + " " + owner.getSurname());
        return vehicle;
    }
}
