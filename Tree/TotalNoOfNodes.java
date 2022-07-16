package DATA_STRUCTURE.Tree;

public class TotalNoOfNodes {
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

    // Counting all nodes in tree
    void countNode(node n, int[] c) {
        if (n == null)
            return;
        c[0]++;
        countNode(n.left, c);
        countNode(n.right, c);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        TotalNoOfNodes n = new TotalNoOfNodes();
        n.root = n.levelOrderInsertion(arr, 0);

        int c[] = new int[1];
        n.countNode(n.root, c);
        System.out.println("Total no. of nodes " + c[0]);
    }
}
