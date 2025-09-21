import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create list of Persons
        List<Person> people = new ArrayList<>();
        people.add(new Person("Nika", "Soltani"));
        people.add(new Person("Nikoleta", "Manavi"));
        people.add(new Person("James", "Press"));
        people.add(new Person("John", "Doe"));
        people.add(new Person("Fred", "Struik"));

        System.out.println("Before sorting Persons:");
        for (Person p : people) {
            p.printPersonName();
        }

        Collections.sort(people);

        System.out.println("\nAfter sorting Persons:");
        for (Person p : people) {
            p.printPersonName();
        }

        // Create list of Rectangles
        List<Rectangle> rectangles = new ArrayList<>();
        rectangles.add(new Rectangle(2.0, 5.0));
        rectangles.add(new Rectangle(4.0, 4.0));
        rectangles.add(new Rectangle(1.0, 10.0));
        rectangles.add(new Rectangle(3.0, 3.0));
        rectangles.add(new Rectangle(6.0, 2.0));

        System.out.println("\nBefore sorting Rectangles:");
        for (Rectangle r : rectangles) {
            System.out.println("Rectangle area: " + r.calculateArea());
        }

        Collections.sort(rectangles);

        System.out.println("\nAfter sorting Rectangles:");
        for (Rectangle r : rectangles) {
            System.out.println("Rectangle area: " + r.calculateArea());
        }
    }
}
