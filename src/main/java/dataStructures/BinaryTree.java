package dataStructures;


import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    private Node root;

    private void validateValue(Integer value) {
        if (value == null)
            throw new IllegalArgumentException();
    }

    public void add(Integer value) {
        validateValue(value);
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node currentRoot, Integer value) {
        if (currentRoot == null) {
            return new Node(value);
        }

        if (currentRoot.value > value) {
            currentRoot.left = addRecursive(currentRoot.left, value);
        }
        else if (currentRoot.value < value) {
            currentRoot.right = addRecursive(currentRoot.right, value);
        }
        return currentRoot;
    }

    public boolean contains(Integer value) {
        validateValue(value);
        return findRecursive(root, value);
    }

    private Boolean findRecursive(Node currentRoot, Integer value) {
        if (currentRoot == null)
            return false;

        if (currentRoot.value.equals(value))
            return true;

        return value < currentRoot.value
                ? findRecursive(currentRoot.left, value)
                : findRecursive(currentRoot.right, value);
    }

    public void delete(Integer value) {
        validateValue(value);
        if (contains(value))
            root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node current, Integer value) {
        if (current == null) {
            return null;
        }

        if (value.equals(current.value)) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }

        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public List<Node> traverse() {
        List<Node> nodes = new ArrayList<>();
        traverseRecursive(root, nodes);
        return nodes;
    }

    private void traverseRecursive(Node node, List<Node> nodes) {
        if (node != null) {
            traverseRecursive(node.left, nodes);
            nodes.add(node);
            traverseRecursive(node.right, nodes);
        }
    }

    public int size() {
        return getSizeRecursive(this.root);
    }

    private int getSizeRecursive(Node node) {
        if(node == null){
            return 0;
        }

        return 1 + getSizeRecursive(node.left) + getSizeRecursive(node.right);
    }

    static class Node {
        private Node left;
        private Node right;
        private Integer value;

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}


