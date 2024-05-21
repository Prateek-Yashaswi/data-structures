package ds.sorting;


// https://www.youtube.com/watch?v=0lOnnd50cGI

public class Insertion {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1, -1};

        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = curr;
        }

        for (int n : arr) System.out.print(n + " ");
    }
}
