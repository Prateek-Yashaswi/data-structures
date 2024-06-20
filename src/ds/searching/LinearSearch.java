package ds.searching;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int key = 4;

        for (int j : arr) {
            if (j == key) {
                System.out.println(true);
                return;
            }
        }

        System.out.println(false);
    }
}
