package cen4010.pa4;
import java.awt.*;

import javax.swing.JPanel;

public abstract class Theme {
	
	private int Theme;
	private Color backgroundColor;
	private Color elementColor;
	private JPanel Panel = new JPanel();
	
	Theme(int themeCode){
		this.Theme = themeCode;
	}
	
	int getTheme() {
		return this.Theme;
		};
	
	void setBackgroundColor(Color color) {
		this.backgroundColor = color;
	}
	void setElementBackground(Color color) {
		this.elementColor = color;
	}
	
	Color getBackgroundColor() {
		
		return this.backgroundColor;
	}
	
	Color getElementColor() {
		return this.elementColor;
	}

	public JPanel getPanel() {
		return Panel;
	}

	public void setPanel(JPanel panel) {
		Panel = panel;
	}

	
}