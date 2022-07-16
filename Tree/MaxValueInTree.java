package DATA_STRUCTURE.Tree;

public class MaxValueInTree {
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
    void maxValue(node n, int c[]) {
        if (n == null)
            return;
        if (n.data > c[0]) {
            c[0] = n.data;
        }
        maxValue(n.left, c);
        maxValue(n.right, c);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };

        MaxValueInTree n = new MaxValueInTree();
        n.root = n.levelOrderInsertion(arr, 0);

        int c[] = new int[1];
        n.maxValue(n.root, c);
        System.out.println();
        System.out.println("Maximum Value : " + c[0]);

    }
}
