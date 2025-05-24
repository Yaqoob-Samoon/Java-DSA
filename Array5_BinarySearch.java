public class Array5_BinarySearch {
    public static int binarySearch(int numbers[], int key) {
        // step1 to declare start and end
        int start = 0, end = numbers.length - 1;
        // condition if value of start is less than equal to end
        while (start <= end) {
            // finding mid
            int mid = (start + end) / 2;
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
        int numbers[] = { 1, 2, 3, 7, 8, 9, 5, 4 };
        int key = 1;
        System.out.println("Key is at index of : " + binarySearch(numbers, key));
    }
}
