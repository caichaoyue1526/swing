package BomboBox;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComboBox {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ComboBoxFrame cbf = new ComboBoxFrame();
				cbf.setVisible(true);
				cbf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

}

class ComboBoxFrame extends JFrame {
	private JComboBox<String> faceCombo;
	private JLabel label;
	private static final int DEFAULT_SIZE = 24;
	
	public ComboBoxFrame() {
		setTitle("ComboBox");
		ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon.png"));
		setIconImage(imageIcon.getImage());
		
		label = new JLabel("123456789");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		add(label, BorderLayout.CENTER);
		
		faceCombo = new JComboBox<>();
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monospaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		faceCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setFont(new Font(faceCombo.getItemAt(faceCombo.getSelectedIndex()), Font.PLAIN, DEFAULT_SIZE));
			}
		});
		
		JPanel comboPanel = new JPanel();
		comboPanel.add(faceCombo);
		
		add(comboPanel, BorderLayout.SOUTH);
		
		pack();
	}
}