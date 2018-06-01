import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

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
		setLayout(new BorderLayout());
		add(screen, BorderLayout.CENTER);
		pack();
		
		String[][] testArray = new String[500][500];
		screen.init(testArray);
		
	}

}
