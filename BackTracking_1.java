public class BackTracking_1 {
    public static void findSubset(String str, String ans, int i) { // TC = O(n * 2^n) SC = O(n)
        // base Case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans);
            }
            return;

        }
        // kaam / recursion
        // if Yes Choice
        findSubset(str, ans + str.charAt(i), i + 1);
        // if No Choice
        findSubset(str, ans, i + 1);
    }
    public static void findPermutation(String str , String ans) { // TC = O(n * n!)
        //base Case
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }

        //Kaam
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);

            String Newstr = str.substring(0, i) + str.substring(i+1);
            findPermutation(Newstr, ans+curr);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        // findSubset(str, "", 0);
        findPermutation(str, "");
    }
}
