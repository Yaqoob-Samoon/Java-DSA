import java.util.*;
public class stacks_5 {
    public static void displayRec(Stack<Integer> st) {
        if (st.isEmpty()) {
            return;
        }
        int top = st.pop();
        System.out.print(top+" ");
        displayRec(st);
        st.push(top);
    }
    public static void reversingArray() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s);
        Stack<Integer> s1 = new Stack<>();
        while (s.size() > 0) {
            s1.push(s.pop());
        }
        System.out.println(s1);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
    System.out.println(s);
    // displayRec(s);
    // System.out.println(s);

    }
}
