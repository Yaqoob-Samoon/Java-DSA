// Node class to create nodes of the binary tree
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BinaryTree class to perform operations on the binary tree
class BinaryTree {
    Node root;

    // Constructor to initialize the root node
    public BinaryTree() {
        root = null;
    }

    // Method to traverse the tree in in-order fashion
    public void traverseTree(Node node) {
        if (node != null) {
            traverseTree(node.left);
            System.out.print(node.key + " ");
            traverseTree(node.right);
        }
    }

    public static void main(String[] args) {
        // Create an object of BinaryTree
        BinaryTree tree = new BinaryTree();

        // Create nodes of the tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);

        System.out.print("Binary Tree: ");
        tree.traverseTree(tree.root);
    }
}
