import java.util.*;
public class BST_0 {
    static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    public static Node insert(Node root , int val) {
        if (root == null) {
            root = new Node(val);
            return  root;
        }
        if (root.data > val) {
            //left subtree
            root.left = insert(root.left, val);
        } else {
            //right Subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    // To search a key
    public static boolean search(Node root , int key) { // O(H) H = height of node
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        } 
        if (root.data > key) {
            // when key is in left subtree
            return search(root.left, key);
        }
        else {
            // when key is in right subtree
            return search(root.right , key);
        }
    }
    //[Delete a node] 1.[Search] 2. [Delte with three cases]
    public static Node delete(Node root , int val) {
        // 1. Search
       if (root.data < val) {
        root.right = delete(root.right, val);
       }
        else if (root.data > val) {
            root.left = delete(root.left, val);
        }
        else {
            // 2. Delete Operation
            // Case --> 1 No Child
            if (root.right == null && root.left == null) {
                return null;
            }
            // Case ---> 2 One Child
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            // Case -->3 both child
            // why root.right bcz hamy pata hai
            //Inordersuccesor is LeftMostnode in right subtree
            Node IS = findInorder(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
       return root;

    }
    public static Node findInorder(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static void printInRange(Node root , int k1 , int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
          printInRange(root.left, k1, k2);
          System.out.print(root.data+" ");
          printInRange(root.right, k1, k2);
        }
        else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }
    public static  void printpath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+"-->");
        }
        System.out.println("Null");
    }
    public static void printRoot2Leaf(Node root , ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printpath(path);
        }
       printRoot2Leaf(root.left, path);
       printRoot2Leaf(root.right, path);
       path.remove(path.size()-1);
    }
    //Validate BST 
    public static boolean isValidateBST(Node root ,Node min , Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        else if (max != null && root.data >= max.data) {
            return false;
        }
        return isValidateBST(root.left, min, root) &&
                isValidateBST(root.right, root, max);
    }
    public static void main(String[] args) {
        // int values[] = {5,1,3,4,2,7};
        int value[] = {8 , 5 , 3 ,1 ,4 , 6 , 10 ,11 , 14};
        Node root = null;
        // here we have inser value array not values take care
        for (int i = 0; i < value.length; i++) {
            root = insert(root, value[i]);
        }
        inOrder(root);
        System.out.println();

        // if (search(root, 1)) {
        //     System.out.println("Found");
        // } else {
        //     System.out.println("Not Found");
        // }
    //  Delete Node 
    //    root = delete(root, 3);
    //   inOrder(root);

      // print in range
    //   System.out.println("ab aayega swada");
    //   printInRange(root, 5, 12);
    //   System.out.println();

    //   // print root to leaf all paths
    //   printRoot2Leaf(root, new ArrayList<>());

    //   //is valid bst or not
    //   if (isValidateBST(root, null, null)) {
    //     System.out.println("Valid BST");
    //   }
    //   else {
    //     System.out.println("Not valid BST");
    //   }
    }
}
