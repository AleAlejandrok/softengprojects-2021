package cen4010.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cen4010.pa2.Board;

class BoardTest {

	@Test
	void testBoard() {
		
	
		
	}

	@Test
	void testSetBoard() {
		Board testBoard = new Board(3,3);
		
		int i = 0;
		int j = 0;
		for(i = 0; i < 3; i++);
			for(j = 0; j < 3; j++) {
				Board.gameboard [i] [j] = 'x';
				
			}
		Board.setBoard();
		for(i = 0; i < Board.m; i++);
			for(j = 0; j < Board.n; j++) {
				if(Board.gameboard [i] [j] != 0)
					fail();
			
		}
		return;
	}

	@Test
	void testIsValidMove() {
		fail("Not yet implemented");
	}

	@Test
	void testPlayerWin() {
		fail("Not yet implemented");
	}

	@Test
	void testGameDraw() {
		fail("Not yet implemented");
	}

}
