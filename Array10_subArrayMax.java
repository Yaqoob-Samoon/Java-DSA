import java.util.*;

public class Array10_subArrayMax {
    // time complexit is bad O(n^2) but less than initial code of Brute force
    // previous code
    public static void MaxSumSubarray(int numbers[]) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];
        // sum of initial number will remains as it as sum of 1 = 1
        prefix[0] = numbers[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + numbers[i];
        }
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                sum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("Maximum Sum:" + maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = { 1, -2, 6, -1, 3 };
        MaxSumSubarray(numbers);
    }
}
