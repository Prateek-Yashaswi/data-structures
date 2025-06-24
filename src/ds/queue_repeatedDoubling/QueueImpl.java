package ds.queue_repeatedDoubling;

import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class QueueImpl<T> implements QueueInterface<T> {

    private static final int MINIMUM_CAPACITY = 1;
    private T[] queue = (T[]) new Object[MINIMUM_CAPACITY];
    private int front = 0;
    private int rear = 0;
    private int size = 0;


    @Override
    public void enqueue(T item) {
        resizeIfNeeded();
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        size++;
    }

    @Override
    public T dequeue() {

        if (isEmpty()) throw new IllegalArgumentException("Queue is empty");

        var result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;
        resizeIfNeeded();

        return result;
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
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(queue[(front + i) % queue.length], item)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int capacity() {
        return queue.length;
    }

    @Override
    public void clear() {
        Arrays.fill(queue, null);
        size = 0;
        front = 0;
        rear = 0;
        resizeIfNeeded();
    }

    @Override
    public void print() {
        if (isEmpty()) throw new IllegalArgumentException("Queue is empty");

        System.out.println("##### Printing queue with front = " + front + " rear = " + rear + " size = " + size);
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % queue.length] + ",");
        }

        System.out.println("\n####################");
    }

    private void resizeIfNeeded() {

        // queue if full
        if (size == queue.length) {
            T[] newQueue = (T[]) new Object[queue.length * 2];

            for (var i = 0; i < size; i++) {
                newQueue[i] = queue[(front + i) % queue.length];
            }

            queue = newQueue;
            front = 0;
            rear = size;
        }

        // queue has 25% elements
        else if (queue.length > MINIMUM_CAPACITY && size == queue.length / 4) {
            T[] newQueue = (T[]) new Object[queue.length / 2];

            for (var i = 0; i < size; i++) {
                newQueue[i] = queue[(front + i) % queue.length];
            }

            queue = newQueue;
            front = 0;
            rear = size;
        }

        // queue is empty
        else if (isEmpty() && queue.length > MINIMUM_CAPACITY) {
            T[] newQueue = (T[]) new Object[MINIMUM_CAPACITY];
            Arrays.fill(newQueue, null);
            queue = newQueue;
            front = 0;
            rear = 0;
        }
    }
}
