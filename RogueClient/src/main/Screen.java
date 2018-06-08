package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import game.World;
import transfer.P;

public class Screen extends JTextPane {

	private static final long serialVersionUID = 1L;

	private int fontWidth = -1;
	private int fontHeight = 12;
	private Style style;
	private Font font = new Font("monospaced", Font.PLAIN, fontHeight);
	private String[][] view;

	public Screen() {
		setBackground(Color.BLACK);
		style = addStyle("style", null);
		StyleConstants.setLineSpacing(style, 0);
		StyleConstants.setForeground(style, Color.WHITE);
		StyleConstants.setFontFamily(style, "monospaced");
		StyleConstants.setFontSize(style, fontHeight);
		setParagraphAttributes(style, true);
		setFont(font);
		
		addKeyListener(new UserInput());
		
		addMouseWheelListener(new MouseWheelListener() {
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent arg0) {
				StyleConstants.setFontSize(style, fontHeight++);
				init();
			}
		});
	}

	public void printArray() {
		clearScreen();
		StyledDocument doc = getStyledDocument();

		for (int j = view[0].length - 1; j >= 0; j--) {
			try {
				doc.insertString(0, "\n", null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			for (int i = view.length - 1; i >= 0; i--) {
				try {
					if (ClientMain.getConnection().connected) {
						
					}
					
					doc.insertString(0, view[i][j], style);
					
					
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
		System.out.println(StyleConstants.getFontSize(style));
		return fontHeight + 5;

	}

	public int getViewWidth() {
		return (int) Math.floor(getWidth() / getFontWidth());

	}

	public int getViewHeight() {
		return (int) Math.floor(getHeight() / getFontHeight());
	}
	
	public void init() {
		view = new String[getViewWidth()][getViewHeight()];
		makeWorldView(null);
		System.out.println(getViewWidth() + "   " + getViewHeight());
	}
	
	public void makeWorldView(String[][] world) {
		
		for (int i = 0; i < view.length; i++) {
			for (int j = 0; j < view[i].length; j++) {
				view[i][j] = "o";
			}
		}
		
		printArray();
	}
	
	public void setChar() {
		
	}

}