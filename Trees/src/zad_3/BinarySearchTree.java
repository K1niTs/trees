package zad_3;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;
    public BinarySearchTree() {
        root = null;
    }
    @Override
    public void insert(E element) {
        root = insertRec(root, element);
    }
    private Node<E> insertRec(Node<E> node, E element) {
        if (node == null) {
            return new Node<>(element);
        }
        if (element.compareTo(node.value) < 0) {
            node.leftChild = insertRec(node.leftChild, element);
        } else if (element.compareTo(node.value) > 0) {
            node.rightChild = insertRec(node.rightChild, element);
        }
        return node;
    }
    @Override
    public boolean contains(E element) {
        return containsRec(root, element);
    }
    private boolean containsRec(Node<E> node, E element) {
        if (node == null) {
            return false;
        }
        if (element.equals(node.value)) {
            return true;
        }
        if (element.compareTo(node.value) < 0) {
            return containsRec(node.leftChild, element);
        } else {
            return containsRec(node.rightChild, element);
        }
    }
    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> result = searchRec(root, element);
        if (result == null) {
            return new BinarySearchTree<E>();
        } else {
            BinarySearchTree<E> searchTree = new BinarySearchTree<>();
            searchTree.root = result;
            return searchTree;
        }
    }
    private Node<E> searchRec(Node<E> node, E element) {
        if (node == null || element.equals(node.value)) {
            return node;
        }
        if (element.compareTo(node.value) < 0) {
            return searchRec(node.leftChild, element);
        } else {
            return searchRec(node.rightChild, element);
        }
    }
    @Override
    public Node<E> getRoot() {
        return root;
    }
    @Override
    public Node<E> getLeft() {
        if (root != null && root.leftChild != null) {
            return root.leftChild;
        }
        return null;
    }
    @Override
    public Node<E> getRight() {
        if (root != null && root.rightChild != null) {
            return root.rightChild;
        }
        return null;
    }
    @Override
    public E getValue() {
        if (root != null) {
            return root.value;
        }
        return null;
    }
    public void printLevelOrder() {
        if (root == null) {
            return;
        }
        Queue<Node<E>> queue = new LinkedList<>();
        Queue<Integer> levels = new LinkedList<>();
        queue.add(root);
        levels.add(0);

        int currentLevel = 0;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            int level = levels.poll();

            if (level > currentLevel) {
                System.out.println();
                currentLevel = level; }
            for (int i = 0; i < (1 << (treeHeight() - level)) - 1; i++) {
                System.out.print("   " ); }
            System.out.print(node.value + " ");
            if (node.leftChild != null) {
                queue.add(node.leftChild);
                levels.add(level + 1); }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
                levels.add(level + 1);
            }
        }
    }
    private int treeHeight() {
        return treeHeight(root); }
    private int treeHeight(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = treeHeight(node.leftChild);
            int rightHeight = treeHeight(node.rightChild);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    public static void main(String[] args) {
        BinarySearchTree<Character> tree = new BinarySearchTree<>();
        tree.insert('F');
        tree.insert('D');
        tree.insert('J');
        tree.insert('B');
        tree.insert('E');
        tree.insert('G');
        tree.insert('K');
        tree.insert('A');
        tree.insert('C');
        tree.insert('I');

        System.out.println("Бинарный поиск элементов (дерево):");
        tree.printLevelOrder();
    }
}
