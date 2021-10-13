package cen4010.pa2;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;


import java.awt.*;
import java.awt.event.ActionListener;


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
	JPanel TopPanel = new JPanel();
	
	//this sets the frames orientation... 2 rows, 1 column hence (2,1)
	f.setLayout(new GridLayout(2, 1));

	//sets a grid layout of the panel
	//a panel is like a small window in a window
	//set it to mxn size, with small padding in between the buttons
	TopPanel.setLayout(new GridLayout(b.n,b.m,5,5));
	
	//insets buttons into mxn array and puts them in the panel 
	for (int i = 0; i<b.n; i++) {
		for (int j = 0; j<b.m;j++) {
			buttons[i][j]=new JButton();
			TopPanel.add(buttons[i][j]);
			
			//variables are reassigned to fix scope issue
			int o=i;
			int l=j;
			//defines a new function that will be performed when the button is pressed
			ActionListener AL=new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 //if turn is odd, place an x
		        	 if (b.turn_number%2==1) {
		        		 buttons[o][l].setText("x");
		        		 b.boardarray[o][l]='x';
		        	 }
		        	 else {
		         	buttons[o][l].setText("o");
		         	b.boardarray[o][l]='o';
		        	 }
		        	 //turn incrementer
		         	b.turn_number++;
		          }
		       };
		    //associates the function with the current button in the array 
			buttons[i][j].addActionListener(AL);
	}
	}
	//sets border so there is padding at the top and around the sides
	Border border = TopPanel.getBorder();
	Border margin = new EmptyBorder(50,10,10,10);
	TopPanel.setBorder(new CompoundBorder(border, margin));
	
	//panel for timer and other accessories
	JPanel BottomPanel = new JPanel();
	BottomPanel.setLayout(new GridLayout(2, 1));
	//creates border spacing
	Border border2 = BottomPanel.getBorder();
	Border margin2 = new EmptyBorder(10,150,150,150);
	BottomPanel.setBorder(new CompoundBorder(border2, margin2));
	
	
	JPanel StartGamePanel = new JPanel();
	StartGamePanel.setLayout(new GridLayout(1, 3, 150,10));
	
	//player select 1
	JComboBox player1type= new JComboBox();
	StartGamePanel.add(player1type);
	
	//used to start timer (maybe?)
	JButton StartGameButton= new JButton("Start Game");
	StartGamePanel.add(StartGameButton);
	
	//player select 2
	JComboBox player2type= new JComboBox();
	StartGamePanel.add(player2type);
	
	//add the player select and game start buttons to the bottom half of the screen
	BottomPanel.add(StartGamePanel);
	
	
	//timer panel
	JPanel TimerPanel = new JPanel();
	TimerPanel.setLayout(new GridLayout(1, 2,50,10));
	
	
	//add timer logic
	
	
	
	
	
	
	//add the bottom of the second half to the screen
	BottomPanel.add(TimerPanel);
	
	
	
	
	
	
	
	
	
	
	
	
	
	//sets panels to be visible
	TopPanel.setVisible(true);
	BottomPanel.setVisible(true);
	StartGamePanel.setVisible(true);
	TimerPanel.setVisible(true);
	//adds them to main window, and allows them to take up the whole spot that was allocated to them in f's grid layout
	f.add(TopPanel,BorderLayout.CENTER);
	f.add(BottomPanel,BorderLayout.CENTER);
	
	
	
	//sets size = to 75% of screen size
	f.setSize((int)(width*.75),(int)(height*.75));
	//spawns frame in center of the page
	f.setLocationRelativeTo(null);
	
	//making the frame visible  	
	
	f.setVisible(true);
	
	//end program on close
	f.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent windowEvent){
           System.exit(0);
        }
	});

	}


	  
}


