package actionmap;

import java.awt.Event;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ActionFrame af = new ActionFrame();
				af.setVisible(true);
				af.addWindowListener(new WindowAdapter() {

					@Override
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
					
				});
				
			}
		});
	}

}
