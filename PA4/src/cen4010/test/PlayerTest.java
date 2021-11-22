package cen4010.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import cen4010.pa3.Board;
import cen4010.pa3.Player;

class PlayerTest {

	@Test
	void testIsRobot() {
		Player testPlayer = new Player(true);
		if(testPlayer.isRobot())
			return;
		else
			fail();
	}

	@Test
	
	void testGetMove() {
		Player testAI = new Player(true);
		Random rand = new Random();
		int dimM = rand.nextInt(100);
		int dimN = rand.nextInt(100);
		Board.createBoard(dimM, dimN, 5);
		int[] moveResult = new int[2];
		for(int i = 0; i < dimM*dimN; i++) {
			moveResult = testAI.getMove();
			Board.gameboard[moveResult[0]][moveResult[1]] = 'x';
			System.out.println("Testing " + moveResult[0] + " "+ moveResult[1]);
		}
		for(int i = 0; i < dimM; i++) {
			for(int j = 0; j < dimN; j++) {
				if(Board.gameboard[i][j] != 'x')
					fail();
			}
				
		}
		return;
			
	
	}


}
