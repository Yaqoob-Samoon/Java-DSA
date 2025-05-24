import java.util.*;
public class Array9_subArrayMax {
    //Time Complexity is ver bad n^3 for these three loops
    public static void MaxSubArray(int numbers[]) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            for (int j = i; j < numbers.length; j++) {
                int end = j;
                sum = 0;
                for (int k = start; k <= end; k++) {
                    sum+=numbers[k];
                   
                }
                System.out.println(sum);
                 if (maxSum<sum) {
                    maxSum = sum;
                 }
            }
        }
        System.out.println("Maximum Sum:"+maxSum);
    }

    public static void main(String[] args) {
        int numbers[] = { 2, 4, 6, 8,10 };
        MaxSubArray(numbers);
    }
}
