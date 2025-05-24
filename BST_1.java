public class BST_1 {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static Node createMirror(Node root){
        if (root == null) {
            return null;
        }
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);
        // SubTree shuffled
        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {

        //ORIGINAL TREE
        /*  
                8
               / \
              5   10
             / \    \
            3   6    11

         */
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);

        //Mirror tree
        /*
              8  
             / \
            10   5
            /    / \
          11    6   3
         */
        root = createMirror(root);
        preOrder(root);
    }
}
