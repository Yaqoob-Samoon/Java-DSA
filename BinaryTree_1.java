import java.util.*;
public class BinaryTree_1 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHight = height(root.right);

       return  Math.max(leftHeight, rightHight)+1;
    }
    //Total Count of Nodes
    public static int countOfTree(Node root) { //TC O(n)
        if (root == null) {
            return 0;
        }
        int leftCount = countOfTree(root.left);
        int rightCount = countOfTree(root.right);
        int totalCount = leftCount + rightCount + 1;
        return totalCount;
    }
    //Total sum of Nodes in tree
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;

    }
    //Approach 1 with bad time complexity to find diametere
    public static int diameter(Node root){ // TC = O(n^2)
        if (root == null) {
            return 0;
        }
        int leftDiam = diameter(root.left);
        int leftHight = height(root.left);
        int rightDiam = diameter(root.right);
        int rightHight = height(root.right);

        int selfDiam = leftHight +rightHight + 1;
       return  Math.max(selfDiam , Math.max(leftDiam,rightDiam));
    }
    //Aproach 2 with good time complexity to find diametere
    static class Info { 
        int diameter;
        int height;
        public Info(int diameter , int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
    public static Info findDiameter(Node root){ //TC = (n)
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = findDiameter(root.left);
        Info rightInfo = findDiameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        return new Info(diam, height);
    }

    public static boolean isIdentical(Node node , Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        else if (node == null || subRoot == null) {
            return false;
        }
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root , Node subRoot) {
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root , subRoot)) {
                return true;
            }
        }
        boolean leftAns = isSubtree(root.left, subRoot);
        boolean rightAns = isSubtree(root.right, subRoot);

        return leftAns || rightAns;
        
    }


    //Top View  problem
    static class Info1 {
        Node node;
        //hd = horizontall diagram
        int hd;

        public Info1(Node node , int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root) {
        Queue<Info1> q = new LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();
        int min = 0 , max=0;
        q.add(new Info1(root,0));
        q.add(null);
        while (!q.isEmpty()) {
            Info1 curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            }
            
           else {
            if (!map.containsKey(curr.hd)) { // first time my hd is ocurring
                map.put(curr.hd, curr.node);
            }
            if (curr.node.left != null) {
                q.add(new Info1(curr.node.left, curr.hd-1));
                min = Math.min(min, curr.hd-1);
            }
            if (curr.node.right != null) {
                q.add(new Info1(curr.node.right, curr.hd+1));
                max = Math.max(max, curr.hd+1);
            }
           }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data+" ");
        }
        System.out.println();
    }
    public static void Klevel(Node root , int level , int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data+" ");
           return;
        }
        Klevel(root.left, level+1, k);
        Klevel(root.right, level+1, k);
    }

    public static boolean getPath(Node root , int n , ArrayList<Node> path) {
        if (root == null ) {
           return false; 
        }
        path.add(root);

        if (root.data == n) {
            return true;
        }
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        if (foundLeft || foundRight) {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    //Lowest Common Ancesstor; Approach 1 bad SC bcz two arraylist seprately are used
    public static Node lca(Node root , int n1 , int n2) { // TC = O(n)  && SC = O (n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last Common Ancesstor
        int i = 0;
        for (; i < path1.size()&& i<path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
           
        }
         // last equal Node --> i-1th
         Node lca = path1.get(i-1);
         return lca;
    }
    //Lowest Common Ancesstor; Approach 2 with good SC and same TC

    public static Node lca2(Node root , int n1 , int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        // calculating lca i right and left children
        Node leftlca = lca2(root.left, n1, n2);
        Node rightlca = lca2(root.right, n1, n2);

        // Case jahn pe left main hee donon values exist kertii hain or right main nahii hai = null
        if (rightlca == null) {
            return leftlca;
        }
        // Case jahn pe right main hee donon values exist kertii hain or left main nahii hai = null
        if (leftlca == null) {
            return rightlca;
        }

        return root;
    }

    public static int lcaDist(Node root , int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist ==-1) {
            return rightDist +1;
        }
        else {
            return leftDist + 1;
        }
    }
    public static int minDist (Node root , int n1 , int n2) {
        // here we will find lowesr common ancesstor
        Node lca = lca2(root, n1, n2);
        // than distance of both numbers till root
        int dist1 = lcaDist(root, n1);
       int  dist2 = lcaDist(root, n2);

       return dist1 + dist2;
    }
    //kth Ancesstor means in main function value of k will be declared e.h int k = 2 and n =5;
    // it means second ancesstor/parent of 5 but this  int k= 1 and n = 5;
    // means first parent/ancesstor of 5
    public static int kAnccestor(Node root , int n ,int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftDist = kAnccestor(root.left, n, k);
        int rightDist = kAnccestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }
        int max = Math.max(leftDist, rightDist);
        if (max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int transformSumtree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftChild = transformSumtree(root.left);
        int rightChild = transformSumtree(root.right);

        int data = root.data;
        int newleft = root.left == null ? 0:root.left.data;
        int newRight = root.right == null ? 0 : root.right.data; 
        root.data =  newleft + leftChild + newRight + rightChild;
        return data;
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
            1
            / \
            2   3
            /\  /\
            4 5 6 7
         */

         //SubTree
         /*
             2
            / \
           4   5

          */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        System.out.println(isSubtree(subRoot, subRoot));
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("height of my tree"+height(root));
        System.out.println("Total Count of tree"+countOfTree(root));
        System.out.println("Sum of root = "+sum(root));
        System.out.println(diameter(root));
        //Diameter and height both can be calculated by this method-----
        System.out.println(findDiameter(root).diameter);
        System.out.println(findDiameter(root).height);

        //Top View
        topView(root);
        //K level
        int k = 1;
        Klevel(root, 1, k);
        System.out.println();
        //Lowest Common Ancesstor
        int n1 = 4 , n2 = 5;
        System.out.println(lca(root, n1, n2).data+" Approach one");
        System.out.println(lca2(root, n1, n2).data+"Approach two");
        System.out.println(minDist(root, n1, n2)+" This is minimum distance between these two nodes"+n1 +" "+ n2);

       //KAncesstor
       kAnccestor(root, n2, k);
        //Tree
        /*
            1
            / \
            2   3
            /\  /\
            4 5 6 7
         */
        //Transform to Sum Tree Expected tree is :
        /*
            27
            /  \
           9    13
          / \   / \ 
          0  0  0 0
        */ 
        transformSumtree(root);
        preOrder(root);
 
    }
}
