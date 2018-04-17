package radiobutton;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioButton {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				CheckBoxFrame cbf = new CheckBoxFrame();
				cbf.setVisible(true);
				cbf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}


class CheckBoxFrame extends JFrame {
	
	private JPanel buttonPanel;
	private ButtonGroup group;
	private JLabel label;
	private static final int DEFAULT_SIZE = 36;
	
	public CheckBoxFrame() {
		label = new JLabel("1234567890");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		
		addRadioButton("small", 8);
		addRadioButton("medium", 12);
		addRadioButton("large", 18);
		addRadioButton("extra large", 36);
		
		add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
		
	}

	private void addRadioButton(String string, int i) {
		boolean selected = i == DEFAULT_SIZE;
		JRadioButton button = new JRadioButton(string, selected);
		group.add(button);
		buttonPanel.add(button);
		
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				label.setFont(new Font("Serif", Font.PLAIN, i));
			}
		});
	}
	
}