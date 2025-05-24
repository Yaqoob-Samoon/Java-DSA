public class Recursion_2 {
    //Question asked in Goggle and Microsoft
    public static void removeDuplicate(String str , int idx , StringBuilder newstr , boolean map[]) {
        // 1. Base Case
        if (idx == str.length()) {
            System.out.println(newstr);
            return;
        }
        // 2. Kaam checking character are they in map or not
        char currChar = str.charAt(idx);
        //checking character
        if (map[currChar - 'a'] == true) {
            // if true it means there is duplicate character in string
            // so not adding character in our  new string
            removeDuplicate(str, idx + 1, newstr, map);
        }
        else {
            // if not duplicate
            map[currChar - 'a'] = true;
            // this will add character in new string bcz it is not duplicate
            removeDuplicate(str, idx+1, newstr.append(currChar), map);

        }

    }
    // Question asked in Goldman Sachs
    public static int friendspairing(int n) {

        // baseCase
        if (n == 1 || n ==2) {
            return n;
        }

        // choice : single
        int fnm1 = friendspairing(n-1);

         // choice : pair
         int fnm2 = friendspairing(n-2);
         // Pairways how many can make
         int pairWays = (n-1) * fnm2;
         //total ways = single + pair
         int totways = fnm1 + pairWays;
         return totways;

         // we can write whole code in a single linge reomveing above whole code
         // this single line can work perfectly
        //  return friendspairing(n-1) + (n-1) * friendspairing(n-2);
    }

    // Question asked in PayTm
    public static void printBinString(int n , int lastplace , String str) {
        //base case
        if (n == 0) {
            System.out.println(str);
            return;
        }
        // kaam
        // if (lastplace == 0) {
        //    // sit 0 on chair n
        //    printBinString(n-1, 0,  str.append("0"));
        //    printBinString(n-1, 1,  str.append("1"));

        // }
        // else {
        //     printBinString(n-1, 0,  str.append("0"));
        // }
        // code better tha above
        printBinString(n-1, 0,  str+"0");
        if (lastplace == 0) {
            printBinString(n-1, 1,  str+"1");
        }
    }
    public static void main(String[] args) {
       String str = "appnnacollege";
       removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);

       System.out.println(friendspairing(3));
       printBinString(3, 0, "");
    }
}
