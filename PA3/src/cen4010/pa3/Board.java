package cen4010.pa3;

/*Board class - PA3
 * CEN4010
 * T4
 * Latest version: 11/11/21
 */
public class Board {
	
	public static char gameboard[][]; // 2D array game board
	public static char c; // either x or o
	public static int m; // rows
	public static int n; // columns
	public static int k; // score to win
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
	
	public static boolean playerWin(char c) { // checks for winning combinations

	    /* check horizontal */
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
		    			}
		    		}
		    	}
	    	}
	    }

	    /* check vertical */
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
				        }
		    		}
		    	}
		    }
	    }
	        
	    /* check diagonals upwards */
	    for (int row = 0; row < m; row++) {
	    	for (int col = 0; col < n; col++) {
		    	
	    		if (gameboard[row][col] == c) {
	 
			    	int score = 1; 		            
			    	int i = row - 1; // set row index for next point in diagonal		           
		            int j = col + 1; // set column index for next point in diagonal
		 		           
		            while (gameboard[i][j] == c) { // traverse diagonally up and to the right              	 
		                i--;	                	                
		                j++;
		                score++;
		                
		                if (score >= k) {
		                	return true;
		                }
		            }
			    }
	    	}
	    }
	    
	    /* check diagonals downwards */
	    for (int row = 0; row < m; row++) {
	    	for (int col = 0; col < n; col++) {
		    	
	    		if (gameboard[row][col] == c) {
	 
			    	int score = 1; 		            
			    	int i = row + 1; // set row index for next point in diagonal		           
		            int j = col + 1; // set column index for next point in diagonal
		 
		            while (gameboard[i][j] == c) { //traverse diagonally down and to the right            	 
		                i++;	                	                
		                j++;
		                score++;
		                
		                if (score >= k) {
		                	return true;
		                }
		            }
			    }
	    	}
	    }
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
	
