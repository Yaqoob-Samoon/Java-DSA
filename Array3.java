import java.util.*;

public class Array3 {
    public static int getLargest(int numbers[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (largest < numbers[i]) {
                largest = numbers[i];
            }
        }
        return largest;
    }

    public static int getSmallest(int numbers[]) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (smallest > numbers[i]) {
                smallest = numbers[i];
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 3, 5, 6, 8, 1 };
        System.out.println("Largest Number:" + getLargest(numbers));
        System.out.println("Smallest Number:" + getSmallest(numbers));
    }
}
