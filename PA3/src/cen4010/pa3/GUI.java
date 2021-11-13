package cen4010.pa3;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class GUI extends JFrame {
Board b;
JFrame Frame;
JLabel timeDisplay1;
JLabel timeDisplay2;
Boolean game_started=false;
Boolean game_stopped=false;
public static int StartingTime=60;
public static int player1time=StartingTime;
public static int player2time=StartingTime;

	
	
	
	
	
	  
	  
	  
		  //player 1 timer
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
		  
		  
		  //player 2 timer
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
	int m;
	int n;
	int k;
	/******create mxn question popup********/
	
	int dimmensions[]= dimmensionPopup();
	m = dimmensions[0];
	n = dimmensions[1];
	k = dimmensions[2];
	//ensure k is doable
	if(k > m && k > n)
		k = Math.min(m, n);
	
	
	
	
	Board.createBoard(m, n, k);
	JButton [][] buttons= new JButton[Board.m][Board.n];
	/******************End Board Instantiation************************/
	
	
	/******************Top Panel************************/
	JPanel TopPanel = new JPanel();
	TopPanel.setLayout(new GridLayout(Board.m,Board.n,10,10));
	TopPanel.setBackground(new Color(40,40,40));
	TopPanel.setPreferredSize(new Dimension(100,100));
	
	for (int i = 0; i<Board.m; i++) {
		for (int j = 0; j<Board.n;j++) {
			buttons[i][j]=new JButton();
			buttons[i][j].setBackground(Color.white);
			buttons[i][j].setOpaque(true);
			buttons[i][j].setBorderPainted(false);
			buttons[i][j].setFocusPainted(false);
			TopPanel.add(buttons[i][j]);
			
			//variables are reassigned to fix scope issue
			int o=i;
			int l=j;
			//defines a new function that will be performed when the button is pressed
			ActionListener ButtonAL=new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 
		        	 
		        	 
		        	 if (Board.gameboard[o][l]==0 && game_started) {
		        		
		        		 
		        		 
		        		 
		        		//if turn is odd, place an x	 
		        	 if (Board.turn_number%2==1) {
		        		 buttons[o][l].setText("X");
		        		 buttons[o][l].setFont(new Font("Montserrat", Font.BOLD, 42));
		        		 Board.gameboard[o][l]='x';
		        		 
		        		 
		        		 timer1.stop();
		        		 timer2.start();
		        		 
		        		 
		        		 //if player2 is a robot... do turn... increment turn number
//		        		 if (player2.isRobot()) {
//			        		 int [] xy =player2.getMove();
//			        		 char x= xy[0];
//				     		 char y= xy[1];
//				     		 buttons[x][y].setText("X");
//				     		 Board.gameboard[x][y]='x';
//				     		 buttons[o][l].setFont(new Font("Montserrat", Font.BOLD, 42));
//			        		 Board.turn_number++;
//			        		 }
		        		 
		        		 
		        		 //player 1 timeout
		        		 if (player1time==0) {
		        			 for (int i = 0; i<Board.m; i++) {
					        		for (int j = 0; j<Board.n;j++) {
					        			buttons[i][j].setEnabled(false);
					        		}
		        			 }
		        			 PopupWin("-2");
		        			 	game_stopped=true;
				         		timer1.stop();
				        		timer2.stop();

			        		}
		        		 //if game is still going... check if the game is over
		        		 else
		        		 if (Board.playerWin('x')) {
		        			 for (int i = 0; i<Board.m; i++) {
					        		for (int j = 0; j<Board.n;j++) {
					        			buttons[i][j].setEnabled(false);
					        		}
		        			 }
		        			 PopupWin("1");
		        			 game_stopped=true;
				         		timer1.stop();
				        		timer2.stop();
				         	}
		        		 	else if (Board.gameDraw()) {				         		
				         		for (int i = 0; i<Board.m; i++) {
					        		for (int j = 0; j<Board.n;j++) {
					        			buttons[i][j].setEnabled(false);
					        		}
				         		}
				         		PopupWin("0");
				         		game_stopped=true;
				         		timer1.stop();
				        		timer2.stop();
				         	}
				         	
				         	
		        	 
		        	 }
		        	 //player 2 move
		        	 else {
		        		 
		         	buttons[o][l].setText("O");
		         	Board.gameboard[o][l]='o';
		         	buttons[o][l].setFont(new Font("Montserrat", Font.BOLD, 42));
		         	
		         	//if player1 is a robot... do turn... increment turn number
		         	
//		         	if (player1.isRobot()) {
//		         	 int [] xy = player1.getMove();
//	        		 char x= xy[0];
//		     		 char y= xy[1];
//		     		 buttons[x][y].setText("O");
//		     		 Board.gameboard[x][y]='o';
//		     		 buttons[o][l].setFont(new Font("Montserrat", Font.BOLD, 42));
//		     		 Board.turn_number++;
//		         	}
		         	
		         	//(harder AI) loop checking all spaces for a winning combo for either player
		                  	
		         	
		         	 timer2.stop();
	        		 timer1.start();
	        		 //player 2 timeout
	        		 if (player2time==0) {
	        			 for (int i = 0; i<Board.m; i++) {
				        		for (int j = 0; j<Board.n;j++) {
				        			buttons[i][j].setEnabled(false);
				        		}
	        			 }
	        			 PopupWin("-1");
	        			 game_stopped=true;
			         		timer1.stop();
			        		timer2.stop();

		        		}
	        		 else //this else is to prevent a player from running out of time, then placing a winning move after.
	        		 if (Board.playerWin('o')) {
	        			 for (int i = 0; i<Board.m; i++) {
				        		for (int j = 0; j<Board.n;j++) {
				        			buttons[i][j].setEnabled(false);
				        		}
	        			 }
	        			 PopupWin("2");
	        			 game_stopped=true;
			         		timer1.stop();
			        		timer2.stop();
			         	}
	        		 	else if (Board.gameDraw()) {				         		
			         		for (int i = 0; i<Board.m; i++) {
				        		for (int j = 0; j<Board.n;j++) {
				        			buttons[i][j].setEnabled(false);
				        		}
			         		}
			         		PopupWin("0");
			         		game_stopped=true;
			         		timer1.stop();
			        		timer2.stop();
			         	}
			         	
		        	 }
		         	Board.turn_number++;
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
	
	String[] player_list = {"Human", "Computer"};
	JComboBox<?> PlayerList1 = new JComboBox<Object>(player_list);
	PlayerList1.setFocusable(false);
	JComboBox<?> PlayerList2 = new JComboBox<Object>(player_list);
	PlayerList2.setFocusable(false);
	JButton StartButton = new JButton("Start");
	StartButton.setBackground(new Color(200,200,200));
	StartButton.setOpaque(true);
	BottomPanel.add(PlayerList1);
	BottomPanel.add(StartButton);
	BottomPanel.add(PlayerList2);

	/*********TODO************/
	
	 ActionListener StartGameAL = new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	if (!game_stopped)
	        	 {
	        		 timer1.start();
		        	 game_started=true; 
		        	 
		        	 
		        	 //instantiate the players as robots or real players
		        	 //player1
		        	 //player2
		        	 
		        	 
		        	 
		        	//if (player1 and player 2 are robots){
		        	 //play the whole game in a loop in this if statement
		        	 //}
		        	 
		        	 
		        	 
		        	 
		        	 
		        	 
		        	 
	        	 }
	            
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

	/**
	 * Creates a scuffed dimmension popup
	 * @return a 2 long array with dimmensions for the gameboard and a 3rd position for k
	 * TODO: check to make sure the textboxes only take integers
	 */
	private int[] dimmensionPopup() {
		int m = 3;
		int n = 3; 
		int k = 3;
		
		//****FRAME****//
		JFrame Popup = new JFrame("Select dimmensions");
		Popup.setSize(400,200);
		Popup.setResizable(false);
		Popup.setLocationRelativeTo(null);
		Popup.setLayout(new GridLayout(4, 2));
		
		
		//****Text Fields****//
		JTextField mField = new JTextField(1);
		JTextField nField = new JTextField(1);
		JTextField kField = new JTextField(1);
		JLabel mLabel = new JLabel("M:");
		JLabel nLabel = new JLabel("N:");
		JLabel kLabel = new JLabel("K:");
		mLabel.setAlignmentX(1);
		nLabel.setAlignmentX(1);
		kLabel.setAlignmentX(1);
		mLabel.setAlignmentY(0);
		nLabel.setAlignmentY(50);
		kLabel.setAlignmentY(100);
		mField.setAlignmentX(50);
		nField.setAlignmentX(50);
		kField.setAlignmentX(50);
		mField.setAlignmentY(0);
		nField.setAlignmentY(50);
		kField.setAlignmentY(100);
		
		JButton submitButton = new JButton();
		submitButton.setBounds(150, 100, 100, 20);
		submitButton.setFont(new Font("DIALOG", Font.BOLD, 15));
		submitButton.setText("Submit");
		submitButton.setFocusPainted(false);
		submitButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	
	        	 Popup.dispose();
	        	 //GUI g= new GUI();
	        	 // DO RESET
	          }
	       	        
	       });
		 Popup.add(mLabel);
     	 Popup.add(mField);
     	 
     	Popup.add(nLabel);
     	 Popup.add(nField);
     	
     	 
    	 
    	 Popup.add(kLabel);
    	 Popup.add(kField);
     	 Popup.add(submitButton);
     	 
     	 Popup.setVisible(true);
     	 while(Popup.isDisplayable()) {
     		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
     	 }
     	 try {
			m = Integer.valueOf(mField.getText());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			m =3;
		}
     	 try {
			n = Integer.valueOf(nField.getText());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			n = 3;
		}
     	 try {
			k = Integer.valueOf(kField.getText());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			k = 3;
		}
		int dimmensionArray[] = {m,n,k};
		return dimmensionArray;
	}
	//****Popup Win Frame****//
	private void PopupWin(String player) {
		
		//****FRAME****//
		Frame = new JFrame("Congratulations!");
		Frame.setSize(400,200);
		Frame.setResizable(false);
		Frame.setLocationRelativeTo(null);
		Frame.setLayout(new GridLayout(1, 1));
		
		//****TEXT LABEL****//
	
		JLabel Text = new JLabel();
		//Text.setBounds(0, 100, 400, 100);
		Text.setHorizontalAlignment(SwingConstants.CENTER);
		Text.setFont(new Font("DIALOG", Font.BOLD, 14));
		
		
		if (player.equals("-2")) {
			Frame.setTitle("Too slow...");
			Text.setText("Player 1 ran out of time... Player 2 wins!");
		}
		else
		if (player.equals("-1")) {
			Frame.setTitle("Too slow...");
			Text.setText("Player 2 ran out of time... Player 1 wins!");
		}
		else
		if (player.equals("0")) {
			Frame.setTitle("Game Over...");
			Text.setText("The game has drawn.");
		}
		else {
		Text.setText("Congratulations, player \"" + player + "\" has won!");
		}
		//****RESET BUTTON****//
		JButton ResetButton = new JButton();
		ResetButton.setBounds(150, 100, 100, 20);
		ResetButton.setFont(new Font("DIALOG", Font.BOLD, 15));
		ResetButton.setText("RESET");
		ResetButton.setFocusPainted(false);
		ResetButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 Frame.dispose();
	        	 //GUI g= new GUI();
	        	 // DO RESET
	          }
	        
	       });
		
		//****DRAW FRAME****//
		Frame.add(Text);
		//Frame.add(ResetButton);
		Frame.setVisible(true);
	}
	//**********************//
}

