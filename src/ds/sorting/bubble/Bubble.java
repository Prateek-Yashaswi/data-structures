package ds.sorting.bubble;

import ds.sorting.Utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Bubble {
    public static void main(String[] args) {
        Random random = new Random();
        // Tweak the integer size to check the difference in the time it takes to sort the array
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000000);
        }

        LocalDateTime startedAt = LocalDateTime.now();

        // Bubble Sort Algorithm
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                // Ascending | > for descending
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        LocalDateTime endedAt = LocalDateTime.now();

        System.out.println("SORTED ARRAY");
        Utils.printArrayUtil(arr);

        System.out.println("\n\nTOTAL TIME TAKEN TO SORT " + arr.length + " ITEMS: " + Duration.between(startedAt, endedAt).toMillis() + " Milliseconds");
    }
}
