package ds.queues;

import java.util.Stack;

@SuppressWarnings("all")
public class QueuesUsingStack {

    private final Stack<Integer> stack;

    public QueuesUsingStack() {
        stack = new Stack<>();
    }

    public void enqueue(int value) {
        stack.push(value);
    }

    public int dequeue() {
        var temp = new Stack<Integer>();

        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        var removed = temp.pop();

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return removed;
    }

    public int peek() {
        var temp = new Stack<Integer>();

        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }

        var res = temp.peek();

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

        return res;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
