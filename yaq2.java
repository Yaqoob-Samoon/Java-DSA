import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class yaq2 {

    public static void main(String[] args) {
        // Initialize the queue with sorted elements
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);
        System.out.println("Queue: " + queue);
        // Element to search for
        int target = 20;
        // Perform Binary Search
        int position = binarySearch(queue, target);
        if (position != -1) {
            System.out.println("Element " + target + " found at position: " + position);
        } else {
            System.out.println("Element " + target + " not found in the queue.");
        }
    }

    
    
public static int binarySearch(Queue<Integer> queue, int target) { 
    // Convert the queue to a list
            List<Integer> list = new ArrayList<>(queue);
    
            // Perform binary search
            int low = 0;
            int high = list.size() - 1;
    
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int midVal = list.get(mid);
    
                if (midVal == target) {
                    return mid + 1; // Return position as 1-based index
                } else if (midVal < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
    
            return -1; // Return -1 if the element is not found
        }
    }
    
