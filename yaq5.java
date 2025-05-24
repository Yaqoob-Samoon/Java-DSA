import java.util.ArrayList;
import java.util.List;

class yaq5 {
    // Class representing a tree node
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of the BST
    Node root;

    // Constructor
    yaq5() {
        root = null;
    }

    // Method to insert a new key
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        } // Otherwise, recur down the tree
        
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        // return the (unchanged) node pointer
        return root;
    }

    // Method to search a key in the BST
    boolean search(int key) {
        return searchRec(root, key);
    }

    // A recursive function to search a key in BST
    boolean searchRec(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root != null;
        // Key is greater than root's key
        if (root.key < key)
            return searchRec(root.right, key);
        // Key is smaller than root's key
        return searchRec(root.left, key);
    }

    // Method to find the index of a key in in-order traversal
    int findIndex(int key) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrderToList(root, inOrderList);
        return inOrderList.indexOf(key);
    }

    // Helper method to perform in-order traversal and store elements in a list
    void inOrderToList(Node node, List<Integer> list) {
        if (node != null) {
            inOrderToList(node.left, list);
            list.add(node.key);
            inOrderToList(node.right, list);
        }
    }

    // This method mainly calls inOrderRec()
    void inOrder() {
        inOrderRec(root);
    }

    // A utility function to do in-order traversal of BST
    void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    public static void main(String[] args) {
        yaq5 tree = new yaq5();

        // Insert values
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print in-order traversal
        System.out.println("In-order traversal:");
        tree.inOrder();

        // Search for a value
        System.out.println("\n\nSearch for 40: " + tree.search(40));
        System.out.println("Search for 90: " + tree.search(90));

        // Find index of a value
        System.out.println("\nIndex of 40: " + tree.findIndex(40));
        System.out.println("Index of 60: " + tree.findIndex(60));
        System.out.println("Index of 80: " + tree.findIndex(80));
    }
}
