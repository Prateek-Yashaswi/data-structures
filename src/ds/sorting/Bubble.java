package ds.sorting;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1, -1};

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

        for (int item: arr) {
            System.out.print(item + " ");
        }
    }
}
