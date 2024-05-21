package ds.sorting.insertion;


// https://www.youtube.com/watch?v=0lOnnd50cGI

import ds.sorting.Utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Insertion {
    public static void main(String[] args) {
        Random random = new Random();
        // Tweak the integer size to check the difference in the time it takes to sort the array
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000000);
        }

        LocalDateTime startedAt = LocalDateTime.now();

        // Insertion Sort Algorithm
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = curr;
        }

        LocalDateTime endedAt = LocalDateTime.now();

        System.out.println("SORTED ARRAY");
        Utils.printArrayUtil(arr);

        System.out.println("\n\nTOTAL TIME TAKEN TO SORT " + arr.length + " ITEMS: " + Duration.between(startedAt, endedAt).toMillis() + " Milliseconds");
    }
}
