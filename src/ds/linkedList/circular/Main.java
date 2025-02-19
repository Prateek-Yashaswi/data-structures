package ds.linkedList.circular;

public class Main {
    public static void main(String[] args) {
        var circularLinkedList = new CircularLinkedList();

        circularLinkedList.append(1);
        circularLinkedList.append(2);
        circularLinkedList.append(3);
        circularLinkedList.append(4);
        circularLinkedList.append(5);
        circularLinkedList.prepend(10);
        circularLinkedList.prepend(15);

        circularLinkedList.display();

        circularLinkedList.search(5);
        circularLinkedList.delete(5);

        circularLinkedList.display();
    }
}
