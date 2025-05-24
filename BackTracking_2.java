public class BackTracking_2 {
    public static boolean isSafe(char board[][] , int row , int col) { //timeComplexity O(n!)
        //Checking is there any Queen Vertically Up ?
        for(int i = row-1;i>=0;i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

         //Checking is there any Queen Diagonally left Up ?
         for(int i = row-1 , j = col-1;i>=0 && j>=0;i--,j--){
            if (board[i][j] == 'Q') {
                return false;
            }
         }
         //Checking is there any Queen Diagonally right Up ?
         for(int i = row-1,j=col+1; i>=0&&j<board.length;i--,j++){
            if (board[i][j] == 'Q') {
                return false;
            }
         }
         return true;
    }
    public static void nQueens(char board[][], int row) {
        // base case
        if (row == board.length) {
            // for printing chess board 
            // printBoard(board);
            count++;
            return;
        }
        // coloumn loop
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row+1); // Function Call
                board[row][j] = 'x'; // Backtracking Step where it reomves Queen and place x

            }
            
        }
    }
// same come as nqueens just three changes checking solution in yes or no answere and 
//printing only one solution
    public static boolean nQueens1(char board[][], int row) {
        // base case
        if (row == board.length) {
            // for printing chess board 
            // printBoard(board);
            count++;
            return true;
        }
        // coloumn loop
        for (int j = 0; j < board.length; j++) {
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if(nQueens1(board, row+1)) {
                    return true;
                }
                board[row][j] = 'x'; // Backtracking Step where it reomves Queen and place x

            }
            
        }
        return false;
    }
    public static void printBoard(char Board[][]) {
        System.out.println("<----Chess Board---->");
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board.length; j++) {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }
    }
   // for counting total ways of solving n queens
   static int count = 0;

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];

        // initializing Board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }

        }
        nQueens(board, 0);
        System.out.println("total ways of solving n queens = "+count);

        if (nQueens1(board, 0)) {
            System.out.println("Solution is possible");
            printBoard(board);
        }
        else {
            System.out.println("Solution is not possible");
        }

    }
}
