package actionmap;

import java.awt.Color;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class ActionFrame extends JFrame {

	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFUALT_HEIGHT = 200;
	public ActionFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_WIDTH);
		buttonPanel = new JPanel();
		
		Action redAction = new ColorAction("RedButton", Color.RED, buttonPanel);
		Action greenAction = new ColorAction("GreenButton", Color.GREEN, buttonPanel);
		Action bulueAction = new ColorAction("BulueButton", Color.BLUE, buttonPanel);
		
		JButton redButton = new JButton(redAction);
		JButton greenButton = new JButton(greenAction);
		JButton bulueButton = new JButton(bulueAction);
		
		buttonPanel.add(redButton);
		buttonPanel.add(greenButton);
		buttonPanel.add(bulueButton);
		
		add(buttonPanel);
		
		InputMap inputMap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		inputMap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		inputMap.put(KeyStroke.getKeyStroke("ctrl G"), "panel.green");
		inputMap.put(KeyStroke.getKeyStroke("ctrl B"), "panel.bulue");
		
		ActionMap actionMap = buttonPanel.getActionMap();
		actionMap.put("panel.red", redAction);
		actionMap.put("panel.green", greenAction);
		actionMap.put("panel.bulue", bulueAction);
	}
	
	
}
