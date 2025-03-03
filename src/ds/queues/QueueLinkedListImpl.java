package ds.queues;

import java.util.Objects;

public class QueueLinkedListImpl implements QueueOperations {
    private static final String EMPTY_QUEUE = "Queue is empty";

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    @Override
    public void enqueue(int value) {
        System.out.println("------Enqueuing " + value + "------");

        var newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        var temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    @Override
    public int dequeue() {
        System.out.println("------Performing Dequeue-------");

        if (isEmpty()) {
            System.out.println();
            return Integer.MIN_VALUE;
        }

        var temp = head;
        head = head.next;
        temp.next = null;
        return temp.data;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println(EMPTY_QUEUE);
            return Integer.MIN_VALUE;
        }

        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(head);
    }

    @Override
    public int size() {
        var size = 0;
        var temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    @Override
    public void printQueue() {
        if (isEmpty()) {
            System.out.println(EMPTY_QUEUE);
            return;
        }

        Node temp = head;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
