package ds.stack.repeatedDoubled;

public interface StackInterface<T> {
    void push(T data);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
    boolean contains(T data);
    void clear();
    void print();
    int capacity();
}
