package ds.linkedList.circular;

@SuppressWarnings("all")
public class CircularLinkedList {

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public void append(int data) {
        var newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        var temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.next = head;
    }

    public void prepend(int data) {
        var newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        newNode.next = head;
        var temp = head;

        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newNode;
        head = newNode;
    }

    public void search(int data) {
        System.out.println("Searching " + data + ".........");
        if (head == null) {
            System.out.println("List Is Empty");
            return;
        }

        var index = 0;
        var temp = head;

        do {
            if (temp.data == data) {
                System.out.println("Found " + temp.data + " at index " + index);
                System.out.println("-----------------------------------------------");
                return;
            }

            temp = temp.next;
            index++;
        } while (temp != head);

        System.out.println(data + " Not Found");
        System.out.println("-----------------------------------------------");
    }

    public void delete(int data) {
        System.out.println("Deleting " + data);
        if (head == null) {
            System.out.println("List Is Empty");
            return;
        }

        // If Data At Head
        if (head.data == data) {
            // Single Node Case
            if (head.next == head) {
                head = null;
                return;
            }

            var temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = head.next;
            head = head.next;
            return;
        }

        // If Data Not Present At Head
        var temp = head;

        do {
            var prev = temp;
            temp = temp.next;

            if (temp.data == data) {
                prev.next = temp.next;
                return;
            }
        } while (temp != head);

        System.out.println("Node with value " + data + " not found.");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        if (head == null) {
            return 0;
        }

        if (head.next == head) {
            return 1;
        }

        var temp = head;
        var len = 1;
        while (temp.next != head) {
            temp = temp.next;
            len++;
        }

        return len;
    }

    public void display() {
        System.out.println("-----------------------------------------------");
        System.out.println("Printing Circular Linked List");
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        var temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }

        System.out.print(temp.data + "->{head: " + temp.next.data + "}");
        System.out.println("\n-----------------------------------------------");
    }
}
