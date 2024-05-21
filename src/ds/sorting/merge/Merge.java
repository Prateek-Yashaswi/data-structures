package ds.sorting.merge;

// https://www.youtube.com/watch?v=bOk35XmHPKs

import ds.sorting.Utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Merge {
    public static void main(String[] args) {
        Random random = new Random();
        // Tweak the integer size to check the difference in the time it takes to sort the array
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000000);
        }

        LocalDateTime startedAt = LocalDateTime.now();
        mergeSort(arr);
        LocalDateTime endedAt = LocalDateTime.now();

        System.out.println("SORTED ARRAY");
        Utils.printArrayUtil(arr);

        System.out.println("\n\nTOTAL TIME TAKEN TO SORT " + arr.length + " ITEMS: " + Duration.between(startedAt, endedAt).toMillis() + " Milliseconds");
    }

    // Merge Sort Algorithm
    private static void mergeSort(int[] arr) {
        int inputLen = arr.length;

        // Array with 0 or 1 elements that means it's already sorted
        if (inputLen < 2) {
            return;
        }

        // Calculating mid and assigning left and right halves
        int mid = inputLen / 2;
        int[] left = new int[mid];
        int[] right = new int[inputLen - mid];

        for (int i = 0; i < mid; i++) left[i] = arr[i];
        for (int i = mid; i < inputLen; i++) right[i - mid] = arr[i];

        // Sort left array
        mergeSort(left);

        // Sort right array
        mergeSort(right);

        // Merging sorted arrays
        mergeResults(arr, left, right);
    }

    // Merge Algorithm
    private static void mergeResults(int[] arr, int[] left, int[] right) {
        int leftLen = left.length;
        int rightLen = right.length;

        // i = leftHalf | j = rightHalf | k = mergedArray
        int i = 0, j = 0, k = 0;

        // Look will run unless we run out of elements in either left or right array
        while (i < leftLen && j < rightLen) {
            // If element in the left array is small, add it at arr[k] and increment i (our left pointer)
            // or else add the element from the right array to arr[k] and increment j (our right pointer)
            // NOTE: k is pointing to the original array and is responsible for modifying it's elements correctly
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }

            k++;
        }

        // If any of the elements remain in the left or right array after above comparison
        // Simply add it to the end of our original arr

        // For left array
        while (i < leftLen) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // For right array
        while (j < leftLen) {
            arr[k] = left[j];
            j++;
            k++;
        }
    }
}
