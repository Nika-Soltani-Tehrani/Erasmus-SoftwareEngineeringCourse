public class Sorter {

    public void sort(Person[] persons) {
        quickSort(persons, 0, persons.length - 1);
    }

    // Quicksort recursive method
    private void quickSort(Person[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition method
    private int partition(Person[] arr, int low, int high) {
        Person pivot = arr[high];  // Choose last element as pivot
        int i = low - 1;           // Index of smaller element

        for (int j = low; j < high; j++) {
            if (compare(arr[j], pivot) <= 0) {
                i++;
                // Swap arr[i] and arr[j]
                Person temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        Person temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Compare by surname, then name
    private int compare(Person p1, Person p2) {
        int surnameComparison = p1.getSurname().compareToIgnoreCase(p2.getSurname());
        if (surnameComparison != 0) {
            return surnameComparison;
        }
        return p1.getName().compareToIgnoreCase(p2.getName());
    }
}
