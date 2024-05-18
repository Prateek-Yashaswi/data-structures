package ds.binarytree;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        var root = tree.insert(null, 10);
        tree.insert(root, 20);
        tree.insert(root, 50);
        tree.insert(root, 5);
        tree.insert(root, 1);
        tree.insert(root, 7);

        System.out.println("\n---------------- PRINTING INORDER ----------------");
        tree.printInOrder(root);

        System.out.println("\n---------------- PRINTING POSTORDER --------------");
        tree.printPostOrder(root);

        System.out.println("\n---------------- PRINTING PREORDER ---------------");
        tree.printPreOrder(root);

        System.out.println("\n---------------- SEARCHING IN TREE ---------------");
        Integer target = 50;
        var found = tree.search(root, target);
        System.out.println(Objects.isNull(found) ? target + " NOT FOUND !!!" : target + " FOUND !!!");

        System.out.println("\n----------- PRINTING LEAVES OF THE TREE ----------");
        tree.printLeaves(root);

        System.out.println("\n----------- COUNTING LEAVES OF THE TREE ----------");
        System.out.println(tree.countLeaves(root));
    }
}
