package cen4010.pa3;

public class tictactoe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Board b = new Board(3);
		int dimmensions[] = null;
		try {
			dimmensions = GUI.setUpPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int m = dimmensions[0];
		int n = dimmensions[1];
		int k = dimmensions[2];
		int theme = dimmensions[3];
		GUI g= new GUI(m,n,k,theme);
		g.setDefaultCloseOperation(0);
		
		
	}

}
