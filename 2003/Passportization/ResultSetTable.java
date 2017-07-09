/**
   @version 1.01 2001-07-18
   @author Cay Horstmann
*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import ru.optima.ildar.passportization.policy.molel.*;
/**
   This program shows how to display the result of a 
   database query in a table.
*/
public class ResultSetTable {
	public static void main(String[] args) {
		JFrame frame = new ResultSetFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}

/**
   This frame contains a combo box to select a database table
   and a table to show the data stored in the table
*/
class ResultSetFrame extends JFrame {
	public ResultSetFrame() {
		setTitle("ResultSet");
		setSize(WIDTH, HEIGHT);

		/* find all tables in the database and add them to
		   a combo box
		*/

		Container contentPane = getContentPane();
		tableNames = new JComboBox();
		tableNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				try {
					if (scrollPane != null)
						getContentPane().remove(scrollPane);
					String tableName = (String) tableNames.getSelectedItem();
					if (rs != null)
						rs.close();
					String query = "SELECT * FROM " + "db2admin."+tableName;
					rs = stat.executeQuery(query);
					if (scrolling)
						model = new ScrollingResultSetTableModel(rs);
					else
						model = new CachingResultSetTableModel(rs);

					JTable table = new JTable(model);
					scrollPane = new JScrollPane(table);
					getContentPane().add(scrollPane, BorderLayout.CENTER);
					pack();
					doLayout();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		JPanel p = new JPanel();
		p.add(tableNames);
		contentPane.add(p, BorderLayout.NORTH);

		try {
			conn = getConnection();
			DatabaseMetaData meta = conn.getMetaData();
			if (meta.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
				scrolling = true;
				//System.out.println("Scrolling true");
				stat =
					conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
			} else {
				stat = conn.createStatement();
				scrolling = false;
			}
			ResultSet tables = meta.getTables(null, null, null, new String[] { "TABLE" });
			while (tables.next())
				tableNames.addItem(tables.getString(3));
			tables.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	   Gets a connection from the properties specified in
	   the file database.properties.
	   @return the database connection
	 */
	public static Connection getConnection()
		throws SQLException, IOException, java.lang.Throwable, com.ibm.db.DataException {
		/**
				Properties props = new Properties();
				FileInputStream in 
				  = new FileInputStream("database.properties");
				props.load(in);
				in.close();
				
				String drivers = props.getProperty("jdbc.drivers");
				if (drivers != null)
				  System.setProperty("jdbc.drivers", drivers);
				String url = props.getProperty("jdbc.url");
				String username = props.getProperty("jdbc.username");
				String password = props.getProperty("jdbc.password");
				
				return
				  DriverManager.getConnection(url, username, password);
		*/
		System.setProperty("jdbc.drivers", "COM.ibm.db2.jdbc.app.DB2Driver");
		return DriverManager.getConnection("jdbc:db2:passport", "", "");
	}

	private JScrollPane scrollPane;
	private ResultSetTableModel model;
	private JComboBox tableNames;
	private ResultSet rs;
	private Connection conn;
	private Statement stat;
	private boolean scrolling;

	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;
}

/** 
   This class is the superclass for the scrolling and the
   caching result set table model. It stores the result set
   and its metadata.
*/
abstract class ResultSetTableModel extends AbstractTableModel {
	/**
	   Constructs the table model.
	   @param aResultSet the result set to display.
	*/
	public ResultSetTableModel(ResultSet aResultSet) {
		rs = aResultSet;
		try {
			rsmd = rs.getMetaData();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String getColumnName(int c) {
		try {
			return rsmd.getColumnName(c + 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}

	public int getColumnCount() {
		try {
			return rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	/**
	   Gets the result set that this model exposes.
	   @return the result set
	*/
	protected ResultSet getResultSet() {
		return rs;
	}

	private ResultSet rs;
	private ResultSetMetaData rsmd;
}

/**
   This class uses a scrolling cursor, a JDBC 2 feature,
   to locate result set elements.
*/
class ScrollingResultSetTableModel extends ResultSetTableModel {
	/**
	   Constructs the table model.
	   @param aResultSet the result set to display.
	*/
	public ScrollingResultSetTableModel(ResultSet aResultSet) {
		super(aResultSet);
	}

	public Object getValueAt(int r, int c) {
		try {
			ResultSet rs = getResultSet();
			rs.absolute(r + 1);
			return rs.getObject(c + 1);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getRowCount() {
		try {
			ResultSet rs = getResultSet();
			rs.last();
			return rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}

/* 
   This class caches the result set data; it can be used
   if scrolling cursors are not supported
*/
class CachingResultSetTableModel extends ResultSetTableModel {
	public CachingResultSetTableModel(ResultSet aResultSet) {
		super(aResultSet);
		try {
			cache = new ArrayList();
			int cols = getColumnCount();
			ResultSet rs = getResultSet();

			/* place all data in an array list of Object[] arrays
			   We don't use an Object[][] because we don't know
			   how many rows are in the result set
			*/

			while (rs.next()) {
				Object[] row = new Object[cols];
				for (int j = 0; j < row.length; j++)
					row[j] = rs.getObject(j + 1);
				cache.add(row);
			}
		} catch (SQLException e) {
			System.out.println("Error " + e);
		}
	}

	public Object getValueAt(int r, int c) {
		if (r < cache.size())
			return ((Object[]) cache.get(r))[c];
		else
			return null;
	}

	public int getRowCount() {
		return cache.size();
	}

	private ArrayList cache;
}
