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

    // Or Depth (Maximum)
    public Integer findHeight(Node root) {
        if (Objects.isNull(root)) return 0;

        return Math.max(findHeight(root.left), findHeight(root.right)) + 1;
    }

    // Or Depth
    public Integer minHeight(Node root) {
        if (Objects.isNull(root)) return 0;

        // If the node is a leaf node
        if (root.left == null && root.right == null) return 1;

        // If the left subtree is null, we need to consider the right subtree only
        if (root.left == null) return minHeight(root.right) + 1;

            // If the right subtree is null, we need to consider the left subtree only
        else if (root.right == null) return minHeight(root.left) + 1;

        // If both subtrees are present, return the minimum depth of both subtrees + 1
        return Math.min(minHeight(root.left), minHeight(root.right)) + 1;
    }

    public Boolean hasPathSum(Node root, Integer target) {
        if (Objects.isNull(root)) return false;

        if (Objects.isNull(root.left) && Objects.isNull(root.right)) return Objects.equals(root.data, target);

        int newTarget = target - root.data;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
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

    @SuppressWarnings("unused")
    private boolean areTwoTreesSame(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (!Objects.equals(root1.data, root2.data)) return false;

        return areTwoTreesSame(root1.left, root2.left) && areTwoTreesSame(root1.right, root2.right);
    }

    @SuppressWarnings("unused")
    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        return checkIfSymmetric(root.left, root.right);
    }

    public int sumOfLeftLeaves(Node root) {
        if (Objects.isNull(root)) return 0;
        if (Objects.nonNull(root.left) && Objects.isNull(root.left.left) && Objects.isNull(root.left.right)) {
            return root.left.data + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private static boolean checkIfSymmetric(Node left, Node right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;

        return Objects.equals(left.data, right.data) &&
                checkIfSymmetric(left.left, right.right) &&
                checkIfSymmetric(right.left, left.right);
    }
}
