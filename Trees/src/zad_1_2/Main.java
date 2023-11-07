package zad_1_2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BinaryTree<Integer> node1 = new BinaryTree<>(1);
        BinaryTree<Integer> node3 = new BinaryTree<>(3);
        BinaryTree<Integer> node5 = new BinaryTree<>(5);
        BinaryTree<Integer> node7 = new BinaryTree<>(7);
        BinaryTree<Integer> node2 = new BinaryTree<>(2);
        BinaryTree<Integer> node6 = new BinaryTree<>(6);
        BinaryTree<Integer> node4 = new BinaryTree<>(4);

        node4.setLeft(node2);
        node4.setRight(node6);
        node2.setLeft(node1);
        node2.setRight(node3);
        node6.setLeft(node5);
        node6.setRight(node7);

        BinaryTree<Integer> root = node4;

        System.out.println("In order:");
        List<AbstractBinaryTree<Integer>> inOrder = root.inOrder();
        for (AbstractBinaryTree<Integer> node : inOrder) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("Pre order(DFS):");
        List<AbstractBinaryTree<Integer>> preOrder = root.preOrder();
        for (AbstractBinaryTree<Integer> node : preOrder) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("Post order:");
        List<AbstractBinaryTree<Integer>> postOrder = root.postOrder();
        for (AbstractBinaryTree<Integer> node : postOrder) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("Level order(BFS)");
        List<AbstractBinaryTree<Integer>> levelOrder = root.levelOrder();
        for (AbstractBinaryTree<Integer> node : levelOrder) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("Елочка (InOrder):");
        String treeStructureInOrder = root.asIndentedInOrder(0);
        System.out.println(treeStructureInOrder);

        System.out.println("Елочка (PreOrder DFS):");
        String treeStructurePreOrder = root.asIndentedPreOrder(0);
        System.out.println(treeStructurePreOrder);

        System.out.println("Елочка (PostOrder BFS):");
        String treeStructurePostOrder = root.asIndentedPostOrder(0);
        System.out.println(treeStructurePostOrder);
    }
}