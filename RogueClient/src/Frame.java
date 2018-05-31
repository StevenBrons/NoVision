import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.text.StyledDocument;

public class Frame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private Screen screen = new Screen();
//	private StyledDocument doc = screen.getStyledDocument();
//	Style style = textpane.addStyle("Style", null);
	
	public Frame() {
		setSize(960, 540);
		setMinimumSize(new Dimension(960, 540));
		setTitle("ROGUE CLONE");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
//		setLayout(new BorderLayout());
		
//		add(screen,BorderLayout.CENTER);
		add(screen);
		pack();
		
		String[][] test = new String[5][5];
		screen.setupenzo(test);
		
		
//		Scanner s = new Scanner(System.in);
//		int temp1 = s.nextInt();
//		int temp2 = s.nextInt();
//		String temp3 = s.next();
//		test[temp1][temp2] = temp3;
//		
//		screen.printArray(test);
		
		
		
	}

}
