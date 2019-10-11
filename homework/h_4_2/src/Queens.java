import java.io.IOException;
import java.util.Scanner;

/**
 * Queens
 */
public class Queens {

    private int boardSize;
    private int count = 1;
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.print("Enter Number of Queens: ");

        Queens q = new Queens(input.nextInt());

        q.solve();

        input.close();
    }

    /**
     * @param boardSize Constructor
     */
    public Queens(int boardSize) {
        setBoardSize(boardSize);
    }

    /**
     * @return the boardSize
     */
    public int getBoardSize() {
        return boardSize;
    }

    /**
     * @param boardSize the boardSize to set
     */
    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    void printBoard(int board[][]) {

        System.out.printf("\n%d.\n", count++);
        for (int i = 0; i < getBoardSize(); i++) {
            for (int j = 0; j < getBoardSize(); j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean safeCheck(int board[][], int row, int col) {

        int i, j;

        // horizontal check
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // diagonal (negative slope) check
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // diagonal (positive slope) check
        for (i = row, j = col; j >= 0 && i < getBoardSize(); i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;

    }

    boolean solveRecursive(int board[][], int col) {

        // if column manages to increment to board size (END)
        // print solution
        if (col == getBoardSize()) {
            printBoard(board);
            return true;
        }

        boolean resume = false;

        // test all possible rows of a column
        for (int i = 0; i < getBoardSize(); i++) {
            if (safeCheck(board, i, col)) {
                board[i][col] = 1;
                // continue to next column
                resume = solveRecursive(board, col + 1) || false ;
                // backtrack (remove queen)
                board[i][col] = 0;
            }
        }
        return resume;
    }

    void solve() {

        int[][] board = new int[this.getBoardSize()][this.getBoardSize()];

        // begin at column 0
        if (solveRecursive(board, 0) == false) {
            return;
        }

        printBoard(board);
        return;
    }
}