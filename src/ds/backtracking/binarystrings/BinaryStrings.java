package ds.backtracking.binarystrings;

import java.util.Arrays;

public class BinaryStrings {
    int[] arr;
    public BinaryStrings(int n) {
        arr = new int[n];
    }

    public void binary(int n) {
        if (n <= 0) {
            System.out.println(Arrays.toString(arr));
        } else {
            arr[n - 1] = 0;
            binary(n - 1);

            arr[n - 1] = 1;
            binary(n - 1);
        }
    }
}
