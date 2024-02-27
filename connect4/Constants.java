 

/**
 * Tic-Tac-Toe game constants
 */

public class Constants
{
    // Valid board size
    public static final int ROWS = 6;
    public static final int COLS = 7;
    public static final char EMPTY = ' ';
    public static final char PLAYER1 = 'X';
    public static final char PLAYER2 = 'O';
    public static char[][] board = new char[ROWS][COLS];
    public static int[] availableRow = new int[COLS];
    
    // Strings
    public static final String DIVIDER_STRING = "|---|---|---|";
    public static final String BOARD_STRING = "| %s ";
    public static final String GET_PLAYER_NAME = "Player %s: What is your name?";
    public static final String TITLE = "Thanks for playing Connect Four!";
    public static final String GET_ROW_MOVE = "Player %s (%s): Enter the row for your next move";
    public static final String GET_COL_MOVE = "Player %s (%s): Enter the column for your next move";
    public static final String INVALID_ROW_OR_COLUMN = "Your row and column must be 1, 2, or 3";
    public static final String INVALID_MOVE_ERROR = "Row %d column %d is not a valid move. Please try again";
    public static final String PRINT_MOVE = "Player %s (%s) move to %d %d";
    public static final String WINNER = "%s - %s is the winner!";
    public static final String TIE_GAME = "It's a tie game!";
    public static final String START_NEW_GAME = "Start a new game (Y or N)?";
}
