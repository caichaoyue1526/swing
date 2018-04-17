package table;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				TableFrame tf = new TableFrame();
				tf.setVisible(true);
				tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

}
