package cen4010.pa4;

public class tictactoe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Board b = new Board(3);
		
		FrameGenerator fg = new FrameGenerator(2);
		
		int dimmensions[] = null;
		try {
			dimmensions = fg.setUpPopup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int m = dimmensions[0];
		int n = dimmensions[1];
		int k = dimmensions[2];
		fg.setTheme(dimmensions[3]);
		
		
		
		
		
		
		GUI g= new GUI(m,n,k);
		g.setDefaultCloseOperation(0);
		
		
	}

}
