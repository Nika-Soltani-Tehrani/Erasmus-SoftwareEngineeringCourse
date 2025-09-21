public class Person implements Comparable<Person> {

    protected String name;
    protected String surname;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void printPersonName() {
        System.out.println("Person's name is: " + this.name + ", " + this.surname);
    }

    @Override
    public int compareTo(Person other) {
        int surnameCmp = surname.compareToIgnoreCase(other.surname);
        if (surnameCmp != 0) return surnameCmp;
        return name.compareToIgnoreCase(other.name);
    }
}
