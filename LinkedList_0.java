import java.util.*;
public class LinkedList_0 {
    // defining head and tail and size
    public static Node head;
    public static Node tail;
    public static int size;
    // single Node will be created when object of this class has been created
    public static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void addFirst(int data) { //TC = O(1) Constant time
        //Step--->1 to Create a Node
        Node newNode = new Node(data);
        size++;
        //check if Node is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //Step--->2 Create link = newNode.next = head
        newNode.next = head;
        //Step ---->3  exchange value of head into newNode
        head = newNode;

    }
    public void addLast(int data) { //TimeComplexity Constant O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
       tail.next = newNode;
       tail = newNode;
    }

    public void print() { // Linear Time Complexity O(n)
        if (head == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public void addMidd(int idx , int data) {
        if (idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx-1) {
            temp = temp.next;
            i++;
        }
        // i = idx -1; temp-->prev
        newNode.next = temp.next;
        temp.next = newNode;

    }
    public int removeFirst() {
        if (size == 0) {
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val =head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }
    public int removeLast() {
        if (size == 0) {
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val =head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
       for(int i =0; i<size-2;i++) {
        prev = prev.next;
       }
        int val =prev.next.data;
        prev.next = null;
        tail = prev;
        return val;
    }
    public int iterativeSearch(int key){

        Node temp = head;
        int i = 0;
        while (temp !=null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }
    public int helper(Node head , int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx+1;
    }
    public int recursiveSearch(int key) {
        return helper(head , key);
    }
    public void reverse(){
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
           next = curr.next;
           curr.next = prev;
           prev = curr;
           curr = next;
        }
        head = prev;

    }
    public void deleteNthfromEnd(int n) {
        //calculate size
        int siz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            siz++;
        }
        // if you want to delete head than from last n == siz 
        if (n == siz) {
            head = head.next; // remove head condition
            return;
        } 
        // baqii condition main siz-n tak ajana hai
        int i = 1;
        int iToFind = siz-n;
        Node prev = head;
        while (i < iToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    }

    //Pallindrome Code
    //step1 findMid with slow and fast technique
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next !=null) {
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; // slow is my midNode
    }

    public boolean checkPallindrome() {
        //checking linkedlist is empty or have only one element?
        if (head == null && head.next == null) {
            return true;
        }
        // step -->1 find Mid
        Node midNode = findMid(head);

        //Step-->2  reverse 2and half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while ( curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; // right half ka head
        Node left = head; // left half ka head wahii head hoga


        //step--->3 check left half and right half for pallindrome
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Cycle exist
            }
        }
        return false; // cycle doesn`t exist
    }

    // Remove Cycle from LinkedList
    public static void removeCycle() {
        // detect Cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
               cycle  = true;
               break;
            }
        }
        if (cycle == false) {
            return;
        }

        //Find Meeting point
        slow = head;
        Node prev = null; // when loop will end in prev last node will be stored fast = slow  jis point  pe hoga uss se ek node pele wala
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        //remove cycle -->last.next = null
        prev.next = null;
    }
    // find mid function
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1 , Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data ) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while (head1 != null) {
            temp.next= head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }
    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);
        Node rightHead = mid.next;
        mid.next = null;
         //left and right Merge Sort call

        //call for left part
        Node newLeft = mergeSort(head);
        //call for right half
        Node newRight = mergeSort(rightHead);
       

        // merge left + right
        return merge(newLeft , newRight);
    }

    public void zigzag() {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse a 2and half
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node leftH = head;
        Node rightH = prev;
        Node nextL , nextR;

        //alternative merging || zigzag merging
        while (leftH != null && rightH != null) {
            nextL = leftH.next;
            leftH.next = rightH;
           nextR = rightH.next;
           rightH.next = nextL; 


        leftH = nextL;
        rightH = nextR;
        }
  }

    
    public static void main(String[] args) {
        LinkedList_0 ll = new LinkedList_0();
        // First Method to add remove Second Method is to create Functions that is more apropriate method
        // ll.head = new Node(1);
        // ll.head.next = new Node(2);
       

        // ll.addFirst(2);
        // ll.addFirst(1);
        // ll.addLast(3);
        // ll.addLast(4);
        // ll.addLast(5);
        // ll.addMidd(2, 0);
        // ll.addMidd(2, 6);
        // ll.print();
        // ll.reverse();
        // ll.print();
        // ll.deleteNthfromEnd(3);
        // ll.print();
        // linked list onlyr for checking pallindrome
        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.print();
        // System.out.println(ll.checkPallindrome());

        // Linked List for checking isCycle Code
    //     head = new Node(1);
    //     Node temp = new Node(2);
    //     head.next = temp;
    //     head.next.next = new Node(3);
    //     head.next.next.next = temp;
    //    System.out.println(isCycle());
    //    removeCycle();
    //    System.out.println(isCycle());

    //zigzag 
    // ll.addLast(1);
    // ll.addLast(2);
    // ll.addLast(3);
    // ll.addLast(4);
    // ll.addLast(5);
    // ll.addLast(6);
    // ll.print();
    // ll.zigzag();
    // ll.print();

    //mergeSort
    ll.addFirst(1);
    ll.addFirst(2);
    ll.addFirst(3);
    ll.addFirst(4);
    ll.addFirst(5);
        ll.print();
       ll.head = ll.mergeSort(ll.head);
       ll.print();
            
        
       
    }
}
