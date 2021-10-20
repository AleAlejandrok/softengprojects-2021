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

}