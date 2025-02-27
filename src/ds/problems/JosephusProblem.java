package ds.problems;

import ds.linkedList.circular.CircularLinkedList;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * <a href="https://www.geeksforgeeks.org/josephus-problem/">Read More</a>
 * There are N people standing in a circle waiting to be executed.
 * The counting out begins at some point in the circle and proceeds around the circle in a fixed direction.
 * In each step, a certain number of people are skipped and the next person is executed.
 * The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom.
 * Given the total number of persons N and a number k which indicates that k-1 persons are skipped and the kth person is killed in a circle.
 * The task is to choose the person in the initial circle that survives.
 * <hr/>
 * Input: N = 5 and k = 2
 * <br/>
 * Output: 3
 * <br/>
 * Explanation: Firstly, the person at position 2 is killed,
 * then the person at position 4 is killed, then the person at position 1 is killed.
 * Finally, the person at position 5 is killed. So the person at position 3 survives.
 * <hr/>
 * Input: N = 7 and k = 3
 * <br/>
 * Output: 4
 * <br/>
 * Explanations: The persons at positions 3, 6, 2, 7, 5, and 1 are killed in order,
 * and the person at position 4 survives.
 */
public class JosephusProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Number Of People Standing (n)");
        int n = sc.nextInt();

        System.out.println("Enter The Value Of k");
        int k = sc.nextInt();

        var circularLinkedList = new CircularLinkedList();
        IntStream.rangeClosed(1, n).boxed().forEach(circularLinkedList::append);

        circularLinkedList.display();

        System.out.println("Killing Starts");
        System.out.println(k);

        var temp = circularLinkedList.getHead();

        var count = 1;
        while (circularLinkedList.size() != 1) {
            if (count == k) {
                circularLinkedList.delete(temp.data);
                count = 1;
            } else {
                count++;
            }

            temp = temp.next;
        }

        System.out.println("----------------------------------------------------------");
        System.out.println(temp.data + " Survives");
    }
}
