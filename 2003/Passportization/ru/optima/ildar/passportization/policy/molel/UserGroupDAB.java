package ru.optima.ildar.passportization.policy.molel;

import com.ibm.db.*;
import com.ibm.db.base.*;
import com.ibm.ivj.db.uibeans.*;
public class UserGroupDAB extends DatabaseAccess {
	/**
	public static com.ibm.db.DatabaseConnection connectToPassport() throws java.lang.Throwable, com.ibm.db.DataException {
	com.ibm.db.DatabaseConnection connection = null;
	try{ 
	connection = new com.ibm.db.DatabaseConnection();
	connection.setConnectionAlias("ru.optima.ildar.passportization.policy.molel.UserGroupDAB.connectToPassport");
	connection.setDriverName("COM.ibm.db2.jdbc.app.DB2Driver");
	connection.setDataSourceName("jdbc:db2:passport");
	connection.setUserID("db2admin");
	connection.setPromptUID(false);
	connection.setAutoCommit(true);
	connection.setPassword("123456");
	}
	catch(com.ibm.db.DataException e){throw e;}
	catch(java.lang.Throwable e){throw e;}
	return connection;
	}
	*/
	public static com.ibm.db.SQLStatementMetaData UserGroupDelete() throws java.lang.Throwable {
		String name = "ru.optima.ildar.passportization.policy.molel.UserGroupDAB.UserGroupDelete";
		String statement =
			"DELETE FROM DB2ADMIN.USERGROUPS WHERE ( ( DB2ADMIN.USERGROUPS.USERGROUPID = :USERGROUPID ) )";

		SQLStatementMetaData aSpec = null;
		try {
			aSpec = new com.ibm.db.SQLStatementMetaData();
			aSpec.setName(name);
			aSpec.setSQL(statement);
			aSpec.addParameter("USERGROUPID", 4, 4);
			// user code begin {1} 
			// user code end {1}
		} catch (java.lang.Throwable e) {
			// user code begin {2} 
			// user code end {2}
			throw e;
		}
		return aSpec;
	}
	public static com.ibm.db.SQLStatementMetaData UserGroupInsert() throws java.lang.Throwable {
		String name = "ru.optima.ildar.passportization.policy.molel.UserGroupDAB.UserGroupInsert";
		String statement =
			"INSERT INTO DB2ADMIN.USERGROUPS ( USERGROUPID, FD, CAPTION ) VALUES ( :USERGROUPID, :FD, :CAPTION )";

		SQLStatementMetaData aSpec = null;
		try {
			aSpec = new com.ibm.db.SQLStatementMetaData();
			aSpec.setName(name);
			aSpec.setSQL(statement);
			aSpec.addParameter("USERGROUPID", 4, 4);
			aSpec.addParameter("FD", 91, 91);
			aSpec.addParameter("CAPTION", 12, 12);
			// user code begin {1} 
			// user code end {1}
		} catch (java.lang.Throwable e) {
			// user code begin {2} 
			// user code end {2}
			throw e;
		}
		return aSpec;
	}
	public static com.ibm.db.StatementMetaData UserGroupSelect() throws java.lang.Throwable {
		String name = "ru.optima.ildar.passportization.policy.molel.UserGroupDAB.UserGroupSelect";
		String statement =
			"SELECT DB2ADMIN.USERGROUPS.USERGROUPID, DB2ADMIN.USERGROUPS.FD, DB2ADMIN.USERGROUPS.CAPTION FROM DB2ADMIN.USERGROUPS WHERE ( ( DB2ADMIN.USERGROUPS.USERGROUPID = :USERGROUPID ) )";

		StatementMetaData aSpec = null;
		try {
			aSpec = new com.ibm.db.StatementMetaData();
			aSpec.setName(name);
			aSpec.setSQL(statement);
			aSpec.addTable("DB2ADMIN.USERGROUPS");
			aSpec.addColumn("USERGROUPS.USERGROUPID", 4, 4);
			aSpec.addColumn("USERGROUPS.FD", 91, 91);
			aSpec.addColumn("USERGROUPS.CAPTION", 12, 12);
			aSpec.addParameter("USERGROUPID", 4, 4);
			// user code begin {1} 
			// user code end {1}
		} catch (java.lang.Throwable e) {
			// user code begin {2} 
			// user code end {2}
			throw e;
		}
		return aSpec;
	}
	public static com.ibm.db.StatementMetaData UserGroupSelectAll() throws java.lang.Throwable {
		String name =
			"ru.optima.ildar.passportization.policy.molel.UserGroupDAB.UserGroupSelectAll";
		String statement = "SELECT * FROM DB2ADMIN.USERGROUPS ORDER BY DB2ADMIN.USERGROUPS.CAPTION";

		StatementMetaData aSpec = null;
		try {
			aSpec = new com.ibm.db.StatementMetaData();
			aSpec.setName(name);
			aSpec.setSQL(statement);
			aSpec.addTable("DB2ADMIN.USERGROUPS");
			aSpec.addColumn("USERGROUPS.USERGROUPID", 4, 4);
			aSpec.addColumn("USERGROUPS.FD", 91, 91);
			aSpec.addColumn("USERGROUPS.CAPTION", 12, 12);
			// user code begin {1} 
			// user code end {1}
		} catch (java.lang.Throwable e) {
			// user code begin {2} 
			// user code end {2}
			throw e;
		}
		return aSpec;
	}
	public static com.ibm.db.SQLStatementMetaData UserGroupUpdate() throws java.lang.Throwable {
		String name = "ru.optima.ildar.passportization.policy.molel.UserGroupDAB.UserGroupUpdate";
		String statement =
			"UPDATE DB2ADMIN.USERGROUPS SET USERGROUPID = :USERGROUPID, FD = :FD, CAPTION = :CAPTION WHERE ( ( DB2ADMIN.USERGROUPS.USERGROUPID = :USERGROUP_ID ) )";

		SQLStatementMetaData aSpec = null;
		try {
			aSpec = new com.ibm.db.SQLStatementMetaData();
			aSpec.setName(name);
			aSpec.setSQL(statement);
			aSpec.addParameter("USERGROUPID", 4, 4);
			aSpec.addParameter("FD", 91, 91);
			aSpec.addParameter("CAPTION", 12, 12);
			aSpec.addParameter("USERGROUP_ID", 4, 4);
			// user code begin {1} 
			// user code end {1}
		} catch (java.lang.Throwable e) {
			// user code begin {2} 
			// user code end {2}
			throw e;
		}
		return aSpec;
	}
}
