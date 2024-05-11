package ds.linkedList.singly;

import java.util.Objects;

class SinglyLinkedList {

    static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<Object> head;

    public void insertAtStart(Object data) {
        var newNode = new Node<>(data);

        if (!Objects.isNull(head)) {
            newNode.next = head;
        }

        head = newNode;
    }

    public void insertAtEnd(Object data) {
        var newNode = new Node<>(data);

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

    public void insertAtIndex(Integer position, Object data) {

        if (position < 0 || position > getSize())
            throw new IndexOutOfBoundsException("Position input is invalid: Check Underflow/Overflow Condition");

        int i = 0;
        var temp = head;
        var newNode = new Node<>(data);

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
        Node<Object> prev = null;
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

    public void printList() {
        Node<Object> temp = head;
        while (!Objects.isNull(temp.next)) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.print(temp.data);
        System.out.println("\n");
    }
}