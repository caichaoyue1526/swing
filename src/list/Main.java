package list;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ListFrame lf = new ListFrame();
				lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				lf.setVisible(true);
			}
		});
	}

}
