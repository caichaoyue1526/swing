package textchange;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ColorFrame extends JFrame {

	private JPanel panel;
	private JTextField redField;
	private JTextField greenField;
	private JTextField bulueField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ColorFrame colorFrame = new ColorFrame();
				colorFrame.setVisible(true);
				colorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
	
	public ColorFrame() {
		
		panel = new JPanel();
		panel.add(new JLabel("red:"));
		redField = new JTextField("255", 3);
		redField.getDocument().addDocumentListener(listener);
		panel.add(redField);
		panel.add(new JLabel("green:"));
		greenField = new JTextField("255", 3);
		greenField.getDocument().addDocumentListener(listener);
		panel.add(greenField);
		panel.add(new JLabel("bulue:"));
		bulueField = new JTextField("255", 3);
		bulueField.getDocument().addDocumentListener(listener);
		panel.add(bulueField);
		
		add(panel);
		
		pack();
		
	}

	protected void setColor() {
		try {
			panel.setBackground(new Color(Integer.parseInt(redField.getText().trim()), Integer.parseInt(greenField.getText().trim()), Integer.parseInt(bulueField.getText().trim())));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	DocumentListener listener = new DocumentListener() {
		@Override
		public void removeUpdate(DocumentEvent e) {
			setColor();
		}
		@Override
		public void insertUpdate(DocumentEvent e) {
			setColor();
		}
		@Override
		public void changedUpdate(DocumentEvent e) {
		}
	};
}
