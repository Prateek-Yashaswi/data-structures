package ds.linkedList.singly;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> data = IntStream.rangeClosed(1, 10).boxed().toList();

        System.out.println("Inserting elements at the beginning");
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        data.forEach(singlyLinkedList::insertAtStart);
        singlyLinkedList.printList();

        System.out.println("Inserting elements at the end");
        singlyLinkedList.insertAtEnd(11);
        singlyLinkedList.printList();

        System.out.println("Inserting element at a position: Zero-Based Indexing");
        singlyLinkedList.insertAtIndex(2, 1002);
        singlyLinkedList.printList();

        System.out.println("Deleting at start");
        singlyLinkedList.deleteAtStart();
        singlyLinkedList.printList();

        System.out.println("Deleting at end");
        singlyLinkedList.deleteAtEnd();
        singlyLinkedList.printList();

        System.out.println("Deleting at an Index: Zero-Based Indexing");
        singlyLinkedList.deleteAtIndex(4);
        singlyLinkedList.printList();
    }
}
