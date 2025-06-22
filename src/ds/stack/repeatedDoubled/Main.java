package ds.stack.repeatedDoubled;

public class Main {

    public static void main(String[] args) {
        StackInterface<Integer> stack = new StackImpl<>();

        var push = 100;
        while (push < 110) {
            stack.push(push);
            System.out.println("Current Size: " + stack.size() + " Out Of: " + stack.capacity());
            push++;
        }

        stack.print();
        System.out.println("Popped: " + stack.pop());
        stack.print();

        System.out.println("Current Size Of The Stack: " + stack.size());
        System.out.println("Current Capacity: " + stack.capacity());

        while (stack.size() > 2) {
            System.out.println("Popped: " + stack.pop());
            System.out.println("Current Size: " + stack.size() + " Out Of: " + stack.capacity());
        }

        stack.print();
        System.out.println("Top element: " + stack.peek());

        var search = 100;
        System.out.println("Stack contains " + search + " : " + stack.contains(search));
        stack.clear();
        stack.print();

        System.out.println("Current Size Of The Stack: " + stack.size());
        System.out.println("Current Capacity: " + stack.capacity());
    }
}
