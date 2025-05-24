public class BitManipulation_1 {
    public static void oddorEven(int n) {
        int bitMask = 1;
        // if LSB  have 1 in last it is odd otherwise even like 3 = 011 and 4 = 100
        if ((n & bitMask) == 0) {
            System.out.println("Even number");
        }
         else {
            System.out.println("odd number");
         }
    }
    //operations od bit = get ,set and clear bit
    public static int getIthbit(int n , int i) {
        int bitMask = 1<<i;
        if ((n & bitMask) == 0) {
           return 0;
        } else {
            return 1;
        }
    }
    public static int setIthBit(int n , int i) {
        int bitMask = 1<<i;
        
            return n | bitMask;
    
    }
    public static int clearithBit(int n , int i) {
        // operation 1 . to reach out at bit through left shift
        // and complement of that left shift to become that ith bit 0 if it was zero
        // it will remain zero but if it was 1 its complement will make it 0

        int bitMask = ~(1<<i);
        // and finall and operation will clear that 1 into 0 bit
        return n & bitMask;
    }
    public static int updateIthBit(int n , int i , int newBit) {
        // first method
        // if (newBit == 0) {
        //     return clearithBit(n, i);
        // }
        //  else {
        //     return setIthBit(n, i);
        //  }

        // second method
        n = clearithBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }
    public static int clearIbits(int n , int i) {
        int bitMask = (~0)<<i;
        return n & bitMask;
    }
    public static int clearIbits(int n , int i , int j) {
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        int bitMask = a | b;
        return n & bitMask;

    } 

    public static boolean ispowerofTwo(int n){
        return (n &(n-1)) == 0;
    }
    // question asked in google
    public static int countsetbits(int n) {
        int count = 0;
        while (n>0) {
            if ((n & 1) !=0) {
              count++;  
            }
            n = n>>1;
        }
        return count;
    
    }
    public static int fastExpo(int a , int n) {
        int ans = 1;
        while (n>0) {
            if ((n & 1) !=0) { //check LSB
              ans = ans * a;  
            }
            a = a * a;
            n = n>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        oddorEven(3);
        oddorEven(4);
    // 10 in binary 1010 = i =3 which is 1 and if i = 0 which 
      System.out.println(  getIthbit(10,3 ));
      //10 = 1010 now set 2 bit as 1 after set 1110 = 14
      System.out.println(setIthBit(10, 2));
      // 10 = 1010 = after clear 1000 position one which is equal 1 has been cleared to 0
      System.out.println(clearithBit(10, 1));
      

      //clear ith bits last if i = 2 clear 2 last bits if n = 15 
      // then 15 = 1111 clear last after clearation 1100 which is equal to 12
        System.out.println(clearIbits(15, 2));

        // range of clear bit from i to j
        // if n = 10 i = 2 and j = 4 before clear 0001010 after clear 0000010 = 2
        System.out.println(clearIbits(10,  2, 4));

        // check is it power of 2 or not
        System.out.println(ispowerofTwo(8));

        // count how many setbit(1) in number if 15 = 1111 4 setbits
        System.out.println(countsetbits(15));

        System.out.println(fastExpo(3, 5));

    }
}
