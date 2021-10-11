package cen4010.pa2;
import javax.swing.*;  
import java.awt.*;


public class GUI extends JFrame {

JFrame f;
public GUI() {
	//tictactoe window
	f=new JFrame();
	Board b=new Board(3);
	JButton [][] buttons= new JButton[b.size][b.size];
	JPanel p1 = new JPanel();
	p1.setPreferredSize(new Dimension(400, 400));
	
	
	p1.setLayout(new GridLayout(b.size,b.size));
	for (int i = 0; i<b.size; i++) {
		for (int j = 0; j<b.size;j++) {
			buttons[i][j]=new JButton();
			p1.add(buttons[i][j]);
			
		}
	}
	
	f.add(p1);
	p1.setVisible(true);
	
	f.setSize(600,600);//700 width and 500 height  
	
	
	f.setVisible(true);//making the frame visible  	
}



	  
}

