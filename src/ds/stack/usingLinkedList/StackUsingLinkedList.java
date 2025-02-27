package ds.stack.usingLinkedList;


import java.util.EmptyStackException;
import java.util.Objects;

public class StackUsingLinkedList implements StackOperations {

    private Node top;

    public StackUsingLinkedList() {
        top = null;
    }


    @Override
    public void push(int value) {
        var newItem = new Node(value);
        newItem.setNext(top);
        top = newItem;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }

        var temp = top;
        top = top.getNext();
        temp.setNext(null);

        return temp.getData();
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(top);
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }

        return top.getData();
    }

    @Override
    public int size() {
        var temp = top;
        var counter = 0;
        while (temp != null) {
            temp = temp.getNext();
            counter++;
        }

        return counter;
    }

    @Override
    public boolean isFull() {
        System.out.println("Stack Using Linked List Is Never Full");
        return false;
    }

    @Override
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("Stack (top to bottom):");
            Node current = top;
            while (current != null) {
                System.out.println("|  " + current.getData() + "  |");
                current = current.getNext();
            }
            System.out.println(" ------- ");
        }
    }
}
