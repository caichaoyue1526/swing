package actionmap;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;

public class ColorAction extends AbstractAction {

	private JPanel buttonPanel;
	public ColorAction(String name, Color c, JPanel buttonPanel) {
		putValue(Action.NAME, name);
		putValue("color", c);
		this.buttonPanel = buttonPanel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Color c = (Color) getValue("color");
		buttonPanel.setBackground(c);
	}

}
