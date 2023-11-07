package zad_1_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    public BinaryTree(E key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }

    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return left;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return right;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    public void setLeft(AbstractBinaryTree<E> left) {
        this.left = (BinaryTree<E>) left;
    }

    public void setRight(AbstractBinaryTree<E> right) {
        this.right = (BinaryTree<E>) right;
    }

    @Override
    public String asIndented(int indent) {
        StringBuilder result = new StringBuilder();
        String indentation = "  ".repeat(indent);
        result.append(indentation).append(key).append("\n");

        if (left != null) {
            result.append(left.asIndented(indent + 1));
        }
        if (right != null) {
            result.append(right.asIndented(indent + 1));
        }

        return result.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(left.inOrder());
        }
        result.add(this);
        if (right != null) {
            result.addAll(right.inOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);
        if (left != null) {
            result.addAll(left.preOrder());
        }
        if (right != null) {
            result.addAll(right.preOrder());
        }
        return result;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (left != null) {
            result.addAll(left.postOrder());
        }
        if (right != null) {
            result.addAll(right.postOrder());
        }
        result.add(this);
        return result;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (left != null) {
            left.forEachInOrder(consumer);
        }
        consumer.accept(key);
        if (right != null) {
            right.forEachInOrder(consumer);
        }
    }

    public List<AbstractBinaryTree<E>> levelOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        Queue<AbstractBinaryTree<E>> queue = new LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            AbstractBinaryTree<E> node = queue.poll();
            if (node != null) {
                result.add(node);
                queue.offer(node.getLeft());
                queue.offer(node.getRight());
            }
        }

        return result;
    }
    public String asIndentedInOrder(int indent) {
        StringBuilder result = new StringBuilder();
        String indentation = "  ".repeat(indent);

        if (left != null) {
            result.append(left.asIndentedInOrder(indent + 1));
        }
        result.append(indentation).append(key).append("\n");
        if (right != null) {
            result.append(right.asIndentedInOrder(indent + 1));
        }

        return result.toString();
    }

    public String asIndentedPreOrder(int indent) {
        StringBuilder result = new StringBuilder();
        String indentation = "  ".repeat(indent);
        result.append(indentation).append(key).append("\n");

        if (left != null) {
            result.append(left.asIndentedPreOrder(indent + 1));
        }
        if (right != null) {
            result.append(right.asIndentedPreOrder(indent + 1));
        }

        return result.toString();
    }

    public String asIndentedPostOrder(int indent) {
        StringBuilder result = new StringBuilder();
        String indentation = "  ".repeat(indent);

        if (left != null) {
            result.append(left.asIndentedPostOrder(indent + 1));
        }
        if (right != null) {
            result.append(right.asIndentedPostOrder(indent + 1));
        }

        result.append(indentation).append(key).append("\n");

        return result.toString();
    }

}