package tablecellrender;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class TableCellRenderFrame extends JFrame {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				TableCellRenderFrame tcf = new TableCellRenderFrame();
				tcf.setVisible(true);
				tcf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
	}

	private final int DEDAULT_WIDTH = 600;
	private final int DEFAULT_HEIFHT = 400;
	
	public TableCellRenderFrame() {
		
		setSize(DEDAULT_WIDTH, DEFAULT_HEIFHT);

		TableModel model = new PlanetTableModel();
		JTable table = new JTable(model);
		table.setRowSelectionAllowed(false);
		
		table.setDefaultRenderer(Color.class, new ColorTableCellRender());
		table.setDefaultEditor(Color.class, new ColorTableEditor());
		
		JComboBox<Integer> moonCombo = new JComboBox<>();
		for(int i = 0; i <= 20; i++) {
			moonCombo.addItem(i);
		}
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn moonColumn = columnModel.getColumn(PlanetTableModel.MOONS_COLUMN);
		moonColumn.setCellEditor(new DefaultCellEditor(moonCombo));
		moonColumn.setHeaderRenderer(table.getDefaultRenderer(ImageIcon.class));
		moonColumn.setHeaderValue(new ImageIcon(getClass().getResource("Moons.gif")));
		table.setRowHeight(100);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
}

class PlanetTableModel extends AbstractTableModel {

	public static final int PLANT_COLUMN = 0;
	public static final int MOONS_COLUMN = 2;
	public static final int GASEOUS_COLUMN = 3;
	public static final int COLOR_COLUMN = 4;
	
	private Object[][] cells = {
	         { "Mercury", 2440.0, 0, false, Color.YELLOW, 
	            new ImageIcon(getClass().getResource("Mercury.gif")) },
	         { "Venus", 6052.0, 0, false, Color.YELLOW, 
	            new ImageIcon(getClass().getResource("Venus.gif")) },
	         { "Earth", 6378.0, 1, false, Color.BLUE, 
	            new ImageIcon(getClass().getResource("Earth.gif")) },
	         { "Mars", 3397.0, 2, false, Color.RED, 
	            new ImageIcon(getClass().getResource("Mars.gif")) },
	         { "Jupiter", 71492.0, 16, true, Color.ORANGE, 
	            new ImageIcon(getClass().getResource("Jupiter.gif")) },
	         { "Saturn", 60268.0, 18, true, Color.ORANGE, 
	            new ImageIcon(getClass().getResource("Saturn.gif")) },
	         { "Uranus", 25559.0, 17, true, Color.BLUE, 
	            new ImageIcon(getClass().getResource("Uranus.gif")) },
	         { "Neptune", 24766.0, 8, true, Color.BLUE, 
	            new ImageIcon(getClass().getResource("Neptune.gif")) },
	         { "Pluto", 1137.0, 1, false, Color.BLACK, 
	            new ImageIcon(getClass().getResource("Pluto.gif")) } };
	
	private String[] cloumnNames = {"planet", "radius",	"Moons", 
									"Gaseous", "Color", "Image"};
	@Override
	public int getRowCount() {
		return cells.length;
	}

	@Override
	public int getColumnCount() {
		return cloumnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return cells[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		return cloumnNames[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return cells[0][columnIndex].getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int c) {
		return c == PLANT_COLUMN || c == MOONS_COLUMN || c == GASEOUS_COLUMN || c == COLOR_COLUMN;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		cells[rowIndex][columnIndex] = aValue;
	}

}


class ColorTableCellRender extends JPanel implements TableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		setBackground((Color)value);
		if(hasFocus) {
			setBorder(UIManager.getBorder("Table.focusCellHilightBorder"));
		}else {
			setBorder(null);
		}
		return this;
	}
	
}

class ColorTableEditor extends AbstractCellEditor implements TableCellEditor {

	private JColorChooser colorChooser;
	private JDialog colorDialog;
	private JPanel panel;
	
	/*public ColorTableEditor() {
		colorChooser = new JColorChooser();
		colorDialog = JColorChooser.createDialog(null, "ColorChooser", false, colorChooser, 
				EventHandler.create(ActionListener.class, this, "stopCellEdit"), 
				EventHandler.create(ActionListener.class, this, "cancellCellEditor"));	
	}*/
	
	public ColorTableEditor() {
		colorChooser = new JColorChooser();
		colorDialog = JColorChooser.createDialog(null, "ColorChooser", false, colorChooser, 
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						colorDialog.setVisible(false);
						ColorTableEditor.this.stopCellEditing();
					}
				}, 
				new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						colorDialog.setVisible(false);
						ColorTableEditor.this.cancelCellEditing();
					}
				});	
	}
	@Override
	public Object getCellEditorValue() {
		return colorChooser.getColor();
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		colorChooser.setColor((Color)value);
		return panel;
	}
	
	/*public void cancellCellEditor() {
		colorDialog.setVisible(false);
		super.cancelCellEditing();
	}
	
	public void stopCellEdit() {
		colorDialog.setVisible(false);
		super.stopCellEditing();
	}*/
	@Override
	public boolean shouldSelectCell(EventObject anEvent) {
		colorDialog.setVisible(true);
		return true;
	}
	
	
	
	
	
}