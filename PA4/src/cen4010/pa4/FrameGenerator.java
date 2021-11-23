package cen4010.pa4;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameGenerator {
	Theme theme = null;
	
	
	void setTheme(int themeCode) {
		switch(themeCode) {
		case 0:
			this.theme= new DefaultTheme(0);
			break;
		case 1:
			this.theme= new DarkMode(1);
			break;
		case 2: 
			//add waifu
			break;
		default:
			break;
		}
		
	}
	
	FrameGenerator(int themeCode){
		switch(themeCode) {
		case 0:
			this.theme= new DefaultTheme(0);
			break;
		case 1:
			this.theme= new DarkMode(1);
			break;
		case 2: 
			this.theme = new MIKU(2);
			break;
		default:
			break;
		}
		
		
			
	}
	
	public int[] setUpPopup() {
		int m = 3;
		int n = 3; 
		int k = 3;
		
		//****FRAME****//
		JFrame Popup = new JFrame("Setup Game!");
		JPanel PopupPanel = new JPanel();
		String pathToFileOnDisk="TicTacToe.png";
		ImageIcon img = new ImageIcon(pathToFileOnDisk);
		
		String[] themeOptions = {"Default", "Hatsune Miku", "Dark Mode"};
		JComboBox<String> themeDropDown = new JComboBox<>(themeOptions);
		themeDropDown.setSelectedIndex(0);
		
		PopupPanel = this.theme.getPanel();
		
		
		
		
		Popup.setIconImage(img.getImage());
		Popup.setSize(400,200);
		Popup.setResizable(false);
		Popup.setLocationRelativeTo(null);
		Popup.setLayout(new GridLayout(4, 2));
		
		
		//****Text Fields****//
		JTextField mField = new JTextField(1);
		JTextField nField = new JTextField(1);
		JTextField kField = new JTextField(1);
		JLabel themeLabel = new JLabel("Theme:");
		JLabel mLabel = new JLabel("M:");
		JLabel nLabel = new JLabel("N:");
		JLabel kLabel = new JLabel("K:");
		themeLabel.setAlignmentX(1);
		themeLabel.setAlignmentY(0);
		themeDropDown.setAlignmentX(50);
		themeDropDown.setAlignmentY(0);
		mLabel.setAlignmentX(1);
		nLabel.setAlignmentX(1);
		kLabel.setAlignmentX(1);
		mLabel.setAlignmentY(50);
		nLabel.setAlignmentY(100);
		kLabel.setAlignmentY(150);
		mField.setAlignmentX(50);
		nField.setAlignmentX(50);
		kField.setAlignmentX(50);
		mField.setAlignmentY(50);
		nField.setAlignmentY(100);
		kField.setAlignmentY(150);
		
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
		PopupPanel.add(themeLabel);
		PopupPanel.add(themeDropDown);
		
		 PopupPanel.add(mLabel);
     	 PopupPanel.add(mField);
     	 
     	PopupPanel.add(nLabel);
     	 PopupPanel.add(nField);
     	
     	 
    	 
    	 PopupPanel.add(kLabel);
    	 PopupPanel.add(kField);
     	 PopupPanel.add(submitButton);
     	 Popup.add(PopupPanel);
     	 Popup.setVisible(true);
     	 while(PopupPanel.isDisplayable()) {
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
     	int theme = themeDropDown.getSelectedIndex();
		int dimmensionArray[] = {m,n,k,theme};
		return dimmensionArray;
	}
}
