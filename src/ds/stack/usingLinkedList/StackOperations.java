package ds.stack.usingLinkedList;

public interface StackOperations {
    void push(int value);
    int pop();
    boolean isEmpty();
    int peek();
    int size();
    boolean isFull();
    void printStack();
}
