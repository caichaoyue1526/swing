package mouse;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MouseFrame extends JFrame {

	public MouseFrame() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		setSize(screenSize.width/2, screenSize.height/2);
		add(new MouseCompment());
		//pack();
	}
}
