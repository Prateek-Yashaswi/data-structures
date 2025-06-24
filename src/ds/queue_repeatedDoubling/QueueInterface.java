package ds.queue_repeatedDoubling;

public interface QueueInterface<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    int size();
    boolean contains(T item);
    int capacity();
    void clear();
    void print();
}
