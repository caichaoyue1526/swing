package jtree;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class SimpleTreeFrame extends JFrame {

	private final int DEFAULT_WIDTH = 200;
	private final int DEFAULT_HEIGHT = 300;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				SimpleTreeFrame simpleTreeFrame = new SimpleTreeFrame();
				simpleTreeFrame.setVisible(true);
				simpleTreeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

	public SimpleTreeFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("World");
		DefaultMutableTreeNode china = new DefaultMutableTreeNode("China");
		DefaultMutableTreeNode america = new DefaultMutableTreeNode("America");
		
		root.add(china);
		root.add(america);
		
		DefaultMutableTreeNode beijing = new DefaultMutableTreeNode("BeiJing");
		
		china.add(beijing);
		
		JTree tree = new JTree(root);
		
		add(new JScrollPane(tree));
	}
}
