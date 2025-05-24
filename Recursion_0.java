public class Recursion_0 {
    // Decreasing numbers using recursion
    public static void printDec(int n) {
        //base case
        if (n == 1) {
            System.out.println(n);
            return ;
        }
        else {
            //printing number n
            System.out.print(n+" ");
            //recalling funcition itself
            printDec(n-1);
        }
    }
    // increasing numbers usig recursion
    public static void prinInc(int n1) {
        if (n1 == 10) {
            System.out.println(10);
            return;
        } else {
            System.out.print(n1+" ");
            prinInc(n1 + 1);
        }
    }
    // another way of increasing numbers 
    public static void prinInc1(int n) {
        if (n == 1) {
            System.out.print(n+" ");
            return;
        }
        prinInc1(n-1);
        System.out.print(n+" ");
        
    }
    
    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        // fnm1 = factorial of n - 1
        int fnm1 = fact(n - 1);
        int fn = n * fact(n -1);
        return fn;
    }
    public static int sumCalc(int n) {
        if (n == 1) {
          return 1;
        }
        int snm1 = sumCalc(n -1);
        int sn = n + snm1 ;
        return sn;
    }
    public static int fibonacci(int n) { // time complexity exponential O(2^n)
        if (n == 0 || n ==1) {
            return n;
        }
        int fibnm1 = fibonacci(n-1);
        int fibnm2 = fibonacci(n-2);
        int fn = fibnm1 + fibnm2;
         return fn;
    }
    public static boolean isSorted(int arr[] , int i) { //time complexity O(n)
        if (i == arr.length-1) {
            return true;
        }
        if (arr[i] > arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOcuurence(int arr1[] , int key , int i) { //time complexity O(n)and sc = O(n)
        if (i == arr1.length) {
            return -1;
        }
        if (arr1[i] == key) {
            return i;
        }
        return firstOcuurence(arr1, key, i+1);
    }
    public static int lastOcuurence(int arr2[] , int key , int i){
        if (i == arr2.length) {
            return -1;
        }
        // lookForward
        int isfound = lastOcuurence(arr2, key, i+1);
        if (isfound != -1) {
            return isfound;
        }
        //check with self
        if (arr2[i] == key) {
            return i;
        }
        return isfound;
    }
    public static int power(int x , int n) { // time complexity O(n)
        if (n == 0) {
            return 1;
        }
        // creating variables
        // int xnm1 = power(x, n - 1);
        // int xn = x * xnm1;
        // return xn;
        // single line code
        return x * power(x, n-1);
    }
    // time Complexoity O(logn)
    public static int optimizedpower(int x , int n) {
        if (n == 0) {
            return 1;
        }
        int halfpower = optimizedpower(x ,n/2);
      int halfpowerSq =  halfpower * halfpower;  
      if (n %2 != 0 ) {
        halfpowerSq = x * halfpowerSq;
      }
      return halfpowerSq;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        int arr1[] = {8,3,6,9,5,10,2,5,3};
        int arr2[] = {8,3,6,9,5,10,2,5,3};
        int n1 = 1;
        int n = 10;
        printDec(n);
        prinInc(n1);
        prinInc1(n);
        // factorial of numbers
       System.out.println(fact(5));
       // sum of natural numbers
       System.out.println(sumCalc(5));
       System.out.println(fibonacci(5));
       System.out.println(isSorted(arr, 0));
       System.out.println(firstOcuurence(arr1, 5, 0));
       System.out.println(lastOcuurence(arr2, 5, 0));
       // worst time complexity power found
       System.out.println(power(2, 10));

       // best time complexity power found
       System.out.println(optimizedpower(2, 10));
    } 
}
