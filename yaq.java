import java.util.*;

public class yaq {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;

    public void addList(int data) { 
        Node newNode = new Node(data);
        
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public static void sorting() {
         int count = 0;
        Node temp = head;

        // Count the number of nodes in the linked list
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Length Of Linked List: " + count);

        // Bubble sort implementation
        for (int i = 0; i < count; i++) {
            // ye current elemnt jo check hoga isky adjacent element se next se
            Node current = head;
            Node next = current.next;
            for (int j = 0; j < count - i - 1; j++) {
                if (current.data > next.data) {
                    // Swap the data
                    int swap = current.data;
                    current.data = next.data;
                    next.data = swap;
                }
            
                current = next;
                next = next.next;
            }
        }

        System.out.println("Sorted Linked List:");
        Node print = head;
        while (print != null) {
            System.out.print(print.data + " ");
            print = print.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        yaq ll = new yaq();
        ll.addList(5);
        ll.addList(2);
        ll.addList(3);
        ll.addList(1);
        ll.addList(4);

        sorting();
    }
}