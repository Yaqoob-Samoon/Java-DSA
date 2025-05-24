import java.util.*;

public class Array11_subArrayMax2 {
    public static void kadanes(int numbers[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
             sum += numbers[i];
            if (sum < 0) {
                sum = 0;
            }
            maxSum = Math.max(maxSum, sum);
        }
        System.out.println("Maximum Sum is :=" + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        kadanes(numbers);
    }
}
