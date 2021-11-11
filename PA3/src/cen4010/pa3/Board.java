package cen4010.pa3;


public class Board {
	
	public static char gameboard[][]; // 2D array game board
	public static char c; // either x or o mark
	public static int m; // rows
	public static int n; // columns
	public static int k=3; // score to win
	public static int turn_number=1;
	
	
	
	
	
	/**
	 * Instantiates the gameboard with inputs m by n
	 * @param m
	 * @param n
	 */
	public static void createBoard (int m, int n) { // board constructor
		gameboard = new char [m][n];
		Board.m = m;
		Board.n = n;
	}
	/*
	public static void setBoard() { // initializes board to 0s
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            Board.gameboard[i][j] = 0;
	        }
	    }
	}
	*/
	/*
	public static boolean isValidMove(int x, int y) {

	    // checks if in bounds
	    if ((x >= m) || (y >= n)) {
	        return false;
	    }

	    // checks if space is available
	    return (gameboard[x][y] == 0);
	}
	*/
	
	public static boolean playerWin(char c) { // checks for winning combinations

	    // check horizontal
	    for (int row = 0; row < m; row++) {
	    	for (int col = 0; col < n; col++) {
		    	if (gameboard[row][col] == c) {
		    		int score = 1;
		    		for (int i = 1; i < n; i++) {
		    			if (gameboard[row][col+i] == c) {
				            score++;
				            if (score >= k) { // reached required score
				            	return true;
				            }		            
				            else { 
				            	break;
				            }
		    			}
		    		}
		    	}
	    	}
	    }

	    // check vertical
	    for (int col = 0; col < n; col++) {
	    	for (int row = 0; row < m; row++) {
		    	if (gameboard[row][col] == c) {
		    		int score = 1;
		    		for (int i = 1; i < n; i++) {
		    			if (gameboard[row+i][col] == c) {
				            score++;
				            if (score >= k) { // reached required score
				            	return true;
				            }		            
				            else { 
				            	break;
				            }
		    			}
		    		}
		    	}
	    	}
	    }
	  
	    //Check diagonals - in progress
	  	if(gameboard[0][0] == gameboard[1][1] && gameboard[1][1] == gameboard[2][2] && gameboard[0][0] == c) {
	  			return true;
	  	}
	  	
	  	if(gameboard[2][0] == gameboard[1][1] && gameboard[1][1] ==  gameboard[0][2] && gameboard[2][0] == c) {
	  			return true;
	  	}
	  	
	    //checkDiagonals(c);
	    return false;
	}
	
	/* work in progress
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
		}*/
	
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
	
