package cen4010.pa2;
import javax.swing.*;  
import java.awt.*;


public class GUI extends JFrame {

JFrame f;
public GUI() {
	//tictactoe window
	f=new JFrame();
	//f.setLayout(new BorderLayout());
	Board b=new Board(3,3);
	JButton [][] buttons= new JButton[b.n][b.m];
	JPanel p1 = new JPanel();
	p1.setPreferredSize(new Dimension(400, 400));
	
	
	p1.setLayout(new GridLayout(b.n,b.m,10,10));
	for (int i = 0; i<b.n; i++) {
		for (int j = 0; j<b.m;j++) {
			buttons[i][j]=new JButton();
			p1.add(buttons[i][j]);			
		}
	}
	
	f.add(p1,BorderLayout.CENTER);
	//f.setBounds(400,400,300,300);	
	
	p1.setVisible(true);
	
	f.setSize(600,600);//700 width and 500 height  
	
	
	f.setVisible(true);//making the frame visible  	
}



	  
}

