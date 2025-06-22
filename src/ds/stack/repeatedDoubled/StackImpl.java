package ds.stack.repeatedDoubled;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class StackImpl<T> implements StackInterface<T> {

    private static final int MINIMUM_CAPACITY = 1;

    private T[] stack = (T[]) new Object[MINIMUM_CAPACITY];
    private int size = 0;

    @Override
    public void push(T data) {

        if (Objects.isNull(data)) throw new IllegalArgumentException("Cant push null to the stack");

        resizeIfNeeded();
        stack[size++] = data;
    }

    @Override
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();

        var data = stack[size - 1];
        stack[size - 1] = null;
        size--;
        resizeIfNeeded();

        return data;
    }

    @Override
    public T peek() {
        if (isEmpty()) throw new EmptyStackException();

        return stack[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(T data) {
        if (Objects.isNull(data)) throw new IllegalArgumentException("Cannot search for null in stack");

        for (int i = 0; i < size; i++) {
            if (Objects.equals(stack[i], data)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {
        Arrays.fill(stack, null);
        size = 0;
        resizeIfNeeded();
    }

    @Override
    public void print() {

        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("----------Stack (Bottom -> Top)----------");
        for (int i = 0; i < size; i++) {
            System.out.print(stack[i] + ",");
        }

        System.out.println("\n-----------------------------------------");
    }

    @Override
    public int capacity() {
        return stack.length;
    }

    private void resizeIfNeeded() {
        if (size == stack.length) {
            T[] newStack = (T[]) new Object[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0, size);
            stack = newStack;
        } else if (size > 0 && size < stack.length / 4) {
            T[] newStack = (T[]) new Object[stack.length / 2];
            System.arraycopy(stack, 0, newStack, 0, size);
            stack = newStack;
        } else if (size == 0) {
            T[] newStack = (T[]) new Object[MINIMUM_CAPACITY];
            Arrays.fill(newStack, null);
            stack = newStack;
        }
    }
}
