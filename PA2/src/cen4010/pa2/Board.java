package cen4010.pa2;

public class Board {
	
	public static char gameboard[][]; // 2D array game board
	public static int size; // size of board
	public static char c; // either x or o mark
	public int row;
	public int col;
	public static int turn_number=1;
	
	public Board (int row, int col) {
		Board.gameboard = new char [row][col];
		this.row = row;
		this.col = col;
	}
	
	public static boolean playerWin(char[][] board, int[] move, char c) { // checks for winning combinations

	    // check rows
	    for (int i = 0; i < size; i++) {
	        if (board[i][0] == c) {
	            int j;

	            for (j = 1; j < size; j++) {
	                if (!(board[i][j] == c)) {
	                    break;
	                }
	            }

	            if (j == size) {
	                return true;
	            }
	        }
	    }

	    // check columns
	    for (int i = 0; i < size; i++) {
	        if (board[0][i] == c) {
	            int j;

	            for (j = 1; j < size; j++) {
	                if (!(board[j][i] == c)) {
	                    break;
	                }
	            }

	            if (j == size) {
	                return true;
	            }
	        }
	    }

	    // check diagonals
	    int i;

	    for (i = 0; i < size; i++) {
	        if (!(board[i][i] == c)) {
	            break;
	        }
	    }

	    if (i == size) {
	        return true;
	    }

	    for (i = 0; i < size; i++) {
	        if (!(board[i][(size - 1) - i] == c)) {
	            break;
	        }
	    }

	    return i == size;
	}

	public static boolean gameDraw() { // checks for draws
	    for (int i = 0; i < size; i++) {
	        for (int j = 0; j < size; j++) {
	            if (gameboard[i][j] == 0) { // since char is primitive type can't check for null, instead check if value is zero
	                return false;
	            }
	        }
	    }

	    return true;
	}
}