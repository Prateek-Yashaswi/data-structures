package ds.backtracking.nqueen;

public class Nqueen {
    private void printSolution(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
    }

    // A utility function to check if a queen can
    // be placed on board[row][col]. Note that this
    // function is called when "col" queens are already
    // placed in columns from 0 to col -1. So we need
    // to check only left side for attacking queens
    private boolean isSafe(int[][] board, int row, int col, int n) {

        // Check for left side of an element (since we are moving row - wise from left to right)
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check for top left diagonal of an element
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check for bottom left diagonal of an element
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // A recursive utility function to solve N
    // Queen problem
    private boolean solveNQUtil(int[][] board, int col, int n) {

        // Base case: If all queens are placed
        if (col >= n) {
            return true;
        }

        // Move across the board from left -> right (Row wise)
        for (int i = 0; i < n; i++) {

            // Try placing the queen after checking if it's a safe place
            if (isSafe(board, i, col, n)) {

                board[i][col] = 1;

                // If it's safe, try for all the next possible places
                if (solveNQUtil(board, col + 1, n)) {
                    return true;
                }
            }

            // If no other place is safe after placing queen at [i][col], remove the queen from [i][col]
            // Backtrack
            board[i][col] = 0;
        }

        // If no solution is available
        return false;
    }

    // This function solves the N Queen problem using
    // Backtracking. It mainly uses solveNQUtil () to
    // solve the problem. It returns false if queens
    // cannot be placed, otherwise, return true and
    // prints placement of queens in the form of 1s.
    // Please note that there may be more than one
    // solution, this function prints one of the
    // feasible solutions.
    public void solveNQ(int n) {
        int[][] board = new int[n][n];

        if (!solveNQUtil(board, 0, n)) {
            System.out.print("Solution does not exist");
            return;
        }

        printSolution(board, n);
    }
}
