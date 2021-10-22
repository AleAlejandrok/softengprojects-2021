package cen4010.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cen4010.pa2.Board;

class BoardTest {

	@Test
	void testBoard() {
		Board testBoard1 = new Board (3,3);
		if(testBoard1.row == 3 && testBoard1.col == 3)
			return;
		else 
			fail();
	}

	@Test
	void testPlayerWin() {
		//Test cases: set column 1 2 3 to all xs and os, set row 1 2 3 to xs and os, set both diagnals to xs and os,
		fail("Not yet implemented"); // TODO
	}

	@Test
	void testGameDraw() {
		//Fill the board with non-winnable state, test
		fail("Not yet implemented"); // TODO
	}

}
