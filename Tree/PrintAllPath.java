package DATA_STRUCTURE.Tree;

import java.util.*;

public class PrintAllPath {
    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    node root;

    node levelOrderInsertion(int arr[], int i) {
        node n = null;
        if (i < arr.length) {
            n = new node(arr[i]);
            n.left = levelOrderInsertion(arr, 2 * i + 1);
            n.right = levelOrderInsertion(arr, 2 * i + 2);
        }
        return n;
    }

    void printRootToLeafPaths(node n) {
        // list to store root-to-leaf path
        Deque<Integer> path = new ArrayDeque<>();
        printAllPathUtil(n, path);
    }

    void printAllPathUtil(node n, Deque<Integer> path) {
        if (n == null) {
            return;
        }
        path.addLast(n.data);

        if (n.right == null && n.left == null) {
            System.out.println(path);
        }

        printAllPathUtil(n.left, path);
        printAllPathUtil(n.right, path);

        path.removeLast();

    }
    // 1
    // 2 3
    // 4 5 6 8

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 8 };
        PrintAllPath n = new PrintAllPath();
        n.root = n.levelOrderInsertion(arr, 0);

        n.printRootToLeafPaths(n.root);
    }
}
