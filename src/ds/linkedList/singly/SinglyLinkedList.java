package ds.linkedList.singly;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class SinglyLinkedList<T> {

    class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void insertAtStart(T data) {
        var newNode = new Node(data);

        if (!Objects.isNull(head)) {
            newNode.next = head;
        }

        head = newNode;
    }

    public void insertAtEnd(T data) {
        var newNode = new Node(data);

        if (Objects.isNull(head)) {
            head = newNode;
        } else {
            var temp = head;
            while (!Objects.isNull(temp.next)) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    public void insertAtIndex(Integer position, T data) {

        if (position < 0 || position > getSize())
            throw new IndexOutOfBoundsException("Position input is invalid: Check Underflow/Overflow Condition");

        int i = 0;
        var temp = head;
        var newNode = new Node(data);

        while (i != position - 1) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deleteAtStart() {
        if (Objects.isNull(head)) throw new RuntimeException("Underflow Condition");

        var temp = head;
        head = temp.next;
        temp.next = null;
    }

    public void deleteAtEnd() {
        if (Objects.isNull(head)) throw new RuntimeException("Underflow Condition");

        var temp = head;
        while (!Objects.isNull(temp.next.next)) {
            temp = temp.next;
        }

        temp.next = null;
    }

    public void deleteAtIndex(Integer position) {
        if (Objects.isNull(head) || position > getSize())
            throw new IndexOutOfBoundsException("Position input is invalid: Check Underflow/Overflow Condition");


        var i = 0;
        var temp = head;
        Node prev = null;
        while (i != position) {
            prev = temp;
            temp = temp.next;
            i++;
        }

        assert prev != null;
        prev.next = temp.next;
        temp.next = null;
    }

    public Integer getSize() {
        if (Objects.isNull(head)) return 0;

        int i = 1;
        var temp = head;
        while (!Objects.isNull(temp.next)) {
            temp = temp.next;
            i++;
        }

        return i;
    }

    public T findMiddle() {
        if (Objects.isNull(head)) throw new RuntimeException();

        Node fast = head;
        Node slow = head;

        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.data;
    }

    public void reverse() {
        if (Objects.isNull(head)) throw new RuntimeException();

        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        head = prev;
    }

    public void removeDuplicates() {
        if (Objects.isNull(head)) throw new RuntimeException();

        List<T> visited = new ArrayList<>();
        Node temp = head;

        while (temp.next != null) {
            if (!visited.contains(temp.data)) visited.add(temp.data);
            else {
                Node temp2 = temp;
                while (temp2.data == temp.data && temp2.next != null) {
                    temp2 = temp2.next;
                }

                temp.next = temp2;
                temp = temp.next;
            }
        }
    }

    public T nFromEnd(Integer n) {
        int i = 1;
        Node temp = head;
        while (i != n) {
            temp = temp.next;
            i++;
            if (temp == null) {
                throw new RuntimeException("List is not long enough");
            }
        }

        Node slow = head;
        while (temp.next != null) {
            slow = slow.next;
            temp = temp.next;
        }

        return slow.data;
    }

    // https://www.youtube.com/watch?v=PvrxZaH_eZ4
    // Floyd's Tortoise and Hare algorithm
    private Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node pointerA = headA;
        Node pointerB = headB;

        while (pointerA != pointerB) {
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }

        return pointerA;
    }

    private Node findIntersectionNodeInALinkedList(Node head) {
        Node slow = head;
        Node fast = head;

        // Detect Cycle - Floyd's tortoise and hare algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Find Start of the cycle
            if (slow == fast) {
                Node start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }

                return start; // The start of the cycle
            }
        }

        return null;
    }

    public void printList() {
        var temp = head;
        while (!Objects.isNull(temp.next)) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.print(temp.data);
        System.out.println("\n");
    }
}