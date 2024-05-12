package ds.linkedList.doubly;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        List<Integer> items = IntStream.rangeClosed(1, 10).boxed().toList();

        System.out.println("Inserting elements at the end");
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
        items.forEach(dll::insertAtEnd);
        dll.printList();

        System.out.println("Inserting elements at the start");
        dll.insertAtStart(1001);
        dll.printList();

        System.out.println("Inserting elements at an Index: Zero based indexing");
        dll.insertAtIndex(7, 1002);
        dll.printList();

        System.out.println("Deleting Last element ");
        dll.deleteFromEnd();
        dll.printList();

        System.out.println("Deleting First element ");
        dll.deleteAtStart();
        dll.printList();

        System.out.println("Deleting at an index: Zero Based Indexing");
        dll.deleteAtIndex(6);
        dll.printList();
    }
}
