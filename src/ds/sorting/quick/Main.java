package ds.sorting.quick;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        var arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(arr.length);
        }

        System.out.println("Unsorted: " + Arrays.toString(arr));
        var startSortingAt = LocalDateTime.now();
        QuickSort.quickSort(arr);
        System.out.println("Sorting " + arr.length + " elements took " + Duration.between(startSortingAt, LocalDateTime.now()).toMillis() + "ms");
        System.out.println("Sorted: " + Arrays.toString(arr));
    }
}
