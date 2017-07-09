/**
   @version 1.00 2001-07-18
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import java.util.*;
import ru.optima.ildar.passportization.policy.molel.Permission;

/**
   This program demonstrates how to show a simple table
*/
public class PlanetTable1 {
	public static void main(String[] args) {
		JFrame frame = new PlanetTableFrame1();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}

/**
   This frame contains a table of planet data.
*/
class PlanetTableFrame1 extends JFrame {
	public PlanetTableFrame1() {
		setTitle("PlanetTable");
		setSize(WIDTH, HEIGHT);
		/**
				//JTable table = new JTable(cells, columnNames); 
				Vector permV = new Vector();
				try {
					permV = Permission.getListOfAllPermissions();
				} catch (Exception e) {
				}
				String[] names = { "права", "boolen" };
				int n = permV.size();
				Object[][] perm = new Object[n][2];
				for (int i = 0; i < permV.size(); i++) {
					Permission element = (Permission) permV.elementAt(i);
					perm[i][0] = element;
					perm[i][1] = new JCheckBox("Text", true);
				}
				DefaultTableModel model = new DefaultTableModel(perm, names);
		
				JTable table = new JTable(model);
				TableColumnModel columnModel = table.getColumnModel();
				TableColumn col = columnModel.getColumn(1);
				//col.setCellEditor(new DefaultCellEditor(new JCheckBox()));
				//col.setCellRenderer(new DefaultTableCellRenderer(new JCheckBox()));
				**/
		JTable table = new JTable(new PermTableModel());
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				System.out.println("ok");
			}
		});
		table.getModel().addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent e) {
				System.out.println("chanches");
			}
		});
		table.getColumnModel().addColumnModelListener(new TableColumnModelListener() {
			public void columnSelectionChanged(ListSelectionEvent e) {
				//System.out.println("ListSelectionEvent");
			}
			public void columnAdded(TableColumnModelEvent e) {
				//System.out.println("asdfasdf");
			}

			public void columnMarginChanged(ChangeEvent e) {
				System.out.println("ChangeEvent");
			}
			public void columnMoved(TableColumnModelEvent e) {
			}
			public void columnRemoved(TableColumnModelEvent e) {
			}

		});
		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
	}

	private static final int WIDTH = 400;
	private static final int HEIGHT = 200;

	class PermTableModel extends AbstractTableModel {
		PermTableModel() {
			Vector permV = new Vector();
			try {
				permV = Permission.getListOfAllPermissions();
			} catch (Exception e) {
				e.printStackTrace();
			}
			int n = permV.size();
			cells = new Object[n][2];
			for (int i = 0; i < permV.size(); i++) {
				Permission element = (Permission) permV.elementAt(i);
				cells[i][0] = element;
				cells[i][1] = Boolean.TRUE;
			}
		}
		public String getColumnName(int c) {
			return columnNames[c];
		}

		public Class getColumnClass(int c) {
			return cells[0][c].getClass();
		}

		public int getColumnCount() {
			return cells[0].length;
		}

		public int getRowCount() {
			return cells.length;
		}

		public Object getValueAt(int r, int c) {
			return cells[r][c];
		}

		public void setValueAt(Object obj, int r, int c) {
			cells[r][c] = obj;
		}

		public boolean isCellEditable(int r, int c) {
			return c == PERM_COLUMN;

		}

		public static final int NAME_COLUMN = 0;
		public static final int PERM_COLUMN = 1;

		private Object[][] cells;

		private String[] columnNames = { "Название прав", "Права" };
	}
}
