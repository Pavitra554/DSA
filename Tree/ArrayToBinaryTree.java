package DATA_STRUCTURE.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ArrayToBinaryTree {
    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    node root;

    void printInorder(node n) {
        if (n == null)
            return;
        printInorder(n.left);
        System.out.print(n.data + " ");
        printInorder(n.right);
    }

    void printPreOrder(node n) {
        if (n == null)
            return;
        System.out.print(n.data + " ");
        printPreOrder(n.left);
        printPreOrder(n.right);
    }

    void printPostOrder(node n) {
        if (n == null)
            return;
        printPostOrder(n.left);
        printPostOrder(n.right);
        System.out.print(n.data + " ");
    }

    void printLevelOrder(node n) {
        Queue<node> q = new LinkedList<node>();
        if (n == null)
            return;
        q.add(n);
        while (!q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                node temp = q.remove();
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
    }

    public node levelOrderInsertion(int[] arr, int i) {
        node n = null;
        if (i < arr.length) {
            // root node i-1/2
            n = new node(arr[i]);

            // left node 2*1+1
            n.left = levelOrderInsertion(arr, 2 * i + 1);

            // right node 2*i+2
            n.right = levelOrderInsertion(arr, 2 * i + 2);

        }
        return n;
    }

    // Tree
    // 10
    // / \
    // 20 30
    // / \ / \
    // 40 50 60 70
    public static void main(String[] args) {
        ArrayToBinaryTree tobt = new ArrayToBinaryTree();
        int arr[] = { 10, 20, 30, 40, 50, 60, 70 };
        tobt.root = tobt.levelOrderInsertion(arr, 0);
        tobt.printInorder(tobt.root);
        System.out.println();
        tobt.printPreOrder(tobt.root);
        System.out.println();
        tobt.printPostOrder(tobt.root);
        System.out.println();
        tobt.printLevelOrder(tobt.root);

    }
}
