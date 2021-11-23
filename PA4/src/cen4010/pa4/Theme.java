package cen4010.pa4;
import java.awt.*;

public abstract class Theme {
	
	private int Theme;
	private Color backgroundColor;
	private Color elementColor;

	
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

	
}