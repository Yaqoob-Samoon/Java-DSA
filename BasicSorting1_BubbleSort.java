import java.util.*;

public class BasicSorting1_BubbleSort {
    public static void bubbleSrt(int arr[]) {
        for (int turn = 0; turn < arr.length - 1; turn++) {
            for (int i = 0; i < arr.length - 1 - turn; i++) {
                if (arr[i] > arr[i + 1]) {
                    // swap
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    // print
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                // ascending order > for descending order <
                if (arr[minPos] > arr[j]) {
                    minPos = j;
                }
            }
            // swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            // finding out the correct position to sort
            while (prev >= 0 && arr[prev] > arr[curr]) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev + 1] = arr[curr];
        }
    }

    public static void countSort(int arr[]) {
        int larges = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            larges = Math.max(larges, arr[i]);
        }

        int count[] = new int[larges + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        // Integer arr[] = { 5, 1, 3, 2, 4 };
        // int arr[] = { 5, 1, 3, 2, 4 };
        int arr[] = { 1, 4, 1, 3, 2, 4, 3, 7 };

        // these three sorting technique have 0(n^2) time complexity
        // insertionSort(arr);
        // bubbleSrt(arr);
        // selectionSort(arr);

        countSort(arr);

        // inbuilt sorting in java //care about datatype// Time complexity 0(n logn)
        // less than above three techniques

        // this will sort whole array
        // Arrays.sort(arr);

        // we can sort specfic portion of array just declare start index and end index
        // ending index shoul be +1 as real e.g lets sort our array from 5 to 3

        // Arrays.sort(arr , 0 , 3);
        // printArr(arr);

        // for reversing an array we have to initialize array as object Integer bcz of
        // collection function will not work on simple int

        // Arrays.sort( arr, Collections.reverseOrder());
        // printArr(arr);

        // for index start index and end index

        // Arrays.sort(arr , 0 , 3 , Collections.reverseOrder());
        printArr(arr);

    }
}
