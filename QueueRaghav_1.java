import java.util.*;

public class QueueRaghav_1 {
   
    public static void main(String[] args) {
       Queue<Integer> q = new LinkedList<>(); 
       q.add(1);
       q.add(2);
       q.add(3);
       q.add(4);
       q.add(5);
       Queue<Integer> helperQueue = new LinkedList<>();

       while (q.size()>0) {
            
            System.out.print(q.peek()+" ");
            helperQueue.add(q.poll());
       }
       while (helperQueue.size()>0) {
            q.add(helperQueue.remove());
       }


    }
}
