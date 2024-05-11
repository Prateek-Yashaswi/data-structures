package ds.linkedList.singly;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> data = IntStream.rangeClosed(1, 10).boxed().toList();

        System.out.println("Inserting elements at the beginning");
        SinglyLinkedList ll1 = new SinglyLinkedList();
        data.forEach(ll1::insertAtStart);
        ll1.printList();


        System.out.println("Inserting elements at the end");
        SinglyLinkedList ll2 = new SinglyLinkedList();
        data.forEach(ll2::insertAtEnd);
        ll2.printList();

        System.out.println("Inserting element after a position: Zero-Based Indexing");
        ll2.insertAfterAnIndex(2, 1001);
        ll2.printList();

        System.out.println("Inserting element at a position: Zero-Based Indexing");
        ll2.insertAtIndex(2, 1002);
        ll2.printList();
    }
}
