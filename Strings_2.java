public class Strings_2 {
    public static String subString(String str, int si, int ei) {
        String subString = "";
        for (int i = si; i < ei; i++) {
            subString += str.charAt(i);
        }
        return subString;
    }

    public static void main(String[] args) {
        String substr = "HelooWorld";
        // in built substring
        // till index 4 will be printed not last one 5
        System.out.println(substr.substring(0, 5));

        // built substring
        System.out.println(subString(substr, 0, 5));
    }
}
