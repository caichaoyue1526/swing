package border;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Border {

	public static void main(String[] args)
	   {
	      EventQueue.invokeLater(new Runnable()
	         {
	            public void run()
	            {
	               JFrame frame = new BorderFrame();
	               frame.setTitle("BorderTest");
	               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	               frame.setVisible(true);
	            }
	         });
	   }
}
