package ds.stack.normal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class NormalStack<T> {
    private final T[] stack;
    private final Integer capacity;
    private Integer top;

    @SuppressWarnings("unchecked")
    NormalStack(Class<T> clazz, Integer capacity) {
        this.capacity = capacity;
        this.stack = (T[]) Array.newInstance(clazz, capacity);
        this.top = -1;
    }

    public void push(T data) {
        if (isFull())
            throw new StackOverflowError("Overflow Condition");

        stack[++top] = data;
    }

    public T pop() {
        if (isEmpty())
            throw new EmptyStackException();

        T temp = stack[top];
        stack[top--] = null;

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
        return top == capacity - 1;
    }

    public void printStack() {
        if (isEmpty())
            System.out.println("\nEMPTY STACK");
        else {
            Arrays.stream(stack).filter(Objects::nonNull).forEach(item -> System.out.print("|" + item + "|\t"));
            System.out.println("<-----TOP-----");
        }
    }
}
