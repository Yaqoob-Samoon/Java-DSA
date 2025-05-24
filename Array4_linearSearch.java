import java.util.Scanner;

public class Array4_linearSearch {
    public static int linearSearch(int numbers[], int key) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int numbers[] = { 1, 2, 3, 4, 7, 6, 9, 8 };
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Key You want to search");
        int key = input.nextInt();

        int index = linearSearch(numbers, key);
        if (index == -1) {
            System.out.println("Not Found");

        } else {
            System.out.println("your key is at index " + index);
        }
    }
}
