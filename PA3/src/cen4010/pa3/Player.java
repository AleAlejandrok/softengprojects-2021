package cen4010.pa3;

import java.util.Random;

public class Player {
	
	boolean isRobot;
	
	
	Player(boolean robot) {
		this.isRobot = robot;
	}
	
	public boolean isRobot() {
		return this.isRobot;
	}
	
public int[] getMove() {
		
		int[] coordinate = new int[2];
		//get maximums of the board
		int maxM = Board.m;
		int maxN = Board.n;
		//if easy
		

			Random rand = new Random();
			int randM;
			int randN;
			do {
				randM = rand.nextInt(maxM);
				randN = rand.nextInt(maxN);
			}while(Board.gameboard[randM][randN] != 0);
			
			coordinate[0] = randM;
			coordinate[1] = randN;
			return coordinate;
		
		//else use minmaxxing
		/**TODO**/
		
		
		
	}
}
