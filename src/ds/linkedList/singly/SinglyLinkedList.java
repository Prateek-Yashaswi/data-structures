package ds.linkedList.singly;

import java.util.Objects;

class SinglyLinkedList {

    static class Node<T> {
        T data;
        Node<Object> next;

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

    public void insertAfterAnIndex(Integer position, Object data) {

        if (position < 0 || position > getSize()  - 1)
            throw new IndexOutOfBoundsException("Position input is invalid");

        int i = 0;
        var temp = head;
        var newNode = new Node<>(data);

        while (i != position) {
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertAtIndex(Integer position, Object data) {

        if (position < 0 || position > getSize())
            throw new IndexOutOfBoundsException("Position input is invalid");

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