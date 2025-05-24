public class Array6_PairsINArray {
    public static void pairsinArray(int numbers[]){
        for (int j = 0; j < numbers.length; j++) {
            int curr = numbers[j];
            for (int i=j+1; i < numbers.length; i++) {
               System.out.print("("+ curr + "," + numbers[i]+")"); 
            }
            System.out.println();
        }
       
    }
    public static void main(String[] args) {
        int number[] = {2,4,6,8,10,12,14};
        pairsinArray(number);
    }
}
