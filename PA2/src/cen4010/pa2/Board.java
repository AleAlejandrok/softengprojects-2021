package cen4010.pa2;

public class Board {
	public char boardarray[][];
	public int m;
	public int n;
	public static int turn_number=1;
	public Board (int m, int n) {
		this.boardarray=new char [m][n];
		this.m=m;
		this.n=n;
	}
	
	
	
	//handled by button array
	public void playerOneMove(int x, int y) {
		boardarray[x][y]='x';
	//handled by button array
	}
	public void playerTwoMove(int x, int y) {
		boardarray[x][y]='o';
	}

}