package DATA_STRUCTURE.Tree;

public class BST {
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

    node insertUtil(node n, int data) {
        if (n == null) {
            n = new node(data);
            return n;
        }

        if (data < n.data) { // if less then put it in left
            n.left = insertUtil(n.left, data);
        } else if (data > n.data) {// otherwise right
            n.right = insertUtil(n.right, data);
        }
        return n;
    }

    void insert(int data) {
        root = insertUtil(root, data);
    }

    void printInorder(node n) {
        if (n == null)
            return;
        printInorder(n.left);
        System.out.print(n.data + " ");
        printInorder(n.right);
    }

    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(20);
        bst.insert(50);
        bst.insert(10);
        bst.insert(70);
        bst.insert(30);
        bst.insert(90);

        bst.printInorder(bst.root);
    }
}
