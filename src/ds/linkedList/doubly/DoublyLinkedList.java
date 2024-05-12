package ds.linkedList.doubly;

import java.util.Objects;

public class DoublyLinkedList<T> {
    class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;

    public void insertAtEnd(T data) {
        var newNode = new Node(data);
        if (Objects.isNull(head)) {
            head = newNode;
        } else {
            var temp = head;
            while (!Objects.isNull(temp.next)) {
                temp = temp.next;
            }

            newNode.prev = temp;
            temp.next = newNode;
        }
    }

    public void insertAtStart(T data) {
        var newNode = new Node(data);

        if (!Objects.isNull(head)) {
            newNode.next = head;
            head.prev = newNode;
        }

        head = newNode;
    }

    public void insertAtIndex(Integer position, T data) {
        Integer size = getSize();
        if (position < 0 || position > size - 1)
            throw new IndexOutOfBoundsException("Invalid Index: Check Underflow/Overflow");

        if (position == 0) insertAtStart(data);
        else if (position == size - 1) insertAtEnd(data);

        else {
            var i = 0;
            var temp = head;
            var newNode = new Node(data);

            while (i != position - 1) {
                temp = temp.next;
                i++;
            }

            newNode.prev = temp;
            newNode.next = temp.next;
            temp.next.prev = newNode;
            temp.next = newNode;
        }
    }

    public void deleteFromEnd() {
        var temp = Objects.requireNonNull(head);
        while (!Objects.isNull(temp.next.next)) {
            temp = temp.next;
        }

        temp.next = null;
    }

    public void deleteAtStart() {
        var temp = Objects.requireNonNull(head);
        head = head.next;
        head.prev = null;

        temp.next = null;
        temp.prev = null; // Not needed since it will always be null since it's head node
    }

    public void deleteAtIndex(Integer index) {
        if (index < 0 || index > getSize() - 1)
            throw new RuntimeException("Check the index input: Underflow/Overflow Condition");

        if (index == 0) deleteAtStart();
        else if (index == getSize() - 1) deleteFromEnd();

        else {
            var i = 0;
            var fast = Objects.requireNonNull(head);
            var slow = Objects.requireNonNull(head);

            while (i != index) {
                slow = fast;
                fast = fast.next;
                i++;
            }

            slow.next = fast.next;
            var temp = fast; // To delete the node
            fast = fast.next;
            fast.prev = slow;

            temp.next = null;
            temp.prev = null;
        }
    }

    public Integer getSize() {
        if (Objects.isNull(head)) return 0;

        var temp = head;
        Integer i = 0;
        while (!Objects.isNull(temp)) {
            temp = temp.next;
            i++;
        }

        return i;
    }

    public void printList() {
        var temp = head;
        Node rev = null;

        System.out.print("Printing using next pointer:\t");
        while (!Objects.isNull(temp)) {
            if (temp.next == null) rev = temp;
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.print("\nPrinting using prev pointer:\t");
        while (!Objects.isNull(rev)) {
            System.out.print(rev.data + " <- ");
            rev = rev.prev;
        }

        System.out.println("\n\n");
    }
}
