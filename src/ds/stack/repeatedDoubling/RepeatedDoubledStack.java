package ds.stack.repeatedDoubling;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class RepeatedDoubledStack<T> {
    private static final Integer DEFAULT_CAPACITY = 4;

    private T[] stack;
    private Integer currentCapacity;
    private Integer top;

    @SuppressWarnings("unchecked")
    public RepeatedDoubledStack(Class<T> clazz) {
        this.stack = (T[]) Array.newInstance(clazz, DEFAULT_CAPACITY);
        this.top = -1;
        this.currentCapacity = DEFAULT_CAPACITY;
    }

    public void push(T data) {
        if (isFull())
            throw new StackOverflowError("Stack is full");

        stack[++top] = data;

        // Check if stack needs to be doubled
        if (isFull())
            changeTheCapacity(Capacities.DOUBLE);
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        var temp = stack[top];
        stack[top--] = null;

        // Check if stack needs to be halved: Stack needs to be 25% filled & stack size should always be greater than the default capacity
        if (top < currentCapacity / 4 && currentCapacity > DEFAULT_CAPACITY)
            changeTheCapacity(Capacities.HALF);

        return temp;
    }

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return stack[top];
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == currentCapacity - 1;
    }

    public Integer getSize() {
        return stack.length;
    }

    @SuppressWarnings("unchecked")
    private void changeTheCapacity(Capacities capacity) {
        this.currentCapacity = capacity.equals(Capacities.DOUBLE) ? currentCapacity * 2 : currentCapacity / 2;
        var newStack = (T[]) Array.newInstance(stack.getClass().getComponentType(), currentCapacity);

        System.arraycopy(stack, 0, newStack, 0, top + 1);

        this.stack = newStack;
    }

    public void printStack() {
        if (top == -1)
            System.out.println("\nEMPTY STACK");
        else {
            Arrays.stream(stack).filter(Objects::nonNull).forEach(item -> System.out.print("|" + item + "|\t"));
            System.out.println("<-----TOP-----");
        }
    }
}
