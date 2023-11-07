package zad_1_2;

import java.util.List;
import java.util.function.Consumer;

public interface AbstractBinaryTree<E> {
        E getKey();
        AbstractBinaryTree<E> getLeft();
        AbstractBinaryTree<E> getRight();
        void setKey(E key);
        String asIndented(int indent);
        List<AbstractBinaryTree<E>> inOrder();
        List<AbstractBinaryTree<E>> preOrder();
        List<AbstractBinaryTree<E>> postOrder();
        void forEachInOrder(Consumer<E> consumer);
}