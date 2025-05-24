import java.util.Deque;
import java.util.LinkedList;

public class Queue_Question6 {
    static class Stack {
        Deque <Integer> deque = new LinkedList<>();   

        public void push(int data) {
            deque.addLast(data);
        }
        public int pop() {
            return deque.removeLast();
        }
        public int peek() {
            return deque.getLast();
        }
    }
    static class Queue {
        Deque <Integer> deque1 = new LinkedList<>();
        public void add(int data) {
            deque1.addLast(data);
        }
        public int remove() {
            return deque1.removeFirst();
        }
        public int peek() {
            return deque1.getFirst();
        }
     }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Peek ="+ s.peek());
       System.out.println(s.pop());
       System.out.println(s.pop());
       System.out.println(s.pop());

        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
