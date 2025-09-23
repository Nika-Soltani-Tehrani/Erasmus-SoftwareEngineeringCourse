import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sorter {

    public <T extends Comparable<T>> void sort(T[] array) {
        List<T> list = Arrays.asList(array);
        Collections.sort(list);
    }

}