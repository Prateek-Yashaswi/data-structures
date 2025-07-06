package ds.sorting.quick;

import java.util.Random;

public class QuickSort {

    private QuickSort() {
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        var pivotIdx = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        var pivot = arr[pivotIdx];

        swap(arr, pivotIdx, highIndex);
        var partitionIdx = partition(arr, lowIndex, highIndex, pivot);
        quickSort(arr, lowIndex, partitionIdx - 1);
        quickSort(arr, partitionIdx + 1, highIndex);
    }

    private static int partition(int[] arr, int lowIndex, int highIndex, int pivot) {
        var cursor = lowIndex;

        for (var i = lowIndex; i <= highIndex; i++) {
            if (arr[i] < pivot) {
                swap(arr, cursor, i);
                cursor++;
            }
        }

        swap(arr, cursor, highIndex);
        return cursor;
    }

    private static void swap(int[] arr, int x, int y) {
        var temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
