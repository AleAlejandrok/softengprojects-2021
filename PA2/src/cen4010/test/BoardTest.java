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
		testBoard.gameboard [0] [0] = 'x';
		testBoard.gameboard [0] [1] = 'x';
		testBoard.gameboard [0] [2] = 'x';
		if(Board.playerWin('x'))
			return;
		else 
			fail();
	}

	@Test
	void testGameDraw() {
		Board testBoard = new Board(3,3);
		int i;
		int j;
		for(i=0; i < Board.m; i++)
			for(j= 0; j<Board.n; j++)
				Board.gameboard[i][j]= 'z';
		if(Board.gameDraw())
			return;
		else
			fail();
		
	}

}
