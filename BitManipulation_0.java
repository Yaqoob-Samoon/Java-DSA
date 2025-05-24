public class BitManipulation_0 {
    public static void main(String[] args) {
        // and operator in binary 
        // first convert in binary than compare according to operator (or , and)
        System.out.println(5 & 6);
        System.out.println(5 | 6);

        // XOR operator
        // same numbers will give 0 like 1 and 1 = 0 , 0 and 0 = 0
        // different bit will gove 1 like 1 and 0 = 1 , 0 and 1 = 1
        System.out.println(5 ^ 6);

        // one`s Complement 
        // Process: find 2and complement and then  value will be equal to negative decimal number 
        //In Computer MSB is 0 in start  MSB = Most significant number right side
        //LSB least significant number lesft side for 5 0000000101
        //MSB  = 0 , LSB  = 1 from left side
        // when MSB 0 complemnt  convert into 1 then it is equal to -ve values
        System.out.println(~5);

        //binary left shift operatoor formula = a * 2^b here a =5 and b = 2
        System.out.println(5<<2);

        //binary right shift operatoor formula = a / 2^b here a =6 and b = 1
        System.out.println(6>>1);
    }
}
