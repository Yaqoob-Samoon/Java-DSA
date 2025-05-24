import java.util.Stack;

public class stacks_4 {
    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Opening brackets case
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            }
            // Closing Braces Case
            else {
                if (s.isEmpty()) {
                    return false;
                }
                if ((s.peek() == '(' && ch == ')')
                        || (s.peek() == '{' && ch == '}')
                        || (s.peek() == '[' && ch == ']')) {
                    s.pop();
                } else {
                    return false;
                }

            }

        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // Checking Duplicate Parenthesis Important Question asked in Google Microsoft
    public static boolean isDuplicate(String str) { // Time Complexity O(n)
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // Closing parenthesis case
            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true; // mean duplicate exist
                } else {
                    s.pop(); //Opening Pair found and pop(delete)
                }
            } else {
                //Opening Parenthesis Case
                s.push(ch);
            }

        }
        return false;

    }

    public static void main(String[] args) {
        // string checking parenthese Code
        String str = "({})[]";
        System.out.println(isValid(str));

        // Next Greater Code
        int arr[] = { 6, 8, 0, 1, 3 };
        Stack<Integer> s = new Stack<>();
        int nextGreater[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            // while
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for (int i = 0; i < nextGreater.length; i++) {
            System.out.print(nextGreater[i] + " ");
        }
        System.out.println();

        // Duplicate Parenthesis Question
        String str1 = "((a+b))"; // return true bcz it has duplicate parenthesis
        String str2 = "(a-b)";// return false bcz it hasn`t duplicate parenthesis
        System.out.println(isDuplicate(str2));
    }
}
