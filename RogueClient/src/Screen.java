import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class Screen extends JTextPane {

	private static final long serialVersionUID = 1L;

	private int fontWidth = -1;
	private Style style;
	private Font font = new Font("monospaced", Font.PLAIN, 12);

	public Screen() {
		setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		addStyle("style", null);
		// setFont(new Font("monospaced", Font.PLAIN, 12));
		setFont(font);
	}

	public void printArray(String[][] world) {
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
		if (getWidth() != 0) {
			for (int i = 0; i < world.length; i++) {
				for (int j = 0; j < world[i].length; j++) {
					world[i][j] = ".";
				}
			}

		}
		System.out.println(getWidth() + "   " + getHeight());
	}

}
