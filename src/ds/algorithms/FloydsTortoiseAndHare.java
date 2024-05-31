package ds.algorithms;

// https://www.youtube.com/watch?v=PvrxZaH_eZ4
public class FloydsTortoiseAndHare {
    private static class Node {
        int data;
        Node next;
    }

    private boolean detectCycle(Node head) {
        if (head == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }

    private Node findStartingPointInACycle(Node head) {
        if (head == null) return null;

        Node slow = head;
        Node fast = head;

        // Phase 1 - Finding Cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Phase 2 - Finding starting point of the cycle
            if (slow == fast) {
                Node start = head;

                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }

                // Return Start of the cycle
                return start;
            }
        }

        return null;
    }

    // 19
    // 1^2 + 9^2 = 82
    // 8^2 + 2^2 = 68
    // 6^2 + 8^2 = 100
    // 1^2 + 0^2 + 0^2 = 1
    private boolean happyNumber(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(fast);
            fast = digitSquareSum(fast);
        } while (slow != fast);

        return slow == 1;
    }

    private int digitSquareSum(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n /= 10;
        }

        return res;
    }
}
