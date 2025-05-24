import java.util.*;
public class stacks_1 {
    // implentaion of stack using LinkedList
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack1 {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;

        }

        // push
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        // POP
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack1 s = new Stack1();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
        //Stack using Collections Frame Work
       Stack<Integer> ss = new Stack<>();
       ss.push(1);
       ss.push(2);
       ss.push(3);
      while (!ss.isEmpty()) {
        System.out.println(ss.peek());
        ss.pop();
      }
    }
}
