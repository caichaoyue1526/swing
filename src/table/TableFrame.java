package table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TableFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	
	private String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous", "Color" };
	private Object[][] cells = { { "Mercury", 2440.0, 0, false, Color.YELLOW },
	         { "Venus", 6052.0, 0, false, Color.YELLOW }, { "Earth", 6378.0, 1, false, Color.BLUE },
	         { "Mars", 3397.0, 2, false, Color.RED }, { "Jupiter", 71492.0, 16, true, Color.ORANGE },
	         { "Saturn", 60268.0, 18, true, Color.ORANGE },
	         { "Uranus", 25559.0, 17, true, Color.BLUE }, { "Neptune", 24766.0, 8, true, Color.BLUE },
	         { "Pluto", 1137.0, 1, false, Color.BLACK } };
	   
	public TableFrame() {
		JTable table = new JTable(cells, columnNames);
		table.setAutoCreateRowSorter(true);
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.NORTH);
		JButton printButton = new JButton("print");
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(printButton);
		add(buttonPanel, BorderLayout.SOUTH);
		pack();
	} 
}
