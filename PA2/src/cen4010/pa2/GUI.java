package cen4010.pa2;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.DimensionUIResource;


import java.awt.*;


public class GUI extends JFrame {

JFrame f;
public GUI() {
	//the window
	f=new JFrame();
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
	int height = screenSize.height;
	int width = screenSize.width;
	//instantiation of the board object
	Board b=new Board(3,3);
	
	//array of buttons that will be used to place x's and o's
	JButton [][] buttons= new JButton[b.n][b.m];
	
	//this is the array of buttons that makes the visualization of the board 
	JPanel p1 = new JPanel();
	
	//this sets the frames orientation... 2 rows, 1 column hence (2,1)
	f.setLayout(new GridLayout(2, 1));

	//sets a grid layout of the panel
	//a panel is like a small window in a window
	//set it to mxn size, with small padding in between the buttons
	p1.setLayout(new GridLayout(b.n,b.m,5,5));
	
	//insets buttons into mxn array and puts them in the panel 
	for (int i = 0; i<b.n; i++) {
		for (int j = 0; j<b.m;j++) {
			buttons[i][j]=new JButton();
			p1.add(buttons[i][j]);	
			
		}
	}
	//sets border so there is padding at the top and around the sides
	Border border = p1.getBorder();
	Border margin = new EmptyBorder(50,10,10,10);
	p1.setBorder(new CompoundBorder(border, margin));
	
	//panel for timer and other accessories
	JPanel p2 = new JPanel();
	
	
	
	//that work goes here
	
	
	
	
	
	
	//sets panels to be visible
	p1.setVisible(true);
	p2.setVisible(true);
	//adds them to main window, and allows them to take up the whole spot that was allocated to them in f's grid layout
	f.add(p1,BorderLayout.CENTER);
	f.add(p2,BorderLayout.CENTER);
	
	//sets size = to 75% of screen size
	f.setSize((int)(width*.75),(int)(height*.75));
	//spawns frame in center of the page
	f.setLocationRelativeTo(null);
	
	//making the frame visible  	
	
	f.setVisible(true);
	}


	  
}

