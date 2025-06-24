package ds.queue_repeatedDoubling;

@SuppressWarnings("all")
public class Main {

    public static void main(String[] args) {

        QueueInterface<Integer> queue = new QueueImpl<>();

        var inputs = 15;
        for (int i = 0; i < inputs; i++) {
            System.out.println("Current Size: " + queue.size() + ", Current capacity: " + queue.capacity());
            queue.enqueue(i);
        }

        queue.print();

        System.out.println("Deque: " + queue.dequeue());
        System.out.println("Current Size: " + queue.size() + ", Current capacity: " + queue.capacity());

        var dequeue = 12;
        for (int i = 0; i < dequeue; i++) {
            System.out.println("Current Size: " + queue.size() + ", Current capacity: " + queue.capacity());
            System.out.println("Deque: " + queue.dequeue());
        }

        queue.print();

        queue.enqueue(50);
        queue.enqueue(51);
        queue.enqueue(52);
        queue.enqueue(53);

        System.out.println("Queue contains 50: " + queue.contains(50));
        System.out.println("Queue contains 150: " + queue.contains(150));

        queue.print();


        while (!queue.isEmpty()) {
            System.out.println("Current Size: " + queue.size() + ", Current capacity: " + queue.capacity());
            System.out.println(queue.dequeue());
        }

        queue.enqueue(1);
        queue.enqueue(2);
        queue.print();
        System.out.println("Current Size: " + queue.size() + ", Current capacity: " + queue.capacity());

        System.out.println("Clearing");
        queue.clear();
        System.out.println("Current Size: " + queue.size() + ", Current capacity: " + queue.capacity());
    }
}
