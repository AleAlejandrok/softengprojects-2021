package cen4010.pa2;

public class Board {
	
	public static char gameboard[][]; // 2D array game board
	public static char c; // either x or o mark
	public static int m; // rows
	public static int n; // columns
	public static int k; // score to win
	public static int turn_number=1;
	
	public Board (int m, int n) { // board constructor
		Board.gameboard = new char [m][n];
		Board.m = m;
		Board.n = n;
	}
	
	public static void setBoard() { // initializes board to 0s
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            Board.gameboard[i][j] = 0;
	        }
	    }
	}
	
	public static boolean isValidMove(int x, int y) {

	    // checks if in bounds
	    if ((x >= m) || (y >= n)) {
	        return false;
	    }

	    // checks if space is available
	    return (gameboard[x][y] == 0);
	}

	
	public static boolean playerWin(char[][] board, int[] move, char c) { // checks for winning combinations

	    // check horizontal
	    for (int i = 0; i < m; i++) {
	        if (board[i][0] == c) {
	            int j;

	            for (j = 1; j < n; j++) {
	                if (!(board[i][j] == c)) {
	                    break;
	                }
	            }

	            if (j == k) { // reached required score
	                return true;
	            }
	        }
	    }

	    // check vertical
	    for (int i = 0; i < m; i++) {
	        if (board[0][i] == c) {
	            int j;

	            for (j = 1; j < n; j++) {
	                if (!(board[j][i] == c)) {
	                    break;
	                }
	            }

	            if (j == k) { // reached required score
	                return true;
	            }
	        }
	    }
	    checkDiagonals(c);
	    return false;
	}
	
	
	public static boolean checkDiagonals(char playerMark) { // checks diagonals for winning condition

		// running down and right
		// don't need to iterate rows that can't be the starting point of a winning diagonal formation, thus can exclude some with row < (size - (sizeToWin - 1))
		for (int row = 0; row < (m - (k - 1)); row++) {
		    for (int col = 0; col < n; col++) {
		        int score = 0;

		        // down and right
		        for (int i = m; i < m; i++) {
		            if (gameboard[i][i] == 0 ? playerMark == 0 :
		                    gameboard[i][i] == (playerMark)) {
		                score++;

		                if (score >= k) {
		                    return true;
		                }
		            }
		        }

		        score = 0;

		        // down and left
		        for (int i = row; i < m; i++) {
		            if (gameboard[i][m - 1 - i] == 0 ? playerMark == 0 :
		                    gameboard[i][m - 1 - i] == (playerMark)) {
		                score++;

		                if (score >= k) {
		                    return true;
		                }
		            }
		        }
		    }
		}

		return false;
		}
	
	public static boolean gameDraw() { // checks for draw condition
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (gameboard[i][j] == 0) {
	                return false;
	            }
	        }
	    }

	    return true;
	}
	
}