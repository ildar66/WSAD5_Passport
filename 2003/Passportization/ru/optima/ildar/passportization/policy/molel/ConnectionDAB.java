package ru.optima.ildar.passportization.policy.molel;

import com.ibm.ivj.db.uibeans.DatabaseAccess;

/**
 * @author Administrator
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ConnectionDAB extends DatabaseAccess {
	static {
		try {
			Class.forName("COM.ibm.db2.jdbc.app.DB2Driver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static com.ibm.db.DatabaseConnection connToPassport()
		throws java.lang.Throwable, com.ibm.db.DataException {
		com.ibm.db.DatabaseConnection connection = null;
		try {
			connection = new com.ibm.db.DatabaseConnection();
			connection.setConnectionAlias(
				"ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport");
			connection.setDriverName("COM.ibm.db2.jdbc.app.DB2Driver");
			connection.setDataSourceName("jdbc:db2:passport");
			connection.setUserID("");
			connection.setPromptUID(true);
			connection.setAutoCommit(true);
			connection.setPassword("");
		} catch (com.ibm.db.DataException e) {
			throw e;
		} catch (java.lang.Throwable e) {
			throw e;
		}
		return connection;
	}
}
