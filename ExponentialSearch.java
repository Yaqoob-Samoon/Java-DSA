public class ExponentialSearch {
    
    public static int exponentialSearch(int arr[], int key) {
        if (arr[0] == key) // If the element is present at the first index
            return 0;

        // Find range for binary search by repeated doubling
        int i = 1;
        while (i < arr.length && arr[i] <= key) {
            i *= 2; // exponent
        }
        
        // Perform binary search in the found range
        return binarySearch(arr, key, i / 2, Math.min(i, arr.length - 1));
    }

    public static int binarySearch(int numbers[], int key, int start, int end) {
        // condition if value of start is less than equal to end
        while (start <= end) {
            // finding mid
            int mid = start + (end - start) / 2;
            // comparison condition after finding mid
            if (numbers[mid] == key) {
                return mid;
            } else if (numbers[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 8, 12, 16, 18, 23, 38, 56, 72, 91};
        int key = 18;
        int index = exponentialSearch(arr, key);
        if (index != -1)
            System.out.println("Element found at index: " + index);
        else
            System.out.println("Element not found in the array.");
    }
}
