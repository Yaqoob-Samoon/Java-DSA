public class BackTracking_0 {
    public static void changeArray(int arr[] , int i , int val) { // time Complexity O(n) SC= O(n)
        // base Case
        if (i == arr.length) {
            printArr(arr);
            return;
        }
        // kaam / recursion
        arr[i] = val;
        changeArray(arr, i+1, val+1); // function call step
        arr[i] = arr[i] - 2; // backtracking step

    }
    public static void  printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArray(arr, 0, 1);
        printArr(arr);
    }
}
