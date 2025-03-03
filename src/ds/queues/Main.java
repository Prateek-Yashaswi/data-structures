package ds.queues;

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        var arrQueue = new QueueArrayImpl(6);
        arrQueue.enqueue(1);
        arrQueue.enqueue(2);
        arrQueue.enqueue(3);
        arrQueue.enqueue(4);
        arrQueue.enqueue(5);

        arrQueue.printQueue();
        arrQueue.dequeue();
        arrQueue.printQueue();

        arrQueue.dequeue();
        arrQueue.dequeue();
        arrQueue.dequeue();
        arrQueue.dequeue();
        System.out.println("Size: " + arrQueue.size());
        System.out.println("Is Empty: " + arrQueue.isEmpty());


        System.out.println("----------------------------------------");
        System.out.println("Queues Using LinkedList");

        var linkedListQueue = new QueueLinkedListImpl();
        linkedListQueue.enqueue(1);
        linkedListQueue.enqueue(2);
        linkedListQueue.enqueue(3);
        linkedListQueue.enqueue(4);
        linkedListQueue.enqueue(5);

        linkedListQueue.printQueue();
        linkedListQueue.dequeue();
        linkedListQueue.printQueue();

        linkedListQueue.dequeue();
        linkedListQueue.dequeue();
        linkedListQueue.dequeue();
        linkedListQueue.dequeue();

        System.out.println("Size: " + linkedListQueue.size());
        System.out.println("Is Empty: " + linkedListQueue.isEmpty());
    }
}
