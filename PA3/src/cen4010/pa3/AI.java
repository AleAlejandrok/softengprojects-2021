package cen4010.pa3;

import java.util.Random;


/***************************/
/*HOW WE ARE IMPLEMENTING THE AI*/
/*
We will create an AI player that uses a minimax algorithm to train against 
another instance of the AI class. 

isMaximizingPlayer is something that will be used to denote if the AI is 
the one that will be playing in the game or if it is the AI used for training.



*/
/******************************/
public class AI extends Player{
	boolean isMaximizingPlayer;
	
	
	public AI () {
		this.isRobot=true;			
	}
	
	public AI (boolean ismax) {
		this.isRobot=true;		
		this.isMaximizingPlayer=ismax;		
	}
	/**
	 * Returns set of co-ordinates based on the value of AI.isMax
	 * if isMax is true minmaxxing will be used otherwise a pseudo-random algorithm picks the next move
	 * @return coordinate array where [0]=m and [1] = n
	 */
	public int[] getMove() {
		
		int[] coordinate = new int[2];
		//if easy
		if(!this.isMaximizingPlayer) {
			int maxM = Board.m;
			int maxN = Board.n;
			Random rand = new Random();
			int randM;
			int randN;
			do {
				randM = rand.nextInt(maxM);
				randN = rand.nextInt(maxN);
			}while(Board.gameboard[randM][randN] == 0);
			
			coordinate[0] = randM;
			coordinate[1] = randN;
			return coordinate;
		}
		//else use minmaxxing
		/**TODO**/
		else {
			return coordinate;
		}
		
		
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
