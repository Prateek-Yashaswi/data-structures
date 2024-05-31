package ds.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://www.geeksforgeeks.org/window-sliding-technique/
public class SlidingWindow {

    // Given an array of integers of size ‘n’, Our aim is to calculate the maximum sum of ‘k’ consecutive elements in the array.
    private static int maxSumOfAllSumArrays(int k, int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();
        int n = list.size();

        // Based on 0 - Indexing
        if (n < k) {
            System.out.println("INVALID");
            return -1;
        }

        Integer max = 0;

        // Sum of first window
        for (int i = 0; i < k; i++) {
            max += list.get(i);
        }

        int windowSum = max;

        for (int i = k; i < n; i++) {
            windowSum += list.get(i) - list.get(i - k);
            max = Math.max(windowSum, max);
        }

        return max;
    }

    // Given a string s, find the length of the longest substring without repeating characters.
    private static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map and within the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                // Move the left pointer (window) to the right of the previous position of currentChar
                left = map.get(currentChar) + 1;
            }

            map.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    //    Given an array of positive integers nums and a positive integer S,
    //    find the minimal length of a contiguous subarray of which the sum is greater than or equal to S. If there isn't one, return 0 instead.
    private static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            // Expand the Window: Add nums[end] to currentSum.
            currentSum += nums[end];

            // Shrink the Window
            while (currentSum >= s) {
                // While currentSum is greater than or equal to S, update minLength to the smaller length between the current minimum and the current window length (end - start + 1).
                minLength = Math.min(minLength, end - start + 1);
                // Subtract nums[start] from currentSum and move the start pointer to the right.
                currentSum -= nums[start];
                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};

        System.out.println(maxSumOfAllSumArrays(3, nums));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(minSubArrayLen(7, nums));
    }
}
