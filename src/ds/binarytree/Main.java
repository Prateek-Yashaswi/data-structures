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

        System.out.println("""
                           10
                          / \\
                        5    20
                       / \\    \\
                      1    7    50
                """);

        System.out.println("\n---- PRINTING INORDER - DEPTH FIRST TRAVERSAL ----");
        tree.printInOrder(root);

        System.out.println("\n--- PRINTING POSTORDER - DEPTH FIRST TRAVERSAL ---");
        tree.printPostOrder(root);

        System.out.println("\n---- PRINTING PREORDER - DEPTH FIRST TRAVERSAL ---");
        tree.printPreOrder(root);

        System.out.println("\n---------------- SEARCHING IN TREE ---------------");
        Integer target = 50;
        var found = tree.search(root, target);
        System.out.println(Objects.isNull(found) ? target + " NOT FOUND !!!" : target + " FOUND !!!");

        System.out.println("\n----------- PRINTING LEAVES OF THE TREE ----------");
        tree.printLeaves(root);

        System.out.println("\n----------- COUNTING LEAVES OF THE TREE ----------");
        System.out.println(tree.countLeaves(root));

        System.out.println("\nBREADTH FIRST SEARCH / LEVEL ORDER TRAVERSAL");
        tree.levelOrderTraversal(root);

        System.out.println("\n\nHEIGHT OF THE TREE");
        System.out.println(tree.findHeight(root));

        System.out.println("\n\nMIN HEIGHT OF THE TREE");
        System.out.println(tree.minHeight(root));

        System.out.println("\n\nCHECK IF ANY PATH FROM ROOT To LEAF OF THE TREE SUMS UP TO TARGET: 80 (10 + 20 + 50)");
        System.out.println(tree.hasPathSum(root, 80));

        System.out.println("\n\nSUMMING UP LEFT LEAVES");
        System.out.println(tree.sumOfLeftLeaves(root));
    }
}
