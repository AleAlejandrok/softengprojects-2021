package cen4010.pa4;

import java.awt.Color;

import javax.swing.JPanel;


public class DarkMode extends Theme {
	
	DarkMode(int themeCode) {
		super(themeCode);
		// TODO Auto-generated constructor stub
		setBackgroundColor(new Color(64,73,98));
		setElementBackground(new Color (63,73, 255));
		JPanel panel = new JPanel();
		panel.setBackground(getBackgroundColor());
		setPanel(panel);
		
	}

}
