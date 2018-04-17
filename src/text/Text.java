package text;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Text {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				TextFrame tf = new TextFrame();
				tf.setVisible(true);
				tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}
}

class TextFrame extends JFrame {
	private static final int text_rows = 4;
	private static final int text_colums = 20;
			
	public TextFrame() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
	    setSize(screenSize.width/2, screenSize.height/2);
	    
	    final JTextField textField = new JTextField();
	    final JPasswordField passwordField = new JPasswordField();
	    
	    JPanel centeralPanel = new JPanel();
	    centeralPanel.setLayout(new GridLayout(2, 2));
	    centeralPanel.add(new JLabel("Uaer Name:", SwingConstants.CENTER));
	    centeralPanel.add(textField);
	    centeralPanel.add(new JLabel("Password: ", SwingConstants.CENTER));
	    centeralPanel.add(passwordField);
	    
	    setLayout(new BorderLayout());
	    add(centeralPanel, BorderLayout.CENTER);
	    
	    JPanel southPanel = new JPanel();
	    JButton insertButon = new JButton("OK");
	    
	    southPanel.add(insertButon);
	    add(southPanel, BorderLayout.SOUTH);
	    
	    final JTextArea textArea = new JTextArea(text_rows, text_colums);
	    add(textArea, BorderLayout.NORTH);
	    
	    
	    insertButon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//textArea.setText("");
				textArea.setText("User Name: "+textField.getText()+"\n"
						+"Password: "+passwordField.getText());
			}
		});
	    
	    
	}
	
	
	
}