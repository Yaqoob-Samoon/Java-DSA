public class Strings_1 {
    public static float getShortestPath(String path) {
        int x = 0, y = 0;
        for (int i = 0; i < path.length(); i++) {
            char dir = path.charAt(i);
            // South
            if (dir == 'S') {
                y--;
            }
            // North
            else if (dir == 'N') {
                y++;
            }
            // West
            else if (dir == 'W') {
                x--;
            }
            // East
            else {
                x++;
            }
        }

        // formula of displacement is using here first square and than undersquare of
        // twovariable
        // square of x and y
        int X2 = x * x;
        int Y2 = y * y;
        return (float) Math.sqrt(X2 + Y2);
    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getShortestPath(path));


        // checking strings are eual or not
        String s1 = "Yaqoob";
        String s2 = "Yaqoob";
        String s3 = new String("Yaqoob");

        // check
        if (s1 == s2) {
            System.out.println("Strings are equals");
        }
        else {
            System.out.println("Strings are not equals");
        }

        // check for s1 and s3
        // this will print else b/c in Memory new keyword stored seprately
        // s1 and s2 have same vallue store at same memory
        //but s3 store at separate value due to that s3 has seprate value but same
         if (s1 == s3) {
            System.out.println("Strings are equals");
        }
        else {
            System.out.println("Strings are not equals");
        }

        // how to check values in s1 and s3 if they are same;
         // check
         if (s1.equals(s3)) {
            System.out.println("Strings are equals");
        }
        else {
            System.out.println("Strings are not equals");
        }

    }
}
