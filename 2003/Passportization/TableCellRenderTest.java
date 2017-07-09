/**
   @version 1.00 2001-07-21
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
   This program demonstrates cell rendering and editing
   in a table.
*/
public class TableCellRenderTest {
	public static void main(String[] args) {
		JFrame frame = new TableCellRenderFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}

/**
   This frame contains a table of planet data.
*/
class TableCellRenderFrame extends JFrame {
	public TableCellRenderFrame() {
		setTitle("TableCellRenderTest");
		setSize(WIDTH, HEIGHT);

		TableModel model = new PlanetTableModel();
		JTable table = new JTable(model);

		// set up renderers and editors

		//table.setDefaultRenderer(Color.class, new ColorTableCellRenderer());
		//table.setDefaultEditor(Color.class, new ColorTableCellEditor());

		JComboBox moonCombo = new JComboBox();
		for (int i = 0; i <= 20; i++)
			moonCombo.addItem(new Integer(i));
		TableColumnModel columnModel = table.getColumnModel();
		TableColumn moonColumn = columnModel.getColumn(PlanetTableModel.MOON_COLUMN);
		moonColumn.setCellEditor(new DefaultCellEditor(moonCombo));

		// show table

		table.setRowHeight(100);
		getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
	}

	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
}

/** 
   The planet table model specifies the values, rendering
   and editing properties for the planet data.
*/
class PlanetTableModel extends AbstractTableModel {
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
		return c == NAME_COLUMN || c == MOON_COLUMN || c == GASEOUS_COLUMN || c == COLOR_COLUMN;

	}

	public static final int NAME_COLUMN = 0;
	public static final int MOON_COLUMN = 2;
	public static final int GASEOUS_COLUMN = 3;
	public static final int COLOR_COLUMN = 4;

	private Object[][] cells =
		{
			{
				"Mercury",
				new Double(2440),
				new Integer(0),
				Boolean.FALSE,
				Color.yellow,
				new ImageIcon("Mercury.gif")},
			{
			"Venus",
				new Double(6052),
				new Integer(0),
				Boolean.FALSE,
				Color.yellow,
				new ImageIcon("Venus.gif")
			},
				{
			"Earth",
				new Double(6378),
				new Integer(1),
				Boolean.FALSE,
				Color.blue,
				new ImageIcon("Earth.gif")
			},
				{
			"Mars",
				new Double(3397),
				new Integer(2),
				Boolean.FALSE,
				Color.red,
				new ImageIcon("Mars.gif")
			},
				{
			"Jupiter",
				new Double(71492),
				new Integer(16),
				Boolean.TRUE,
				Color.orange,
				new ImageIcon("Jupiter.gif")
			},
				{
			"Saturn",
				new Double(60268),
				new Integer(18),
				Boolean.TRUE,
				Color.orange,
				new ImageIcon("Saturn.gif")
			},
				{
			"Uranus",
				new Double(25559),
				new Integer(17),
				Boolean.TRUE,
				Color.blue,
				new ImageIcon("Uranus.gif")
			},
				{
			"Neptune",
				new Double(24766),
				new Integer(8),
				Boolean.TRUE,
				Color.blue,
				new ImageIcon("Neptune.gif")
			},
				{
			"Pluto",
				new Double(1137),
				new Integer(1),
				Boolean.FALSE,
				Color.black,
				new ImageIcon("Pluto.gif")
			}
	};

	private String[] columnNames = { "Planet", "Radius", "Moons", "Gaseous", "Color", "Image" };
}
