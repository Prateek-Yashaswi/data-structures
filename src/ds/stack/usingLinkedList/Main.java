package ds.stack.usingLinkedList;

@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------STACK USING LINKED LIST-----------------------");
        var stackUsingLL = new StackUsingLinkedList();

        stackUsingLL.push(1);
        stackUsingLL.push(2);
        stackUsingLL.push(3);

        stackUsingLL.printStack();
        System.out.println("Is Full: " + stackUsingLL.isFull());
        System.out.println("Peeking: " + stackUsingLL.peek());

        System.out.println("-----------------------------------------------------------");
        System.out.println("Popping: " + stackUsingLL.pop());
        System.out.println("Peeking: " + stackUsingLL.peek());
        System.out.println("Is Full: " + stackUsingLL.isFull());

        System.out.println("-----------------------------------------------------------");
        System.out.println("Popping: " + stackUsingLL.pop() + " And " + stackUsingLL.pop());
        System.out.println("Is Empty: " + stackUsingLL.isEmpty());
    }
}
