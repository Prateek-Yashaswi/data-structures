package ds.queues;

public class QueueArrayImpl implements QueueOperations {

    private final int[] queue;
    private int front;
    private int rear;
    private final int capacity;
    private int currentSize;

    public QueueArrayImpl(int capacity) {
        queue = new int[capacity];
        front = 0;
        rear = -1;
        this.capacity = capacity;
        currentSize = 0;
    }

    @Override
    public void enqueue(int value) {
        System.out.println("------Performing Enqueue: " + value + "------");
        if (size() == capacity) {
            System.out.println("Queue is full");
            return;
        }

        // If we use queue[++rear] = value: You are incrementing rear directly using queue[++rear], but rear may go out of bounds.
        // Fix: Use a circular increment:
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        currentSize++;
    }

    @Override
    public int dequeue() {
        System.out.println("------Performing Dequeue------");
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }

        var removed = queue[front];
        front = (front + 1) % capacity; // Circular increment
        currentSize--;
        return removed;
    }

    @Override
    public int peek() {
        return size() != 0 ? queue[front] : Integer.MIN_VALUE;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public void printQueue() {
        System.out.println("------Printing Queue------");
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = 0; i < currentSize; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
