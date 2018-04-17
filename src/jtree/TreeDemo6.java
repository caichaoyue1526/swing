package jtree;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TreeDemo6 implements ActionListener, TreeModelListener {
	JLabel label = null;
	JTree tree = null;
	DefaultTreeModel treeModel = null;
	String nodeName = null;// ԭ�нڵ�����

	public TreeDemo6() {
		
		JFrame f = new JFrame("TreeDemo6");
		Container contentPane = f.getContentPane();

		DefaultMutableTreeNode root = new DefaultMutableTreeNode("��Դ������");

		tree = new JTree(root);
		tree.setEditable(true);
		tree.addMouseListener(new MouseHandle());
		treeModel = (DefaultTreeModel) tree.getModel();
		treeModel.addTreeModelListener(this);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(tree);

		JPanel panel = new JPanel();
		JButton b = new JButton("�����ڵ�");
		b.addActionListener(this);
		panel.add(b);
		b = new JButton("ɾ���ڵ�");
		b.addActionListener(this);
		panel.add(b);
		b = new JButton("������нڵ�");
		b.addActionListener(this);
		panel.add(b);

		label = new JLabel("Action");
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		contentPane.add(label, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// ����������������ɾ����������нڵ�ĳ������.
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("�����ڵ�")) {
			DefaultMutableTreeNode parentNode = null;
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("�½ڵ�");
			newNode.setAllowsChildren(true);
			TreePath parentPath = tree.getSelectionPath();

			// ȡ���½ڵ�ĸ��ڵ�
			parentNode = (DefaultMutableTreeNode) (parentPath
					.getLastPathComponent());

			// ��DefaultTreeModel��insertNodeInto�������������½ڵ�
			treeModel.insertNodeInto(newNode, parentNode, parentNode
					.getChildCount());

			// tree��scrollPathToVisible()������ʹTree���Զ�չ���ļ����Ա���ʾ��������½ڵ㡣��û�������������½ڵ�
			// �ᱻ �����ļ����У����������չ���ļ��вſ��õ���
			tree.scrollPathToVisible(new TreePath(newNode.getPath()));
			label.setText("�����ڵ�ɹ�");
		}
		if (ae.getActionCommand().equals("ɾ���ڵ�")) {
			TreePath treepath = tree.getSelectionPath();
			if (treepath != null) {
				// ��������ȡ��ѡȡ�ڵ�ĸ��ڵ�.
				DefaultMutableTreeNode selectionNode = (DefaultMutableTreeNode) treepath
						.getLastPathComponent();
				TreeNode parent = (TreeNode) selectionNode.getParent();
				if (parent != null) {
					// ��DefaultTreeModel��removeNodeFromParent()����ɾ���ڵ㣬���������ӽڵ㡣
					treeModel.removeNodeFromParent(selectionNode);
					label.setText("ɾ���ڵ�ɹ�");
				}
			}
		}
		if (ae.getActionCommand().equals("������нڵ�")) {

			// ����һ�У���DefaultTreeModel��getRoot()����ȡ�ø��ڵ�.
			DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode) treeModel
					.getRoot();

			// ����һ��ɾ�������ӽڵ�.
			rootNode.removeAllChildren();

			// ɾ������������DefaultTreeModel��reload()����������Tree�Ľڵ�Ż�������ɾ��.
			treeModel.reload();
			label.setText("������нڵ�ɹ�");
		}
	}

	public void treeNodesChanged(TreeModelEvent e) {
		TreePath treePath = e.getTreePath();
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) treePath
				.getLastPathComponent();
		try {
			int[] index = e.getChildIndices();
			node = (DefaultMutableTreeNode) node.getChildAt(index[0]);
		} catch (NullPointerException exc) {
		}
		label.setText(nodeName + "��������Ϊ:" + (String) node.getUserObject());
	}

	public void treeNodesInserted(TreeModelEvent e) {
		System.out.println("new node insered");
	}

	public void treeNodesRemoved(TreeModelEvent e) {
		System.out.println("node deleted");
	}

	public void treeStructureChanged(TreeModelEvent e) {
		System.out.println("Structrue changed");
	}

	public static void main(String[] args) {
		new TreeDemo6();
	}

	class MouseHandle extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			try {
				JTree tree = (JTree) e.getSource();
				int rowLocation = tree.getRowForLocation(e.getX(), e.getY());
				TreePath treepath = tree.getPathForRow(rowLocation);
				TreeNode treenode = (TreeNode) treepath.getLastPathComponent();
				nodeName = treenode.toString();
			} catch (NullPointerException ne) {
			}
		}
	}
}
