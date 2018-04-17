package jtree;

import java.awt.BorderLayout;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JTree;

public class HashTableTreeFrame extends JFrame {

	public static void main(String[] args) {
		HashTableTreeFrame httf = new HashTableTreeFrame();
		httf.setVisible(true);
		httf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public HashTableTreeFrame() {
		String[] s1 = {"1", "2", "3"};
		String[] s2 = {"a", "b", "c"};
		String[] s3 = {"aa", "bb", "cc"};
		
		Hashtable table1 = new Hashtable<>();
		Hashtable table2 = new Hashtable<>();
		
		
		table1.put("Êý×Ö", s1);
		table1.put("×ÖÄ¸", table2);
		table2.put("1", s2);
		table2.put("2", s3);
		
		JTree tree = new JTree(table1);
		
		add(tree, BorderLayout.CENTER);
		tree.putClientProperty("JTree.lineStyle","Horizontal");
		pack();
	}

}
