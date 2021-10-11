package cen4010.pa2;

public class Board {
	public char boardarray[][];
	public int m;
	public int n;
	public Board (int m, int n) {
		this.boardarray=new char [m][n];
		this.m=m;
		this.n=n;
	}
	
	public void playerOneMove(int x, int y) {
		boardarray[x][y]='x';

	}
	public void playerTwoMove(int x, int y) {
		boardarray[x][y]='o';
	}

}