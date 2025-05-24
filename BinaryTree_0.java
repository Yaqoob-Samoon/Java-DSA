import java.util.*;

public class BinaryTree_0 {
    static class Node {
        int data;
        // left and right child
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree {//TCO(n)
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
         }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
        //preorder Traversal
        public static void preorder(Node root) { // TC O(n)
            if (root == null) {
                // System.out.print("-1"+" "); // if you want to print null value also -1
                return;
            }
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
        //Inorder Traversal
        public static void inorder(Node root) {
            if (root== null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
        //postorder traversal
        public static void postorder (Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
        //Level Order Traversal asked in Microsoft
        public static void Levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data+" ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    } if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }
    }        
    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(node);
        // System.out.println(root.data);

       tree.preorder(root);
       System.out.println();
       tree.inorder(root);
       System.out.println();
       tree.postorder(root);
       System.out.println();
       tree.Levelorder(root);
       
    }
}
