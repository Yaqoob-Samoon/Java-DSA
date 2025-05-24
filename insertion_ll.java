import java.util.*;

public class insertion_ll {
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
        Node sorted = null; 
        Node current = head;

        while (current != null) {
            Node next = current.next; // Store next node
            sorted = insertSorted(sorted, current); // Insert current in sorted list
            current = next; // Move to the next node
        }

        head = sorted; // Update head to the sorted list

        System.out.println("Sorted Linked List:");
        Node print = head;
        while (print != null) {
            System.out.print(print.data + " ");
            print = print.next;
        }
        System.out.println();
    }

    private static Node insertSorted(Node sorted, Node newNode) {
        if (sorted == null || sorted.data >= newNode.data) {
            newNode.next = sorted;
            return newNode;
        } else {
            Node current = sorted;
            while (current.next != null && current.next.data < newNode.data) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        return sorted;
    }

    public static void main(String[] args) {
        insertion_ll ll = new insertion_ll();
        ll.addList(5);
        ll.addList(2);
        ll.addList(3);
        ll.addList(1);
        ll.addList(4);

        sorting();
    }
}