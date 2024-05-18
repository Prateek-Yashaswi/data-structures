package ds.searching;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 5, 6, 7};
        int target = 6;
        var found = binarySearch(arr, 0, arr.length - 1, target);
        System.out.println(found ? target + " FOUND" : target + " NOT FOUND");
    }

    private static boolean binarySearch(int[] arr, int start, int end, int target) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return true;
        } else if (arr[mid] > target) {
            return binarySearch(arr, 0, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, end, target);
        }
    }
}
