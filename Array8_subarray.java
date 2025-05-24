import java.util.*;
public class Array8_subarray {
    public static void  printsubArray(int numbers[]){
        int ts = 0;
        int sum = 0;
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            int start = i;
            
            for (int j = i; j < numbers.length; j++) {
                int end = j;
               
                for (int k = start; k<=end; k++) {
                    System.out.print(numbers[k]+" ");
                    sum+=numbers[k];
                   
                } 
                 
                   
                if (largest<sum) {
                    largest = sum;
                    
                }
                 
                if (smallest>sum) {
                    smallest = sum;
                    
                }
               
                ts++;
               
                System.out.println();
                
               
            }
            System.out.println();
            System.out.println("sum"+sum);
            
        }
        
        System.out.println("Total subarray ="+ts);
        System.out.println("largest of sum"+largest);
        System.out.println("smallest of sum"+smallest);
    }
    
    public static void main(String[] args) {
        int numbers[] = {2,4,6,8,10};
        printsubArray(numbers);
        
    }
}
