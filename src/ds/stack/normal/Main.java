package ds.stack.normal;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        NormalStack<Integer> stack = new NormalStack<>(Integer.class, 10);
        List<Integer> items = IntStream.rangeClosed(1, 10).boxed().toList();

        System.out.println("INPUT: " + items);

        System.out.println("\n----------Pushing elements----------");
        items.forEach(item -> {
            stack.push(item);
            System.out.print("PUSHED: " + item + " | ");
        });

        System.out.println("\n\n----------Current Stack----------");
        stack.printStack();

        System.out.println("\n----------Peeking Stack----------");
        System.out.println(stack.peek());

        System.out.println("\n----------Popping elements----------");
        while (!stack.isEmpty()) {
            System.out.println("POPPED: " + stack.pop());
            stack.printStack();
        }
    }
}
