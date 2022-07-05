package DATA_STRUCTURE.Tree;

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

    public static void main(String[] args) {
        ArrayToBinaryTree tobt = new ArrayToBinaryTree();
        int arr[] = { 10, 20, 30, 40, 50, 60, 70 };
        tobt.root = tobt.levelOrderInsertion(arr, 0);
        tobt.printInorder(tobt.root);

    }
}
