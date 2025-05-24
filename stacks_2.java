import java.util.*;

public class stacks_2 {
    // Question asked in amazon
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // Question asked in Microsoft / paytm /flipkart / adobe
    public static String reverseString(String str) {

        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return str = result.toString();
    }
//Question asked in amdocs 
//Reverse a Stack
public static void reverseStack(Stack<Integer> s) {

    if (s.isEmpty()) {
        return;
    }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);

}
public static void printStack(Stack<Integer> s) {
    while (!s.isEmpty()) {
        System.out.print(s.pop()+" ");
    }
}
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // pushAtBottom(s, 4);
        // while (!s.isEmpty()) {
        //     System.out.println(s.pop());

        // }
        // Stack<String> ss = new Stack<>();
        // Using Collection Frame work reversing String
        // ss.push("c");
        // ss.push("b");
        // ss.push("a");
        // while (!ss.isEmpty()) {
        // System.out.println(ss.pop());

        // }
        // Creating function and reversing String
        // String str = "abc";
        // String result = reverseString(str);
        // System.out.println(result);

        //Reverse Stack
       
        reverseStack(s);
        printStack(s);
    }
}
