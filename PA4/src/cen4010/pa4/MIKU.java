package cen4010.pa4;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

public class MIKU extends Theme{
	
	/******CONSTANTS*******/
	final Color accent = new Color (64, 250, 255);
	final Color background = new Color(255,255,255);
	final String PATHTOMIKU = "MIKU.jpeg";
	BufferedImage img; 
	
	
	MIKU(int ThemeCode){
		super(ThemeCode);
		setBackgroundColor(background);
		setElementBackground(accent);
		try {
		    img = ImageIO.read(new File("MIKU.jpeg"));
		} catch (IOException e) {
		}
		JPanel panel = new MIKUPanel();
		panel.setBackground(accent);

		
		
		setPanel(panel);
	}
	
	
	@SuppressWarnings("serial")
	private class MIKUPanel extends JPanel{
		@Override
		  protected void paintComponent(Graphics g) {

		    super.paintComponent(g);
		        g.drawImage(img, 0, 0, null);
		}
	}
}
