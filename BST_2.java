import java.util.*;
public class BST_2 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static Node createBST(int arr[] , int start , int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, start, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }

    public static void getinOrder(Node root , ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getinOrder(root.left, inorder);
        inorder.add(root.data);
        getinOrder(root.right, inorder);
    }
    public static Node createBST(ArrayList<Integer> inorder , int st , int end) { // TC O(n)
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root;
    }
    public static Node balancedBST(Node root) {
        //step --> 1 In order sequence
        ArrayList<Integer> inorder = new ArrayList<>();
        getinOrder(root, inorder);

        //sorted inorder arraylist ---> Balanced BST
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }
    public static void main(String[] args) {
        int arr[] = {3, 5 , 6 , 8 , 10 , 11 , 12};
        //BST should be like this
        /*  
                8
               / \
              5   11
             / \   / \
            3   6  10  12

         */
        Node root1 = createBST(arr, 0, arr.length-1);
        preOrder(root1);

        //Given BST
        /*  
                8
               / \
              6   10
             /     \
            5      11
           /          \
          3            12 
         */

         Node root = new Node(8);
         root.left = new Node(6);
         root.left.left = new Node(5);
         root.left.left.left = new Node(3);

         root.right = new Node(10);
         root.right.right = new Node(11);
         root.right.right.right = new Node(12);

        // Expected BST
         /*  
                8
               / \
              5   11
             / \   / \
            3   6 10  12

         */
     root =  balancedBST(root);
      preOrder(root);
    }
}
