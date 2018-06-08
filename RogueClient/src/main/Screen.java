package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
	private char[][] view;

	public Screen() {
		setBackground(Color.BLACK);
		style = addStyle("style", null);
		StyleConstants.setLineSpacing(style, 0.0f);
		StyleConstants.setForeground(style, Color.WHITE);
		StyleConstants.setFontFamily(style, "monospaced");
		StyleConstants.setFontSize(style, fontHeight);
		setEditable(false);
		setHighlighter(null);
		setParagraphAttributes(style, true);
		setFont(font);
		addKeyListener(new UserInput());

		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				init();
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		
	}

	public void printArray() {
		StyledDocument doc = getStyledDocument();
		StringBuffer buffer = new StringBuffer();
		for (int j = 0; j < view[0].length; j++) {
			for (int i = 0; i < view.length; i++) {
				buffer.append(view[i][j]);
			}
			buffer.append("\n");
		}
		clearScreen();
		try {
			doc.insertString(0, buffer.toString(), style);
		} catch (BadLocationException e) {
			e.printStackTrace();
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
		return (int) (StyleConstants.getFontSize(style) + StyleConstants.getSpaceBelow(style)
				+ StyleConstants.getSpaceAbove(style) + 5);

	}

	public int getViewWidth() {
		return (int) Math.floor(getWidth() / getFontWidth());

	}

	public int getViewHeight() {
		return (int) Math.floor(getHeight() / getFontHeight());
	}

	public void init() {
		view = new char[getViewWidth()][getViewHeight()];
		makeAll();
	}

	public void makeWorldView() {
		World world = ClientMain.getGame().getWorld();
		for (int i = 0; i < view.length; i++) {
			for (int j = 0; j < view[i].length; j++) {
				setCharAt(world.getObjectAt(i, j).getDisplay(), i, j);
			}
		}
	}

	public void setCharAt(char c,int i, int j) {
		view[i][j] = c;
	}

	public void makeAll() {
		makeWorldView();
		printArray();
	}

}