public class Array2_FunctionArgument {
    public static void changeAble(int marks[], int nonChangeable) {
        nonChangeable = 10;
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void main(String[] args) {
        // Arguments ke through value changes ho saktii
        // In array value can be updated by reference not by value
        int marks[] = { 98, 88, 87 };
        // call by value
        int nonChangeable = 99;
        changeAble(marks, nonChangeable);
        for (int i = 0; i < marks.length; i++) {
            System.out.println("changed marks" + marks[i]);
            System.out.println("Value has not changed:" + nonChangeable);
        }
    }
}
