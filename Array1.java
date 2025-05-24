import java.util.Scanner;

public class Array1 {
    public static void main(String[] args) {

        // four operation will be covered for each array
        // 1.Creation 2.input 3.output 4.update
        // 1.Array created
        int arraycc[] = new int[50];
        // this array size of 50 has null values of its data type

        int array[] = { 1, 2, 3 }; // the size of this array is 3 auto detected by 3
        
        // Input and output Operation
        int marks[] = new int[50];

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the marks of Physics");
        marks[0] = input.nextInt();
        System.out.println("Enter the marks of Math");
        marks[1] = input.nextInt();
        System.out.println("Enter the marks of Chemistry");
        marks[2] = input.nextInt();

        System.out.println("Physics Marks:" + marks[0]);
        System.out.println("Math Marks:" + marks[1]);
        System.out.println("Chemistry Marks:" + marks[2]);

        // 4.Update Operation through 2 ways we can change marks
        // marks[2] = marks[2] operation(* , /,-) number; like this
        marks[2] = marks[2] + 1;
        System.out.println("Chemistry Updated Marks 1:" + marks[2]);
        // way 2
        marks[2] = 98;
        System.out.println("Chemistry Updated Marks:" + marks[2]);

        // percentage of total marks
        int percentage = (marks[0] + marks[1] + marks[2]) / 3;
        System.out.println("percentage:" + percentage + "%");
        // length array
        System.out.println("LENGTH OF AN array:" + marks.length);
    }

}