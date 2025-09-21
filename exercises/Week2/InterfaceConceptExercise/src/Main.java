public class Main {
    public static void main(String[] args) {
        Person[] people = {
                new Person("Nika", "Soltani"),
                new Person("Nikoleta", "Manavi"),
                new Person("James", "Press"),
                new Person("John", "Doe"),
                new Person("Fred", "Struik")
        };

        Sorter sorter = new Sorter();
        sorter.sort(people);

        // Print sorted list
        for (Person p : people) {
            p.printPersonName();
        }
    }
}