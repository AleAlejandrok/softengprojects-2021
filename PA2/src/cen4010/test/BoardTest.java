package cen4010.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cen4010.pa2.Board;

class BoardTest {

	@Test
	void testBoard() {
		
	
		
	}



	@Test
	void testPlayerWin() {
		Board testBoard = new Board(3,3);
		Board.gameboard [0] [1] = 'x';
		Board.gameboard [0] [2] = 'x';
		Board.gameboard [0] [3] = 'x';
		if(Board.playerWin('x'))
			return;
		else 
			fail();
	}

	@Test
	void testGameDraw() {
		fail("Not yet implemented");
	}

}
