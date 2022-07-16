package DATA_STRUCTURE.Tree;

public class TotalLeafNode {
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

    node levelOrderInsertion(int arr[], int i) {
        node n = null;
        if (i < arr.length) {
            n = new node(arr[i]);
            n.left = levelOrderInsertion(arr, 2 * i + 1);
            n.right = levelOrderInsertion(arr, 2 * i + 2);
        }
        return n;
    }

    // Counting all leaf nodes in tree
    void countLeaf(node n, int c[]) {
        if (n == null)
            return;
        if (n.left == null && n.right == null) {
            System.out.print(" " + n.data);
            c[0]++;
        }
        countLeaf(n.left, c);
        countLeaf(n.right, c);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        TotalLeafNode n = new TotalLeafNode();
        n.root = n.levelOrderInsertion(arr, 0);

        int c[] = new int[1];
        System.out.println("All leaf nodes...");
        n.countLeaf(n.root, c);
        System.out.println();
        System.out.println("Total leaf nodes : " + c[0]);

    }
}
