package list;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel listPanel;
	private JList<String> wordList;
	private JLabel label;
	private JPanel buttonPanel;
	private ButtonGroup buttonGroup;
	private String prefix = "The ";
	private String suffix = "fox jump over the lazy dog.";
	
	public ListFrame() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension = toolkit.getScreenSize();
		double d = (Math.sqrt(5) - 1) / 2;
		setSize((int)(dimension.width*d), (int)(dimension.getHeight()*d));
		setLocation(dimension.width/2-((int)(dimension.width*d)/2), 
					dimension.height/2-((int)(dimension.getHeight()*d))/2);
		
		String[] words = {"quick", "brown", "hungry", "wild", "silent", 
							"huge", "private","abstract", "static", "final"};
		
		wordList = new JList<>(words);
		wordList.setVisibleRowCount(4);
		JScrollPane scrollPane = new JScrollPane(wordList);
		
		listPanel = new JPanel();
		listPanel.add(scrollPane);
		
		wordList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				StringBuilder sb = new StringBuilder(prefix);
				for (String string : wordList.getSelectedValuesList()) {
					sb.append(string).append(" ");
				}
				sb.append(suffix);
				label.setText(sb.toString());
			}
		});
		
		buttonPanel = new JPanel();
		buttonGroup = new ButtonGroup();
		makeButton("Vertical", JList.VERTICAL);
		makeButton("Vertical Wrap", JList.VERTICAL_WRAP);
		makeButton("Horizontal Wrap", JList.HORIZONTAL_WRAP);
		
		add(listPanel, BorderLayout.NORTH);
		label = new JLabel(prefix + suffix);
		add(label, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	private void makeButton(String string, int vertical) {
		JRadioButton button = new JRadioButton(string);
		buttonPanel.add(button);
		
		if(buttonGroup.getButtonCount()==0) {
			button.setSelected(true);
		}
		buttonGroup.add(button);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				wordList.setLayoutOrientation(vertical);
				listPanel.revalidate();
			}
		});
	}
}
