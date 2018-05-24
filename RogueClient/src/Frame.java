import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JTextPane textpane = new JTextPane();
	StyledDocument doc = textpane.getStyledDocument();
	Style style = textpane.addStyle("Style", null);
	
	public Frame() {
		setSize(960, 540);
		setTitle("ROGUE CLONE");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		textpane.setForeground(Color.WHITE);
		textpane.setBackground(Color.BLACK);
		textpane.setText("test");
		
		add(textpane);
		
		
	}

}
