import java.util.*;

public class Arrays_Multi_1 {
    public static boolean search(int matrice[][], int key) {
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (matrice[i][j] == key) {
                    System.out.println("key found at index (" + i + "," + j + ")");
                    return true;
                }

            }
        }
        System.out.println("Key not found");
        return false;
    }

    public static int largest(int matrice[][]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (largest < matrice[i][j]) {
                    largest = matrice[i][j];
                }
            }
        }
        return largest;
    }

    public static int smallest(int matrice[][]) {
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < matrice.length; i++) {
            for (int j = 0; j < matrice[0].length; j++) {
                if (smallest > matrice[i][j]) {
                    smallest = matrice[i][j];
                }
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        int matrice[][] = new int[3][3];
        // n = row , m = colom;
        // int n = 3 , m = 3;
        // matrice od 0 means row 1 so length of row1 == coloms
        int n = matrice.length, m = matrice[0].length;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrice[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrice[i][j] + " ");

            }
            System.out.println();

        }
        search(matrice, 4);
        int big1 = largest(matrice);
        System.out.println("largest element in array " + big1);
        int small = smallest(matrice);
        System.out.println("Smallest element in matrix is " + small);
    }
}
