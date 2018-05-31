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
	private int fontHeight = 12;
	private Style style; 
	private Font font = new Font("monospaced", Font.PLAIN, 12);
	
	public Screen() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		addStyle("style", null);
		setFont(font);
	}
	
	public void printArray(String[][] world) {
		clearScreen();
		StyledDocument doc = getStyledDocument();

		for (int j = world.length; j > 0; j--) {

			try {
				doc.insertString(0, "\n", null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}

			for (int i = world.length; i > 0; i--) {
				try {
					doc.insertString(0, world[i - 1][j - 1], null);
				} catch (BadLocationException e) {
					e.printStackTrace();
				}
			}
		}


	}

	public void clearScreen() {
		setText("");
	}	
	
	public int getFontWidth() {
		if (fontWidth == -1) {
			BufferedImage bf = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
			FontMetrics fontMetrics = bf.createGraphics().getFontMetrics(font);
			fontWidth = fontMetrics.charWidth('l');
		}
		return fontWidth;
		
	}
	
	public int getFontHeight() {
		return fontHeight;

	}

	public int getViewWidth() {
		return 0;

	}

	public int getViewHeight() {
		return 0;
	}
	
	public void init(String[][] world) {
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[i].length; j++) {
				world[i][j] = ".";
			}
		}
		printArray(world);
	}
	
	
}