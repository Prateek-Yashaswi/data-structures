package ds.sorting;

public class Selection {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1, -1};

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

        for (int item : arr) System.out.print(item + " ");
    }
}
