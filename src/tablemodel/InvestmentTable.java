package tablemodel;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import table.TableFrame;

public class InvestmentTable {

	public static void main(String[] args) {
		InvestmentFrame investmentFrame = new InvestmentFrame();
		investmentFrame.setVisible(true);
		investmentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}


class InvestmentTableModel extends AbstractTableModel{

	private static double INITIAL_BALANCE = 100000.0;
	private int years;
	private int minRate;
	private int maxRate;
	
	
	public InvestmentTableModel(int years, int minRate, int maxRate) {
		this.years = years;
		this.minRate = minRate;
		this.maxRate = maxRate;
	}

	@Override
	public int getRowCount() {
		return years;
	}

	@Override
	public int getColumnCount() {
		return maxRate - minRate - 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		double rate = (columnIndex + minRate) / 100.0;
		int nperiods = rowIndex;
		double futureBalance = INITIAL_BALANCE * Math.pow(1 + rate, nperiods);
		return String.format("%.2f", futureBalance);
	}

	@Override
	public String getColumnName(int column) {
		return (column + minRate) + "%";
	}
	
	
}

class In extends DefaultTableModel {
	
}
class InvestmentFrame extends JFrame {
	
	public InvestmentFrame() {
		TableModel model = new InvestmentTableModel(30, 5, 10);
		JTable table = new JTable(model);
		add(table);
		pack();
	}
}