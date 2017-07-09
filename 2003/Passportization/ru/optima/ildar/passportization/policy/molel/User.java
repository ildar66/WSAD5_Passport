package ru.optima.ildar.passportization.policy.molel;

import java.util.Vector;
/**
 * Insert the type's description here.
 * Creation date: (09.11.2003 17:09:49)
 * @author: Shafigullin Ildar
 */
public class User {

	public static class UserPK extends PrimaryKey {

		/**
		 * @param anId
		 * @roseuid 3E0041A70190
		 */
		public UserPK(String anId) {
			super(anId);
		}
		public UserPK() {
			super();
		}
	}
	private User.UserPK user_id;
	private java.sql.Date fd;
	private UserName name;
	private String password; //USERPASSWORD
	private String login; //USERLOGIN
	private Integer groupID; //USERGROUPID
	private com.ibm.ivj.db.uibeans.Select ivjUserSelect = null;
	private com.ibm.ivj.db.uibeans.Modify ivjUserInsert = null;
	private com.ibm.ivj.db.uibeans.Select ivjUsersSelectForGroup = null;
	private com.ibm.ivj.db.uibeans.Modify ivjUserUpdate = null;
	private com.ibm.ivj.db.uibeans.Modify ivjUserDelete = null;
	private com.ibm.ivj.db.uibeans.Modify ivjUserEnable = null;
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:16:11)
	 */
	public User() {
		super();
		initialize();
	}
	/**
	 * User constructor comment.
	 */
	public User(
		User.UserPK aId,
		java.sql.Date aFD,
		UserName aName,
		Integer aGroup,
		String aLogin,
		String aPassword) {
		user_id = aId;
		setFd(aFD);
		setName(aName);
		setGroupID(aGroup);
		setLogin(aLogin);
		setPassword(aPassword);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:33:37)
	 * @param anIdStr java.lang.String
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static void deleteWithUserPK(String anIdStr) throws PersistenceException {
		deleteWithUserPK(new UserPK(anIdStr));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:35:06)
	 * @param anId ru.optima.ildar.passportization.policy.molel.User.UserPK
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static void deleteWithUserPK(UserPK anId) throws PersistenceException {
		com.ibm.ivj.db.uibeans.Modify modify = null;
		try {
			User tempUser = new User();
			modify = tempUser.getUserDelete();
			modify.setParameterFromString("USERID", anId.getIdAsString());
			modify.execute();
		} catch (Exception exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	public void setEnable(int i) throws PersistenceException {
		com.ibm.ivj.db.uibeans.Modify modify = null;
		try {
			User tempUser = new User();
			modify = tempUser.getUserEnable();
			modify.setParameterFromString("USERID", user_id.getIdAsString());
			modify.setParameter("ENABLE", new Integer(i));//ENABLE
			modify.execute();
		} catch (Exception exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:40:10)
	 * @return boolean
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	private boolean exists() throws PersistenceException {
		try {
			com.ibm.ivj.db.uibeans.Select select = getUserSelect();

			select.setParameterFromString("USERID", getUser_id().getIdAsString());
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
	 * Creation date: (09.11.2003 17:46:27)
	 * @return ru.optima.ildar.passportization.policy.molel.User
	 * @param anIdStr java.lang.String
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static User findWithUserPK(String anIdStr) throws PersistenceException {
		return findWithUserPK(new UserPK(anIdStr));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 17:47:33)
	 * @return ru.optima.ildar.passportization.policy.molel.User
	 * @param anId ru.optima.ildar.passportization.policy.molel.User.UserPK
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static User findWithUserPK(UserPK anId) throws PersistenceException {
		try {
			User tempUser = new User();
			com.ibm.ivj.db.uibeans.Select select = tempUser.getUserSelect();

			//Vector tempAccountsV = new Vector()
			select.setParameterFromString("USERID", anId.getIdAsString());

			select.execute();

			if (select.getRowCount() <= 0) {
				throw new UserNotFoundException(
					"The User with primary key " + anId.getIdAsString() + " was not found.");
			}

			select.firstRow();

			String tmpID = (String) select.getColumnValueToString("USERS.USERID");
			java.sql.Date tmpFD = (java.sql.Date) select.getColumnValue("USERS.FD");
			String tmpLASTNAME = (String) select.getColumnValue("USERS.LASTNAME");
			String tmpMIDDLENAME = (String) select.getColumnValue("USERS.MIDDLENAME");
			String tmpFIRSTNAME = (String) select.getColumnValue("USERS.FIRSTNAME");
			String tmpPASSWORD = (String) select.getColumnValue("USERS.USERPASSWORD");
			String tmpLOGIN = (String) select.getColumnValue("USERS.USERLOGIN");
			Integer tmpGROUPID = (Integer) select.getColumnValue("USERS.USERGROUPID");

			UserName userName = new UserName(tmpLASTNAME, tmpMIDDLENAME, tmpFIRSTNAME);
			tempUser =
				new User(
					(new User.UserPK(tmpID)),
					tmpFD,
					userName,
					tmpGROUPID,
					tmpLOGIN,
					tmpPASSWORD);

			return tempUser;
		} catch (Exception exp) {
			throw new PersistenceException(exp.toString());
		}

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:17:38)
	 * @return java.sql.Date
	 */
	public java.sql.Date getFd() {
		return fd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:26:58)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getGroupID() {
		return groupID;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:52:49)
	 * @return java.util.Vector
	 * @param aGroupID java.lang.String
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static java.util.Vector getListUsersForGroup(String aGroupID)
		throws PersistenceException {
		try {
			Vector allUsers = new Vector(0);
			User tempUser = new User();

			com.ibm.ivj.db.uibeans.Select select = tempUser.getUsersSelectForGroup();
			select.setParameterFromString("USERGROUPID", aGroupID);

			select.execute();
			int numrecs = select.getNumRows();
			if (numrecs <= 0) {
				throw new UserNotFoundException("No groups were found.");
			}

			select.firstRow();
			for (int i = 0; i < numrecs; i++) {
				String tmpID = (String) select.getColumnValueToString("USERS.USERID");
				java.sql.Date tmpFD = (java.sql.Date) select.getColumnValue("USERS.FD");
				String tmpLASTNAME = (String) select.getColumnValue("USERS.LASTNAME");
				String tmpMIDDLENAME = (String) select.getColumnValue("USERS.MIDDLENAME");
				String tmpFIRSTNAME = (String) select.getColumnValue("USERS.FIRSTNAME");
				String tmpPASSWORD = (String) select.getColumnValue("USERS.USERPASSWORD");
				String tmpLOGIN = (String) select.getColumnValue("USERS.USERLOGIN");
				Integer tmpGROUPID = (Integer) select.getColumnValue("USERS.USERGROUPID");

				UserName userName = new UserName(tmpLASTNAME, tmpMIDDLENAME, tmpFIRSTNAME);
				tempUser =
					new User(
						(new User.UserPK(tmpID)),
						tmpFD,
						userName,
						tmpGROUPID,
						tmpLOGIN,
						tmpPASSWORD);

				allUsers.addElement(tempUser);
				select.nextRow();
			}

			return allUsers;
		} catch (com.ibm.db.DataException exp) {
			throw new PersistenceException(exp.toString());
		}

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:18:29)
	 * @return java.lang.String
	 */
	public java.lang.String getLogin() {
		return login;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:18:29)
	 * @return ru.optima.ildar.passportization.policy.molel.UserName
	 */
	public UserName getName() {
		return name;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:18:29)
	 * @return java.lang.String
	 */
	public java.lang.String getPassword() {
		return password;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:41:04)
	 * @return ru.optima.ildar.passportization.policy.molel.User.UserPK
	 */
	public ru.optima.ildar.passportization.policy.molel.User.UserPK getUser_id() {
		return user_id;
	}
	/**
	 * Return the UserDelete property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getUserDelete() {
		if (ivjUserDelete == null) {
			try {
				ivjUserDelete = new com.ibm.ivj.db.uibeans.Modify();
				ivjUserDelete.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.UserDAB.UserDelete()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjUserDelete;
	}
	/**
	 * Return the UserInsert property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getUserInsert() {
		if (ivjUserInsert == null) {
			try {
				ivjUserInsert = new com.ibm.ivj.db.uibeans.Modify();
				ivjUserInsert.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.UserDAB.UserInsert()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjUserInsert;
	}
	/**
	 * Return the UserSelect property value.
	 * @return com.ibm.ivj.db.uibeans.Select
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Select getUserSelect() {
		if (ivjUserSelect == null) {
			try {
				ivjUserSelect = new com.ibm.ivj.db.uibeans.Select();
				ivjUserSelect.setQuery(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.UserDAB.UserSelect()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjUserSelect;
	}
	/**
	 * Return the UsersSelectForGroup property value.
	 * @return com.ibm.ivj.db.uibeans.Select
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Select getUsersSelectForGroup() {
		if (ivjUsersSelectForGroup == null) {
			try {
				ivjUsersSelectForGroup = new com.ibm.ivj.db.uibeans.Select();
				ivjUsersSelectForGroup.setQuery(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.UserDAB.UserSelectForGroup()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjUsersSelectForGroup;
	}
	/**
	 * Return the UserUpdate property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getUserUpdate() {
		if (ivjUserUpdate == null) {
			try {
				ivjUserUpdate = new com.ibm.ivj.db.uibeans.Modify();
				ivjUserUpdate.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.UserDAB.UserUpdate()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjUserUpdate;
	}
	private com.ibm.ivj.db.uibeans.Modify getUserEnable() {
		if (ivjUserEnable == null) {
			try {
				ivjUserEnable = new com.ibm.ivj.db.uibeans.Modify();
				ivjUserEnable.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.UserDAB.UserEnable()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjUserEnable;
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
	 * Initialize the class.
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private void initialize() {
		try {
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			handleException(ivjExc);
		}
		// user code begin {2}
		// user code end
	}
	/**
	 * main entrypoint - starts the part when it is run as an application
	 * @param args java.lang.String[]
	 */
	public static void main(java.lang.String[] args) {
		User tempUser;
		String groupID = "1";
		try {
			System.out.println("Main() started at: " + new java.util.Date());
			System.out.println("Doing simple create/find test.\n");
			String newUserIDstr = "1"; // определите newUserIDstr !!!
			System.out.println("Make new User with key " + newUserIDstr + "\n");
			tempUser =
				new User(
					new User.UserPK(newUserIDstr),
					new java.sql.Date(System.currentTimeMillis()),
					new UserName("lName", "mName", "fName"),
					new Integer(groupID),
					"login",
					"pass");
			tempUser.store();
			System.out.println(tempUser);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			String getUserIDstr = "1";
			System.out.println("Find User with key " + getUserIDstr + ".\n");
			tempUser = findWithUserPK(getUserIDstr);
			System.out.println(tempUser);
			System.out.println("______________________________________");
			System.out.println();
			///////////////////////////////////////////////////////////////
			System.out.println("Make new User with unique key  \n");
			tempUser =
				new User(
					new User.UserPK(),
					new java.sql.Date(System.currentTimeMillis()),
					new UserName("lName", "mName", "fName"),
					new Integer(1),
					"login",
					"pass");
			System.out.println("заранее уникальный :" + tempUser.getUser_id());
			tempUser.store();
			System.out.println(tempUser);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			System.out.println("Find User with unique key " + tempUser.getUser_id() + ".\n");
			tempUser = findWithUserPK(tempUser.getUser_id().getIdAsString());
			System.out.println(tempUser);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			System.out.println("Find all User for Group: " + groupID);
			Vector list = User.getListUsersForGroup(groupID);
			for (int i = 0; i < list.size(); i++) {
				User tempUG = (User) list.elementAt(i);
				System.out.println(tempUG);
			}
			/////////////////////////////////////////////////////////////////
			System.out.println("Delete User with unique key " + tempUser.getUser_id() + ".\n");
			User.deleteWithUserPK(tempUser.getUser_id());
			///////////////////////////////////////////////////////////////
			System.out.println("Find all User for Group: " + groupID);
			list = User.getListUsersForGroup(groupID);
			for (int i = 0; i < list.size(); i++) {
				User tempUG = (User) list.elementAt(i);
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
	 * Creation date: (09.11.2003 18:17:38)
	 * @param newFd java.sql.Date
	 */
	public void setFd(java.sql.Date newFd) {
		fd = newFd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:26:58)
	 * @param newGroupID java.lang.Integer
	 */
	public void setGroupID(java.lang.Integer newGroupID) {
		groupID = newGroupID;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:18:29)
	 * @param newLogin java.lang.String
	 */
	public void setLogin(java.lang.String newLogin) {
		login = newLogin;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:18:29)
	 * @param newName ru.optima.ildar.passportization.policy.molel.UserName
	 */
	public void setName(UserName newName) {
		name = newName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:18:29)
	 * @param newPassword java.lang.String
	 */
	public void setPassword(java.lang.String newPassword) {
		password = newPassword;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:42:50)
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public void store() throws PersistenceException {
		com.ibm.ivj.db.uibeans.Modify modify = null;
		try {
			if (exists()) {
				modify = getUserUpdate();
				modify.setParameterFromString("USER_ID", this.getUser_id().getIdAsString());

			} else {
				//record doesn't exist.
				modify = getUserInsert();
			}

			modify.setParameterFromString("USERID", this.getUser_id().getIdAsString());
			modify.setParameter("FD", getFd());
			modify.setParameter("LASTNAME", getName().getLastName());
			modify.setParameter("MIDDLENAME", getName().getMiddleName());
			modify.setParameter("FIRSTNAME", getName().getFirstName());
			modify.setParameter("USERPASSWORD", getPassword());
			modify.setParameter("USERLOGIN", getLogin());
			modify.setParameter("USERGROUPID", getGroupID());

			modify.execute();
		} catch (com.ibm.db.DataException exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:41:53)
	 * @return java.lang.String
	 */
	public String toString() {
		//return "User(" + user_id + "):" + name;
		return name.toString();
	}
	public boolean equals(Object anObject) {
		try {
			return name.equals(((User) anObject).name);
		} catch (ClassCastException ex) {
			return false;
		}
	}
}
