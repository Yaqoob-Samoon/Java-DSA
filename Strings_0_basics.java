import java.util.*;
public class Strings_0_basics {
    public static void printAllCharacter(String fullName) {
        for (int i = 0; i < fullName.length(); i++) {
            System.out.print(fullName.charAt(i)+ " ");
        }
        System.out.println();
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            int n = str.length();
            if (str.charAt(i) != str.charAt(n-1-i)) {
                // not a palindrome
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char arr[] = {'a' , 'b' , 'c' , 'd' };
        // string declaration 2 methods // difference is in only memory allocation
        String str = "abcd";
        String str2 = new String("abcd");

        // Sreings in Java are IMMUTABLE // values cant change after declaration

        // string input
        // next() will input only a word if {input = Yaqoob Samoon }= Output = Yaqoob 
        // nextLine will input whole line if {input = Yaqoob Samoon }= Output = Yaqoob Samoon}

        Scanner sc = new Scanner(System.in);
       String name =  sc.nextLine();
       String name1 =  sc.next();

       System.out.println("Your name is "+name);
       System.out.println("Your half name is "+name1);

       //Length of a String
       //Difference of length b/w array and string is ()
       //in array arr.length without ()
       //In Strings str.length() with ()
       System.out.println(name.length());

       // concatenations = combination of two strings
       String firstName = "Yaqoob";
       String lastName = "Samoon";
       String fullName = firstName + " "+lastName;

       System.out.println("Concatenated name "+fullName);

       // find lettters at index e.g in Yaqoob Y is at index 0;
       System.out.println(fullName.charAt(0));

       // print all characters of indexes = 
      printAllCharacter(fullName);

      //palindrome
      String str3 = "racecar";
    System.out.println(isPalindrome(str3));

        
    }
}
