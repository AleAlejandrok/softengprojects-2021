package cen4010.pa3;

/***************************/
/*HOW WE ARE IMPLEMENTING THE AI*/
/*
We will create an AI player that uses a minimax algorithm to train against 
another instance of the AI class. 

isMaximizingPlayer is something that will be used to denote if the AI is 
the one that will be playing in the game or if it is the AI used for training.



*/
/******************************/
public class AI {
	
	
	boolean isMaximizingPlayer;
	
	public AI (boolean ismax) {
		this.isMaximizingPlayer=ismax;		
	}
	
	
	//pseudocode for minimax function
	/*
	public minimax(board, depth, isMaximizingPlayer) {

	    if current board state is a terminal state :
	        return value of the board
	    
	    if isMaximizingPlayer :
	        bestVal = -INFINITY 
	        for each move in board :
	            value = minimax(board, depth+1, false)
	            bestVal = max( bestVal, value) 
	        return bestVal

	    else :
	        bestVal = +INFINITY 
	        for each move in board :
	            value = minimax(board, depth+1, true)
	            bestVal = min( bestVal, value) 
	        return bestVal 
	}
	*/
	}
