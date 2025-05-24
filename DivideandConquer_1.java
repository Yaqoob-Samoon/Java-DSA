public class DivideandConquer_1 {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int si, int ei) {
        // base Case
        if (si >= ei) {
            return;
        }

        // pivot as a : last Element
        // pidx = pivot index
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1);// left part
        quickSort(arr, pIdx + 1, ei); // right part
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make place for elements smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        // swap
        int temp = pivot;
        arr[ei] = arr[i]; // yahn pe pivot = arr[i] nahii likhna hai bcz pivot variable ha or humy index
                          // kii value swap kernii hai
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        // same code for odd and even elements
        int arr[] = { 6, 3, 9, 5, 2, 8 };

        quickSort(arr, 0, arr.length - 1);
        printArr(arr);


    }

}
