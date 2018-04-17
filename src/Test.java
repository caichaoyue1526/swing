import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MyFrame mf = new MyFrame();
				mf.addWindowListener(new Termicator());
				mf.setVisible(true);
			}
		});
	}
}


class MyFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel buttonPanel;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFULT_HEIGHT = 200;
	
	public MyFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_WIDTH);
		
		JButton redButton = new JButton("ºìÉ«");
		JButton greenButton = new JButton("ÂÌÉ«");
		JButton bulueButton = new JButton("À¶É«");
		buttonPanel = new JPanel();
		buttonPanel.add(redButton);
		buttonPanel.add(greenButton);
		buttonPanel.add(bulueButton);
		
		add(buttonPanel);
		
		redButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setBackground(Color.RED);
			}
		});
		
		greenButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setBackground(Color.GREEN);
			}
		});
		
		bulueButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				buttonPanel.setBackground(Color.BLUE);
			}
		});
		
	}
}

class Termicator extends WindowAdapter	{
	BufferedWriter bw;
	@Override
	public void windowClosing(WindowEvent e) {
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\132.txt")));
			bw.write("closing");
			bw.flush();
			System.exit(0);
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}

