package ds.queues;

public interface QueueOperations {
    void enqueue(int value);

    int dequeue();

    int peek();

    boolean isEmpty();

    int size();

    void printQueue();
}
