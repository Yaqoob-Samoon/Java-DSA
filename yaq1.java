import java.util.LinkedList;
import java.util.Queue;

public class yaq1 {

    public static int linearSearch(Queue<Integer> queue, int target) { 
        // Temporary queue to hold elements while searching
                Queue<Integer> tempQueue = new LinkedList<>(queue);
                int position = 1;
                // Check each element in the queue
                while (!tempQueue.isEmpty()) {
                    int element = tempQueue.poll();
                    if (element == target) {
                        return position;
                    }
                    position++;
                }
        
                return -1;
            }

    public static void main(String[] args) {
        // Initialize the queue with elements
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println("Queue: " + queue);

        // Element to search for
        int target = 40;
        // Perform Linear Search
       // boolean found = linearSearch(queue, target);
        int position = linearSearch(queue, target);

        if (position != -1) {
            System.out.println("Element " + target + " found in the queue = " + position);
        } else {
            System.out.println("Element " + target + " not found in the queue.");
        }
    }
  
}
        