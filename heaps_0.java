import java.util.*;
public class heaps_0 {
   

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(3);
        pq.add(4);
        pq.add(1);
        pq.add(7);
        // it will print in ascending order by default
        while (!pq.isEmpty()) {
            System.out.print(pq.peek()+" ");
            pq.remove();
        }
        System.out.println();
        // print it in reverse order
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Comparator.reverseOrder());
        pq1.add(3);
        pq1.add(4);
        pq1.add(1);
        pq1.add(7);
        // it will print in ascending order by default
        while (!pq1.isEmpty()) {
            System.out.print(pq1.peek()+" ");
            pq1.remove();
        }
    }
}
