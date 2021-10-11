package cen4010.pa2;

public class Board {
	public char boardarray[][];
	public int size;
	public Board (int size) {
		this.boardarray=new char [size][size];
		this.size=size;
	}
	
	public void playerOneMove(int x, int y) {
		boardarray[x][y]='x';

	}
	public void playerTwoMove(int x, int y) {
		boardarray[x][y]='o';
	}

}