public class Arrays_Multi_2 {
    public static void printSpiral(int matrix[][]) {
        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length-1;
        int endcol = matrix[0].length-1;

        while (startrow <= endrow && startcol <= endcol) {
            // Top
            for (int j = startcol; j <= endcol; j++) {
                System.out.print(matrix[startrow][j]+" ");
            }
            // right
            for (int i = startrow+1; i <= endrow; i++) {
                System.out.print(matrix[i][endcol]+" ");
            }
            //bottom
            for (int j = endcol-1; j >= startcol; j--) {
                if (startrow == endrow) {
                    break;
                }
                System.out.print(matrix[endrow][j]+" ");
            }
            //left
            for (int i = endrow-1; i>=startrow+1; i--) {
                if (startcol == endcol) {
                    break;
                }
                System.out.print(matrix[i][startcol]+" ");
            }
            startcol++;
            startrow++;
            endrow--;
            endcol--; 
        }
        System.out.println();

    }
    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

                printSpiral(matrix);
    }
}
