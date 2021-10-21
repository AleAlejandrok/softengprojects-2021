package cen4010.pa2;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;


public class GUI extends JFrame {

JFrame Frame;
JLabel timeDisplay1;
JLabel timeDisplay2;
public static int StartingTime=60;
public static int player1time=StartingTime;
public static int player2time=StartingTime;
Instant start = Instant.now();
//long start = System.nanoTime();
//add timer instantiation 
	
	
	
	
	
	
	  ActionListener gameEnderAL2 = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	            //end the game

	            
	        }
		  };
	  
	  
		  
		  Timer timer1 = new Timer(1000, new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  if (player1time>0)
		          {
		      
		    		  player1time--;
			          timeDisplay1.setText(player1time+"");
			          repaint();
		    	  }
		     }
		  });
		  
		  
		  
		  Timer timer2 = new Timer(1000, new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  if (player2time>0)
		          {
		      
		    		  player2time--;
			          timeDisplay2.setText(player2time+"");
			          repaint();
		    	  }
		      }
		  });


public GUI() {
	/******************Frame Settings************************/
	Frame=new JFrame();
	Frame.setTitle("Tic Tac Toe");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
	int height = screenSize.height;
	int width = screenSize.width;
	Frame.setResizable(false);
	Frame.setLayout(new GridLayout(2, 1));
	Frame.setSize((int)(width*.75),(int)(height*.75));
	Frame.setLocationRelativeTo(null);
	Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	/******************End Frame Settings************************/
	
	
	
	
	/******************Board Instantiation************************/
	Board b=new Board(3,3);
	JButton [][] buttons= new JButton[b.row][b.col];
	/******************End Board Instantiation************************/
	
	
	/******************Top Panel************************/
	JPanel TopPanel = new JPanel();
	TopPanel.setLayout(new GridLayout(b.row,b.col,10,10));
	TopPanel.setBackground(new Color(40,40,40));
	TopPanel.setPreferredSize(new Dimension(100,100));
	
	for (int i = 0; i<b.row; i++) {
		for (int j = 0; j<b.col;j++) {
			buttons[i][j]=new JButton();
			buttons[i][j].setBackground(Color.white);
			buttons[i][j].setOpaque(true);
			buttons[i][j].setBorderPainted(false);
			TopPanel.add(buttons[i][j]);
			
			//variables are reassigned to fix scope issue
			int o=i;
			int l=j;
			//defines a new function that will be performed when the button is pressed
			ActionListener ButtonAL=new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 //if turn is odd, place an x
		        	 if (b.gameboard[o][l]==0) {
		        	 if (b.turn_number%2==1) {
		        		 buttons[o][l].setText("x");
		        		 b.gameboard[o][l]='x';

		        		 timer1.stop();
		        		 timer2.start();		    
		        		 
		        	 }
		        	 else {
		         	buttons[o][l].setText("o");
		         	b.gameboard[o][l]='o';
		         	
		         	
		         	 timer2.stop();
	        		 timer1.start();
		         	
		         	
		         	
		         	
		        	 }
		         	b.turn_number++;
		          }
		         }
		       };
			buttons[i][j].addActionListener(ButtonAL);
	}
	}
	/******************End Top Panel************************/
	
	/******************Bottom Panel************************/
	JPanel BottomPanel = new JPanel();
	BottomPanel.setLayout(new GridLayout(2, 1,50,50));
	//creates border spacing
	Border border2 = BottomPanel.getBorder();
	Border margin2 = new EmptyBorder(10,150,150,150);
	BottomPanel.setBorder(new CompoundBorder(border2, margin2));
	
	
	
	/*Start game and player select panel*/
	JPanel StartGamePanel = new JPanel();
	StartGamePanel.setLayout(new GridLayout(1, 3, 150,10));
	
	String[] player_list = {"Human"};
	JComboBox PlayerList1 = new JComboBox(player_list);
	JComboBox PlayerList2 = new JComboBox(player_list);
	JButton StartButton = new JButton("Start");
	StartButton.setBackground(new Color(200,200,200));
	StartButton.setOpaque(true);
	BottomPanel.add(PlayerList1);
	BottomPanel.add(StartButton);
	BottomPanel.add(PlayerList2);

	
	 ActionListener StartGameAL = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	 timer1.start();
	        	 
	            
	        }
		  };
	StartButton.addActionListener(StartGameAL);

	//add the player select and game start buttons to the bottom half of the screen
	BottomPanel.add(StartGamePanel);
	/*End start game and player select panel*/
	
	
	
	/*Timer Panel*/
  	JPanel TimerPanel = new JPanel();
  	TimerPanel.setLayout(new GridLayout(1, 2,50,10));
  	
  	//Time display for player 1
    timeDisplay1=new JLabel(StartingTime+"");
   
    timeDisplay1.setHorizontalAlignment(SwingConstants.CENTER);
    timeDisplay1.setFont(new Font("DIALOG", Font.BOLD, 28));
    timeDisplay1.setBackground(new Color(200,200,200));
    timeDisplay1.setOpaque(true);
    
    //Time display for player 2
    timeDisplay2=new JLabel(StartingTime+"");
    
    timeDisplay2.setHorizontalAlignment(SwingConstants.CENTER);
    timeDisplay2.setFont(new Font("DIALOG", Font.BOLD, 28));
    timeDisplay2.setBackground(new Color(200,200,200));
    timeDisplay2.setOpaque(true);
    
    TimerPanel.add(timeDisplay1);
    TimerPanel.add(timeDisplay2);
    BottomPanel.add(TimerPanel);
    /*End Timer Panel*/
    /******************End Bottom Panel************************/
	
	
	
	
	
	
	
	
	
	
	
	
	//set visible
	Frame.add(TopPanel);
	Frame.add(BottomPanel);
	Frame.setVisible(true);
	
	}


	  
}


