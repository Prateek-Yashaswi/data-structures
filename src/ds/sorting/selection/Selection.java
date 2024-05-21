package ds.sorting.selection;

import ds.sorting.Utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Selection {
    public static void main(String[] args) {
        Random random = new Random();
        // Tweak the integer size to check the difference in the time it takes to sort the array
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000000);
        }

        LocalDateTime startedAt = LocalDateTime.now();

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;

            // Making Selection
            for (int j = i + 1; j < arr.length; j++) {
                // arr[j] > arr[minIndex] for descending
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swapping
            int curr = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = curr;
        }

        LocalDateTime endedAt = LocalDateTime.now();

        System.out.println("SORTED ARRAY");
        Utils.printArrayUtil(arr);

        System.out.println("\n\nTOTAL TIME TAKEN TO SORT " + arr.length + " ITEMS: " + Duration.between(startedAt, endedAt).toMillis() + " Milliseconds");
    }
}
