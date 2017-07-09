package ru.optima.ildar.passportization.policy.molel;

import java.util.Vector;
import java.sql.Date;
/**
* Insert the type's description here.
* Creation date: (08.11.2003 15:25:20)
* @author: Shafigullin Ildar
*/
public class UserGroup {

	public static class UserGroupPK extends PrimaryKey {

		/**
		 * @param anId
		 * @roseuid 3E0041A70190
		 */
		public UserGroupPK(String anId) {
			super(anId);
		}
		public UserGroupPK() {
			super();
		}
	}
	private UserGroup.UserGroupPK userGroup_id;
	private java.sql.Date fd;
	private String caption;
	//private java.util.Vector users;
	private com.ibm.ivj.db.uibeans.Select ivjUserGroupSelectAll = null;
	private com.ibm.ivj.db.uibeans.Select ivjUserGroupSelect = null;
	private com.ibm.ivj.db.uibeans.Modify ivjUserGroupInsert = null;
	private com.ibm.ivj.db.uibeans.Modify ivjUserGroupUpdate = null;
	private com.ibm.ivj.db.uibeans.Modify ivjUserGroupDelete = null;
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2003 18:26:26)
	 */
	public UserGroup() {
	}
	/**
	 * UserGroup constructor comment.
	 */
	public UserGroup(UserGroup.UserGroupPK anId, java.sql.Date newFD, String newCaption) {
		userGroup_id = anId;
		setFd(newFD);
		setCaption(newCaption);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 11:06:25)
	 * @param anIdStr java.lang.String
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static void deleteWithUserGroupPK(String anIdStr) throws PersistenceException {
		deleteWithUserGroupPK(new UserGroupPK(anIdStr));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 10:59:36)
	 * @param anId ru.optima.ildar.passportization.policy.molel.UserGroup.UserGroupPK
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static void deleteWithUserGroupPK(UserGroupPK anId) throws PersistenceException {
		com.ibm.ivj.db.uibeans.Modify modify = null;
		try {
			UserGroup tempUserGroup = new UserGroup();
			modify = tempUserGroup.getUserGroupDelete();
			modify.setParameterFromString("USERGROUPID", anId.getIdAsString());
			modify.execute();
		} catch (Exception exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2003 18:59:52)
	 * @return boolean
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	private boolean exists() throws PersistenceException {
		try {
			com.ibm.ivj.db.uibeans.Select select = getUserGroupSelect();

			select.setParameterFromString("USERGROUPID", getUserGroup_id().getIdAsString());
			select.execute();
			if (select.getNumRows() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2003 18:31:57)
	 * @return ru.optima.ildar.passportization.policy.molel.UserGroup
	 * @param anIdStr java.lang.String
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static UserGroup findWithUserGroupPK(String anIdStr) throws PersistenceException {
		return findWithUserGroupPK(new UserGroupPK(anIdStr));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2003 17:59:58)
	 */
	public static UserGroup findWithUserGroupPK(UserGroupPK anId) throws PersistenceException {
		try {
			UserGroup tempUserGroup = new UserGroup();
			com.ibm.ivj.db.uibeans.Select select = tempUserGroup.getUserGroupSelect();

			select.setParameterFromString("USERGROUPID", anId.getIdAsString());

			select.execute();

			if (select.getRowCount() <= 0) {
				throw new UserGroupNotFoundException(
					"The UserGroup with primary key " + anId.getIdAsString() + " was not found.");
			}

			select.firstRow();
			String tmpUSERGROUPID =
				(String) select.getColumnValueToString("USERGROUPS.USERGROUPID");
			java.sql.Date tmpFD = (java.sql.Date) select.getColumnValue("USERGROUPS.FD");
			String tmpCAPTION = (String) select.getColumnValue("USERGROUPS.CAPTION");

			tempUserGroup =
				new UserGroup((new UserGroup.UserGroupPK(tmpUSERGROUPID)), tmpFD, tmpCAPTION);

			return tempUserGroup;
		} catch (Exception exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2003 18:22:34)
	 * @return java.lang.String
	 */
	public java.lang.String getCaption() {
		return caption;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2003 18:22:34)
	 * @return java.sql.Date
	 */
	public java.sql.Date getFd() {
		return fd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2003 18:43:25)
	 * @return java.util.Vector
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static java.util.Vector getListOfAllUserGroups() throws PersistenceException {
		try {
			Vector allUserGroups = new Vector(0);
			UserGroup tempUserGroup = new UserGroup();

			com.ibm.ivj.db.uibeans.Select select = tempUserGroup.getUserGroupSelectAll();

			select.execute();
			int numrecs = select.getNumRows();
			if (numrecs <= 0) {
				throw new UserGroupNotFoundException("No groups were found.");
			}

			select.firstRow();
			for (int i = 0; i < numrecs; i++) {
				String tmpUSERGROUPID =
					(String) select.getColumnValueToString("USERGROUPS.USERGROUPID");
				java.sql.Date tmpFD = (java.sql.Date) select.getColumnValue("USERGROUPS.FD");
				String tmpCAPTION = (String) select.getColumnValue("USERGROUPS.CAPTION");

				tempUserGroup =
					new UserGroup((new UserGroup.UserGroupPK(tmpUSERGROUPID)), tmpFD, tmpCAPTION);

				allUserGroups.addElement(tempUserGroup);
				select.nextRow();
			}

			return allUserGroups;
		} catch (com.ibm.db.DataException exp) {
			throw new PersistenceException(exp.toString());
		}

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2003 18:52:26)
	 * @return ru.optima.ildar.passportization.policy.molel.UserGroup.UserGroupPK
	 */
	public ru.optima.ildar.passportization.policy.molel.UserGroup.UserGroupPK getUserGroup_id() {
		return userGroup_id;
	}
	/**
	 * Return the UserGroupDelete property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getUserGroupDelete() {
		if (ivjUserGroupDelete == null) {
			try {
				ivjUserGroupDelete = new com.ibm.ivj.db.uibeans.Modify();
				ivjUserGroupDelete.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru
							.optima
							.ildar
							.passportization
							.policy
							.molel
							.ConnectionDAB.connToPassport(),
						ru
							.optima
							.ildar
							.passportization
							.policy
							.molel
							.UserGroupDAB
							.UserGroupDelete()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjUserGroupDelete;
	}
	/**
	 * Return the UserGroupInsert property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getUserGroupInsert() {
		if (ivjUserGroupInsert == null) {
			try {
				ivjUserGroupInsert = new com.ibm.ivj.db.uibeans.Modify();
				ivjUserGroupInsert.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru
							.optima
							.ildar
							.passportization
							.policy
							.molel
							.ConnectionDAB.connToPassport(),
						ru
							.optima
							.ildar
							.passportization
							.policy
							.molel
							.UserGroupDAB
							.UserGroupInsert()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjUserGroupInsert;
	}
	/**
	 * Return the UserGroupSelect property value.
	 * @return com.ibm.ivj.db.uibeans.Select
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Select getUserGroupSelect() {
		if (ivjUserGroupSelect == null) {
			try {
				ivjUserGroupSelect = new com.ibm.ivj.db.uibeans.Select();
				ivjUserGroupSelect.setQuery(
					new com.ibm.ivj.db.uibeans.Query(
						ru
							.optima
							.ildar
							.passportization
							.policy
							.molel
							.ConnectionDAB.connToPassport(),
						ru
							.optima
							.ildar
							.passportization
							.policy
							.molel
							.UserGroupDAB
							.UserGroupSelect()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjUserGroupSelect;
	}
	/**
	 * Return the UserGroupSelectAll property value.
	 * @return com.ibm.ivj.db.uibeans.Select
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Select getUserGroupSelectAll() {
		if (ivjUserGroupSelectAll == null) {
			try {
				ivjUserGroupSelectAll = new com.ibm.ivj.db.uibeans.Select();
				ivjUserGroupSelectAll.setQuery(
					new com.ibm.ivj.db.uibeans.Query(
						ru
							.optima
							.ildar
							.passportization
							.policy
							.molel
							.ConnectionDAB.connToPassport(),
						ru
							.optima
							.ildar
							.passportization
							.policy
							.molel
							.UserGroupDAB
							.UserGroupSelectAll()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjUserGroupSelectAll;
	}
	/**
	 * Return the UserGroupUpdate property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getUserGroupUpdate() {
		if (ivjUserGroupUpdate == null) {
			try {
				ivjUserGroupUpdate = new com.ibm.ivj.db.uibeans.Modify();
				ivjUserGroupUpdate.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru
							.optima
							.ildar
							.passportization
							.policy
							.molel
							.ConnectionDAB.connToPassport(),
						ru
							.optima
							.ildar
							.passportization
							.policy
							.molel
							.UserGroupDAB
							.UserGroupUpdate()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjUserGroupUpdate;
	}
	/**
	 * Called whenever the part throws an exception.
	 * @param exception java.lang.Throwable
	 */
	private void handleException(java.lang.Throwable exception) {

		/* Uncomment the following lines to print uncaught exceptions to stdout */
		// System.out.println("--------- UNCAUGHT EXCEPTION ---------");
		// exception.printStackTrace(System.out);
	}
	/**
	 * main entrypoint - starts the part when it is run as an application
	 * @param args java.lang.String[]
	 */
	public static void main(java.lang.String[] args) {
		UserGroup tempUserGroup;
		try {
			System.out.println("Main() started at: " + new java.util.Date());
			System.out.println("Doing simple create/find test.\n");
			String newUserGroupIDstr = "1"; // определите newUserGroupIDstr !!!
			System.out.println("Make new UserGroup with key " + newUserGroupIDstr + "\n");
			tempUserGroup =
				new UserGroup(
					new UserGroup.UserGroupPK(newUserGroupIDstr),
					new java.sql.Date(System.currentTimeMillis()),
					"Caption" + newUserGroupIDstr);
			tempUserGroup.store(); //ћожет убить существующую запись в базе!!!
			System.out.println(tempUserGroup);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			String getUserGroupIDstr = "1";
			System.out.println("Find UserGroup with key " + getUserGroupIDstr + ".\n");
			tempUserGroup = findWithUserGroupPK(getUserGroupIDstr);
			System.out.println(tempUserGroup);
			System.out.println("______________________________________");
			System.out.println();
			///////////////////////////////////////////////////////////////
			System.out.println("Make new UserGroup with unique key  \n");
			tempUserGroup =
				new UserGroup(
					new UserGroup.UserGroupPK(),
					new java.sql.Date(System.currentTimeMillis()),
					"Caption" + newUserGroupIDstr);
			System.out.println("заранее уникальный :" + tempUserGroup.getUserGroup_id());
			tempUserGroup.store();
			System.out.println(tempUserGroup);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			System.out.println(
				"Find UserGroup with unique key " + tempUserGroup.getUserGroup_id() + ".\n");
			tempUserGroup = findWithUserGroupPK(tempUserGroup.getUserGroup_id().getIdAsString());
			System.out.println(tempUserGroup);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			System.out.println("Find all UserGroup: ");
			Vector list = UserGroup.getListOfAllUserGroups();
			for (int i = 0; i < list.size(); i++) {
				UserGroup tempUG = (UserGroup) list.elementAt(i);
				System.out.println(tempUG);
			}
			/////////////////////////////////////////////////////////////////
			System.out.println(
				"Delete UserGroup with unique key " + tempUserGroup.getUserGroup_id() + ".\n");
			UserGroup.deleteWithUserGroupPK(tempUserGroup.getUserGroup_id());
			///////////////////////////////////////////////////////////////
			////////////////////////////////////////////////////////////////
			System.out.println("Find all UserGroup: ");
			list = UserGroup.getListOfAllUserGroups();
			for (int i = 0; i < list.size(); i++) {
				UserGroup tempUG = (UserGroup) list.elementAt(i);
				System.out.println(tempUG);
			}
		} catch (Throwable exception) {
			System.err.println("Exception occurred in main() of java.lang.Object");
			exception.printStackTrace(System.out);
		}
		System.out.println("Main() ended at: " + new java.util.Date());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2003 18:22:34)
	 * @param newCaption java.lang.String
	 */
	public void setCaption(java.lang.String newCaption) {
		caption = newCaption;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2003 18:22:34)
	 * @param newFd java.sql.Date
	 */
	public void setFd(java.sql.Date newFd) {
		fd = newFd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (08.11.2003 18:50:14)
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public void store() throws PersistenceException {
		com.ibm.ivj.db.uibeans.Modify modify = null;
		try {
			if (exists()) {
				modify = getUserGroupUpdate();
				modify.setParameterFromString(
					"USERGROUP_ID",
					this.getUserGroup_id().getIdAsString());

			} else {
				//record doesn't exist.
				modify = getUserGroupInsert();
			}

			modify.setParameterFromString("USERGROUPID", this.getUserGroup_id().getIdAsString());
			modify.setParameter("FD", getFd());
			modify.setParameter("CAPTION", getCaption());

			modify.execute();
		} catch (com.ibm.db.DataException exp) {
			throw new PersistenceException(exp.toString());
		}

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 13:21:55)
	 * @return java.lang.String
	 */
	public String toString() {
		//return "UserGroup(" + userGroup_id + "):" + caption;
		return caption;
	}
	
	public boolean equals(Object anObject) {
		try {
			return caption.equals(((UserGroup) anObject).caption);
		} catch (ClassCastException ex) {
			return false;
		}
	}
}
