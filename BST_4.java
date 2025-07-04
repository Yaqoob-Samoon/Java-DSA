import java.util.*;
public class BST_4 {
    static class  Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void getinOrder(Node root , ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        getinOrder(root.left, arr);
        arr.add(root.data);
        getinOrder(root.right, arr);
    }
    public static Node creatBST(ArrayList<Integer> arr , int st , int end ) {
        if (st > end) {
            return null;
        }
        int mid = (st + end)/2;
        Node root = new Node(arr.get(mid));
        root.left = creatBST(arr, st, mid-1);
        root.right = creatBST(arr, mid+1, end);
        return root;
    }
    public static Node mergeBSTs(Node root1 , Node root2) {//TC O(n)

        // step 1 get inorder of Both BSTs
        ArrayList<Integer> arr1 = new ArrayList<>();
        getinOrder(root1, arr1);
        // Inorder of BST 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getinOrder(root2, arr2);

        //nOW TO MERGE
        int i = 0 , j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while (i<arr1.size() && j < arr2.size()) {
            if (arr1.get(i)<= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while (i<arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }
        while (j<arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }
        //Sorted Array to Balanced BST
       return creatBST(finalArr, 0, finalArr.size()-1);
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
        /*
                  2
                /   \
               1      4
               BST 1
         */
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
         /*
                   9
                 /  \
                3    12
                BST 2 
          */
          Node root2 = new Node(9);
          root2.left = new Node(3);
          root2.right = new Node(12);

          /*
                     3
                   /   \
                  1      9
                  \     /  \
                   2    4    12

                   Final ans :BST
           */
          Node root = mergeBSTs(root1, root2);
          preOrder(root); 
    }
}
