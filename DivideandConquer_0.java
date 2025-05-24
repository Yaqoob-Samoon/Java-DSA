public class DivideandConquer_0 {
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void mergeSort(int arr[] , int si , int ei) { // timecomplexity O(logn) and Space O(n)
        // base Case
        if (si >= ei) {
            return;
        }
        // kaam
        int mid = si + (ei - si)/2;
        //We divide our array in left and right part
        //Left Part
        mergeSort(arr, si, mid);
        //right
        mergeSort(arr, mid+1, ei);
        // merge left + right
        merge(arr , si , mid , ei);
    }
    // merge method to merge the sorted parts
    public static void merge(int arr[] , int si , int mid , int ei) {
        //in merging we have to combine left and right part
        //for that we have to create a temporary array

        // array size ei-si+1 why bcz if left (0,3) = 4 elements and right(4,6) = 3 elements
        // size = ei-si+1 = 6-0+1 = 7
        int temp[] = new int[ei-si+1];

        int i = si; // itterator for left
        int j = mid+1; // itterator for right
        int k = 0; // iterator for temporary

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] =  arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
                
            }
            k++;
        }
        // for leftover elements of 1st sorted part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
       // for leftover elements of 2and sorted part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy temp to original array
       for ( k = 0, i = si; k < temp.length; k++ , i++) {
            arr[i] = temp[k];
       }

    }
    public static void main(String[] args) {
        int arr[] = {6,3,9,5,2,8};
        // same code will work for odd and even elements in an array
     mergeSort(arr, 0, arr.length-1);
     printArr(arr);
    }
}
