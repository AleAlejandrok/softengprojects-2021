package cen4010.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import cen4010.pa3.AI;
import cen4010.pa3.Board;

class AItest {

	@Test
	void testAI() {
		AI testAI = new AI();
		if(testAI.isRobot())
			return;
		else
			fail();
	}

	@Test
	void testAIBoolean() {
		AI testAI = new AI(true);
		if(testAI.isMaximizingPlayer)
			return;
		else
			fail();
	}
	/**
	 * getMove() is written in such a way to where it should never give the same position twice. If two AI were to go against
	 * each other the board would fill until the game ends. Without any victory checks though it should work until the board fills.
	 * This test is set up for the 'easy' mode
	 * hard mode to follow
	 */
	@Test
	void testGetMove() {
		AI testAI = new AI(false);
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
