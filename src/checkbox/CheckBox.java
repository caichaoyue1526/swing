package checkbox;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckBox {

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
	
	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	private static final int FONTSIZE = 24;
	
	public CheckBoxFrame() {
		label = new JLabel("abcdefgh");
		label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
		
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int mode = 0;
				if(bold.isSelected()) {
					mode += Font.BOLD;
				}
				if(italic.isSelected()) {
					mode += Font.ITALIC;
				}
				label.setFont(new Font("Serif", mode, FONTSIZE));
			}
		};
		
		JPanel buttonPanel = new JPanel();
		
		bold = new JCheckBox("Bold");
		bold.addActionListener(actionListener);
		//bold.setSelected(true);
		italic = new JCheckBox("Italc");
		italic.addActionListener(actionListener);
		
		buttonPanel.add(bold);
		buttonPanel.add(italic);
		
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	}
	
}
