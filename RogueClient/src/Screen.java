import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.image.BufferedImage;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class Screen extends JTextPane{

	private static final long serialVersionUID = 1L;
	
	private int fontWidth = -1;
	private Style style; 
	private Font font = new Font("monospaced", Font.PLAIN, 12);
	
	public Screen() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
//		addStyle("style", null);
//		setFont(new Font("monospaced", Font.PLAIN, 12));
//		setFont(font);
//		System.out.println(getFontWidth());
		
		
	}
	
	public void printArray(String[][] world) {
		StyledDocument doc = getStyledDocument();
		for (int j = world.length; j >= 0; j--) {
			try {
				doc.insertString(0, "\n", null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			for (int i = world.length; i >= 0; i--) {
				try {
					doc.insertString(0, Integer.toString(i), null);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		}

	}


	public int getFontWidth() {
		if (fontWidth == -1) {
			BufferedImage bf = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
			FontMetrics fontMetrics = bf.createGraphics().getFontMetrics(font);
			fontWidth = fontMetrics.charWidth('l');
		}
		return fontWidth;
		
	}
	
	public void setupenzo(String[][] world) {
		printArray(world);
//		if (getWidth() != 0) {
//			for (int i = 0; i < world.length; i++) {
//				for (int j = 0; j < world[i].length; j++) {
//					world[i][j] = ".";
//				}
//			}
//
//		}
//		System.out.println(getWidth() + "   " + getHeight());
	}
	
	
}