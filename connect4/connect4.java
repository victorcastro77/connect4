import java.util.Scanner;

/**
 * Write a description of class connect4 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class connect4
{
    // instance variables - replace the example below with your own
     public static void main(String[] args) {
        initializeBoard();
        printBoard();
        boolean player1Turn = true;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            char currentPlayer = (player1Turn) ? Constants.PLAYER1 : Constants.PLAYER2;
            System.out.println("Player " + currentPlayer + "'s turn:");
            int col = getColumn(scanner, currentPlayer);
            int row = Constants.availableRow[col];
            if (row == -1) {
                System.out.println("Column is full, choose another column!");
                continue;
            }
            Constants.board[row][col] = currentPlayer;
            Constants.availableRow[col]--;
            printBoard();
            if (checkWin(row, col, currentPlayer)) {
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            if (checkDraw()) {
                System.out.println("It's a draw!");
                break;
            }
            player1Turn = !player1Turn;
        }
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < Constants.ROWS; i++) {
            for (int j = 0; j < Constants.COLS; j++) {
                Constants.board[i][j] = Constants.EMPTY;
            }
        }
        for (int i = 0; i < Constants.COLS; i++) {
            Constants.availableRow[i] = Constants.ROWS - 1;
        }
    }

    private static void printBoard() {
        System.out.println(" 1 2 3 4 5 6 7");
        for (int i = 0; i < Constants.ROWS; i++) {
            System.out.print("|");
            for (int j = 0; j < Constants.COLS; j++) {
                System.out.print(Constants.board[i][j] + "|");
            }
            System.out.println();
        }
    }

    private static int getColumn(Scanner scanner, char currentPlayer) {
        int col;
        while (true) {
            System.out.print("Enter column (1-7): ");
            col = scanner.nextInt() - 1;
            if (col < 0 || col >= Constants.COLS) {
                System.out.println("Invalid column! Choose a column between 1 and 7.");
            } else if (Constants.availableRow[col] == -1) {
                System.out.println("Column is full, choose another column!");
            } else {
                break;
            }
        }
        return col;
    }

    private static boolean checkWin(int row, int col, char player) {
        // Check horizontally
        for (int i = 0; i < Constants.COLS - 3; i++) {
            if (Constants.board[row][i] == player && Constants.board[row][i + 1] == player && Constants.board[row][i + 2] == player && Constants.board[row][i + 3] == player) {
                return true;
            }
        }
        // Check vertically
        for (int i = 0; i < Constants.ROWS - 3; i++) {
            if (Constants.board[i][col] == player && Constants.board[i + 1][col] == player && Constants.board[i + 2][col] == player && Constants.board[i + 3][col] == player) {
                return true;
            }
        }
        // Check diagonally (bottom-left to top-right)
        for (int i = 3; i < Constants.ROWS; i++) {
            for (int j = 0; j < Constants.COLS - 3; j++) {
                if (Constants.board[i][j] == player && Constants.board[i - 1][j + 1] == player && Constants.board[i - 2][j + 2] == player && Constants.board[i - 3][j + 3] == player) {
                    return true;
                }
            }
        }
        // Check diagonally (top-left to bottom-right)
        for (int i = 3; i < Constants.ROWS; i++) {
            for (int j = 3; j < Constants.COLS; j++) {
                if (Constants.board[i][j] == player && Constants.board[i - 1][j - 1] == player && Constants.board[i - 2][j - 2] == player && Constants.board[i - 3][j - 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < Constants.COLS; i++) {
            if (Constants.availableRow[i] != -1) {
                return false;
            }
        }
        return true;
    }
}
