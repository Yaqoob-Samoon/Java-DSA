import java.util.*;

public class stacks_0 {
    // stack is data structure in which data is stored ek ke ooper ek like sets of
    // plates are arranged
    // there are three operations of stacks
    // 1.Push O(1) = here data is added outside to inside datastructure
    // 2.Pop O(1) = here data is go out from datastructure 
    // 3.peek O(1)
    // 4. is Empty tell us stack is empty or not

    // all the operation in stacks accomplished by the help of Top elemenst
    // LIFO = last in First out operations happend in stacks

    static class Stack {
        // implementation of stacks using ArrayList
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }

        public static void push(int data) {
            list.add(data);
        }

        // Pop
        public static int Pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // peek just return top
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.Pop();
        }

    }
}
