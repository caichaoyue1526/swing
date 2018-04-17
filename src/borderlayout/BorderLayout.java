package borderlayout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayout {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				BorderLayoutFrame blf = new BorderLayoutFrame();
				blf.setVisible(true);
				blf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}

class BorderLayoutFrame extends JFrame {
	JPanel buttonPanel;
	public BorderLayoutFrame() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = screenSize.width/2;
		int height = screenSize.height/2;
		setSize(width, height);
		setVisible(true);
		
		buttonPanel = new JPanel();
		buttonPanel.add(new JButton("aaa"));
		buttonPanel.add(new JButton("bbb"));
		buttonPanel.add(new JButton("ccc"));
		
		setLayout(new java.awt.BorderLayout());
		
		add(buttonPanel, java.awt.BorderLayout.SOUTH);
	}
}