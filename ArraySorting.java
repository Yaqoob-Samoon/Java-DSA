import java.util.Arrays;

public class ArraySorting {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9};
        
        // Sorting a specific range of the array from index 1 to 4 (inclusive to exclusive)
        Arrays.sort(arr, 1, 5);
        // Array Complete Sort 
        Arrays.sort(arr);
        // Printing the sorted array
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
