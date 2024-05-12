package ds.stack.repeatedDoubling;

import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        RepeatedDoubledStack<Integer> stack = new RepeatedDoubledStack<>(Integer.class);
        List<Integer> items = IntStream.rangeClosed(100, 110).boxed().toList();

        System.out.println("INPUTS: " + items);

        System.out.println("\nINITIAL SIZE OF THE STACK: " + stack.getSize());
        System.out.println("\n------PUSHING ITEMS INTO STACK------\n");
        items.forEach(stack::push);
        stack.printStack();
        System.out.println("\nINCREASED SIZE OF THE STACK: " + stack.getSize());

        System.out.println("\n------PEEKING TOP OF A STACK------");
        System.out.println(stack.peek());

        System.out.println("\n------POPPING ITEMS OUT OF THE STACK------\n");
        while (stack.getSize() > 8) {
            System.out.print("POPPING: " + stack.pop() + " | ");
        }

        System.out.println();
        stack.printStack();
        System.out.println("\nREDUCED SIZE OF THE STACK: " + stack.getSize());

        System.out.println("\n------EMPTYING THE STACK------");
        while (!stack.isEmpty()) {
            stack.pop();
        }

        stack.printStack();
        System.out.println("\nSIZE OF THE STACK: " + stack.getSize());
    }
}
