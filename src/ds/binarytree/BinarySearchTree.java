package ds.binarytree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BinarySearchTree {

    public Node insert(Node node, Integer data) {
        Node newNode = new Node(data);
        if (Objects.isNull(node)) {
            node = newNode;
        } else {
            if (data < node.data) {
                node.left = insert(node.left, data);
            } else if (data > node.data) {
                node.right = insert(node.right, data);
            }
        }

        return node;
    }

    public Node search(Node root, Integer target) {
        if (Objects.isNull(root) || Objects.equals(root.data, target)) return root;

        if (target > root.data)
            return search(root.right, target);

        return search(root.left, target);
    }

    public void printInOrder(Node root) {
        if (Objects.nonNull(root)) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    public void printPostOrder(Node root) {
        if (Objects.nonNull(root)) {
            printInOrder(root.left);
            printInOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void printPreOrder(Node root) {
        if (Objects.nonNull(root)) {
            System.out.print(root.data + " ");
            printInOrder(root.left);
            printInOrder(root.right);
        }
    }

    public void printLeaves(Node root) {
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }

        if (root.left != null)
            printLeaves(root.left);

        if (root.right != null)
            printLeaves(root.right);
    }

    public Integer countLeaves(Node root) {
        if (Objects.isNull(root))
            return 0;

        if (root.left == null && root.right == null) {
            return 1;
        } else {
            return countLeaves(root.left) + countLeaves(root.right);
        }
    }

    public void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
