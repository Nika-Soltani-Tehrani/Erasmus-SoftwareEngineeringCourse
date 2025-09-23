import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorter {

    // Version using Java Collections (if you want it):
    // public <T extends MyComparable<T>> void sort(T[] array) {
    //     List<T> list = Arrays.asList(array);  // wraps the array as a List
    //     Collections.sort(list, (a, b) -> a.compareTo(b)); // custom comparator using MyComparable
    //     // no need to copy back, since Arrays.asList gives a view of the array
    // }

    public <T extends MyComparable<T>> void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // Quicksort recursive method
    private <T extends MyComparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition method
    private <T extends MyComparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];  // Choose last element as pivot
        int i = low - 1;      // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                // Swap arr[i] and arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (pivot)
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
