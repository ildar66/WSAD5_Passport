package ru.optima.ildar.passportization.policy.molel;

import java.util.Vector;
import java.sql.Date;
/**
 * Insert the type's description here.
 * Creation date: (11.11.2003 18:15:05)
 * @author: Shafigullin Ildar
 */
public class Permission {

    public static class PermissionPK extends PrimaryKey {
        public PermissionPK(String anId) {
            super(anId);
        }
        public PermissionPK() {
            super();
        }
    }
    private PermissionPK permission_id;
    private java.sql.Date fd;
    private String caption;
	private com.ibm.ivj.db.uibeans.Select ivjPermissionSelect = null;
	private com.ibm.ivj.db.uibeans.Select ivjPermissionSelectAll = null;
	private com.ibm.ivj.db.uibeans.Modify ivjPermissionInsert = null;
	private com.ibm.ivj.db.uibeans.Modify ivjPermissionUpdate = null;
	private com.ibm.ivj.db.uibeans.Modify ivjPermissionDelete = null;
	private com.ibm.ivj.db.uibeans.Modify ivjUserPermInsert = null;
	private com.ibm.ivj.db.uibeans.Modify ivjUserPermDelete = null;
	private com.ibm.ivj.db.uibeans.Select ivjUserPermSelectForSubTopic = null;
	private com.ibm.ivj.db.uibeans.Modify ivjGroupPermInsert = null;
	private com.ibm.ivj.db.uibeans.Modify ivjGroupPermDelete = null;
	private com.ibm.ivj.db.uibeans.Select ivjGroupPermSelectForSubTopic = null;
/**
 * Constructor
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
public Permission() {
	super();
	initialize();
}
/**
 * Permission constructor comment.
 */
public Permission(PermissionPK anId, java.sql.Date newFD, String newCaption) {
    permission_id = anId;
    setFd(newFD);
    setCaption(newCaption);
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2003 17:34:14)
 * @param groupId java.lang.String
 * @param subtopicId java.lang.String
 * @param permId java.lang.String
 */
public static void addGroupPerm(String groupId, String subtopicId, String permId)
    throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        Permission tempPermission = new Permission();
        modify = tempPermission.getGroupPermInsert();
        modify.setParameterFromString("USERGROUPID", groupId);
        modify.setParameterFromString("SUBTOPICID", subtopicId);
        modify.setParameterFromString("PERMISSIONID", permId);
        modify.setParameter("FD", new Date(System.currentTimeMillis()));
        modify.execute();
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2003 17:39:07)
 * @param userId java.lang.String
 * @param subtopicId java.lang.String
 * @param permId java.lang.String
 */
public static void addUserPerm(String userId, String subtopicId, String permId)
    throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        Permission tempPermission = new Permission();
        modify = tempPermission.getUserPermInsert();
        modify.setParameterFromString("USERID", userId);
        modify.setParameterFromString("SUBTOPICID", subtopicId);
        modify.setParameterFromString("PERMISSIONID", permId);
        modify.setParameter("FD", new Date(System.currentTimeMillis()));
        modify.execute();
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2003 17:29:02)
 * @param groupId java.lang.String
 * @param subtopicId java.lang.String
 * @param permId java.lang.String
 */
public static void deleteGroupPerm(String groupId, String subtopicId, String permId)
    throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        Permission tempPermission = new Permission();
        modify = tempPermission.getGroupPermDelete();
        modify.setParameterFromString("USERGROUPID", groupId);
        modify.setParameterFromString("SUBTOPICID", subtopicId);
        modify.setParameterFromString("PERMISSIONID", permId);
        modify.execute();
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2003 17:26:07)
 * @param userId java.lang.String
 * @param subtopicId java.lang.String
 * @param permId java.lang.String
 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
 */
public static void deleteUserPerm(String userId, String subtopicId, String permId)
    throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        Permission tempPermission = new Permission();
        modify = tempPermission.getUserPermDelete();
        modify.setParameterFromString("USERID", userId);
        modify.setParameterFromString("SUBTOPICID", subtopicId);
        modify.setParameterFromString("PERMISSIONID", permId);
        modify.execute();
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 18:56:24)
 * @param anIdStr java.lang.String
 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
 */
public static void deleteWithPermissionPK(String anIdStr) throws PersistenceException {
    deleteWithPermissionPK(new PermissionPK(anIdStr));
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 18:57:05)
 */
public static void deleteWithPermissionPK(PermissionPK anId) throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        Permission tempPermission = new Permission();
        modify = tempPermission.getPermissionDelete();
        modify.setParameterFromString("PERMISSIONID", anId.getIdAsString());
        modify.execute();
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 18:59:20)
 */
public boolean equals(Object anObject) {
    try {
        return caption.equals(((Permission) anObject).caption);
    }
    catch (ClassCastException ex) {
        return false;
    }
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 18:59:56)
 */
private boolean exists() throws PersistenceException {
    try {
        com.ibm.ivj.db.uibeans.Select select = getPermissionSelect();

        select.setParameterFromString("PERMISSIONID", getPermission_id().getIdAsString());
        select.execute();
        if (select.getNumRows() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 19:02:15)
 * @return ru.optima.ildar.passportization.policy.molel.Permission
 * @param anIdStr java.lang.String
 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
 */
public static Permission findWithPermissionPK(String anIdStr) throws PersistenceException {
	return findWithPermissionPK(new PermissionPK(anIdStr));
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 19:02:52)
 */
public static Permission findWithPermissionPK(PermissionPK anId) throws PersistenceException {
    try {
        Permission tempPermission = new Permission();
        com.ibm.ivj.db.uibeans.Select select = tempPermission.getPermissionSelect();

        select.setParameterFromString("PERMISSIONID", anId.getIdAsString());

        select.execute();

        if (select.getRowCount() <= 0) {
            throw new PermissionNotFoundException(
                "The Permission with primary key " + anId.getIdAsString() + " was not found.");
        }

        select.firstRow();
        String tmpPermissionID = (String) select.getColumnValueToString("SYSTEMPERMISSIONS.PERMISSIONID");
        java.sql.Date tmpFD = (java.sql.Date) select.getColumnValue("SYSTEMPERMISSIONS.FD");
        String tmpCAPTION = (String) select.getColumnValue("SYSTEMPERMISSIONS.CAPTION");

        tempPermission = new Permission((new Permission.PermissionPK(tmpPermissionID)), tmpFD, tmpCAPTION);

        return tempPermission;
    }
    catch (Exception exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 18:19:31)
 * @return java.lang.String
 */
public java.lang.String getCaption() {
	return caption;
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 18:19:31)
 * @return java.sql.Date
 */
public java.sql.Date getFd() {
	return fd;
}
/**
 * Return the GroupPermDelete property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getGroupPermDelete() {
	if (ivjGroupPermDelete == null) {
		try {
			ivjGroupPermDelete = new com.ibm.ivj.db.uibeans.Modify();
			ivjGroupPermDelete.setAction(new com.ibm.ivj.db.uibeans.Query(ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(), ru.optima.ildar.passportization.policy.molel.PermissionDAB.DeleteGroupPerm()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjGroupPermDelete;
}
/**
 * Return the GroupPermInsert property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getGroupPermInsert() {
	if (ivjGroupPermInsert == null) {
		try {
			ivjGroupPermInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjGroupPermInsert.setAction(new com.ibm.ivj.db.uibeans.Query(ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(), ru.optima.ildar.passportization.policy.molel.PermissionDAB.InsertGroupPerm()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjGroupPermInsert;
}
/**
 * Return the GroupPermSelectForSubTopic property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getGroupPermSelectForSubTopic() {
	if (ivjGroupPermSelectForSubTopic == null) {
		try {
			ivjGroupPermSelectForSubTopic = new com.ibm.ivj.db.uibeans.Select();
			ivjGroupPermSelectForSubTopic.setQuery(new com.ibm.ivj.db.uibeans.Query(ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(), ru.optima.ildar.passportization.policy.molel.PermissionDAB.SelectGroupPermForSubTopic()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjGroupPermSelectForSubTopic;
}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2003 17:13:54)
 * @return java.util.Vector
 * @param groupID java.lang.String
 * @param subTopicID java.lang.String
 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
 */
public static Vector getListGroupPermForSubTopic(String groupID, String subTopicID)
    throws PersistenceException {
    try {
        Vector allPermissions = new Vector(0);
        Permission tempPermission = new Permission();

        com.ibm.ivj.db.uibeans.Select select = tempPermission.getGroupPermSelectForSubTopic();
        select.setParameterFromString("USERGROUPID", groupID);
        select.setParameterFromString("SUBTOPICID", subTopicID);
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs <= 0) {
            //throw new PermissionNotFoundException("No permission were found.");
            return allPermissions;
        }

        select.firstRow();
        for (int i = 0; i < numrecs; i++) {
            String tmpPermissionID = (String) select.getColumnValueToString("USERGROUPSPERMISSIONS.PERMISSIONID");
            allPermissions.addElement(tmpPermissionID);
            select.nextRow();
        }

        return allPermissions;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 19:07:02)
 */
public static java.util.Vector getListOfAllPermissions() throws PersistenceException {
    try {
        Vector allPermissions = new Vector(0);
        Permission tempPermission = new Permission();

        com.ibm.ivj.db.uibeans.Select select = tempPermission.getPermissionSelectAll();

        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs <= 0) {
            //throw new PermissionNotFoundException("No permission were found.");
            return allPermissions;
        }

        select.firstRow();
        for (int i = 0; i < numrecs; i++) {
            String tmpPermissionID = (String) select.getColumnValueToString("SYSTEMPERMISSIONS.PERMISSIONID");
            java.sql.Date tmpFD = (java.sql.Date) select.getColumnValue("SYSTEMPERMISSIONS.FD");
            String tmpCAPTION = (String) select.getColumnValue("SYSTEMPERMISSIONS.CAPTION");

            tempPermission = new Permission((new Permission.PermissionPK(tmpPermissionID)), tmpFD, tmpCAPTION);

            allPermissions.addElement(tempPermission);
            select.nextRow();
        }

        return allPermissions;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (14.11.2003 17:20:55)
 * @return java.util.Vector
 * @param userID java.lang.String
 * @param subTopicID java.lang.String
 */
public static Vector getListUserPermForSubTopic(String userID, String subTopicID)
    throws PersistenceException {
    try {
        Vector allPermissions = new Vector(0);
        Permission tempPermission = new Permission();

        com.ibm.ivj.db.uibeans.Select select = tempPermission.getUserPermSelectForSubTopic();
        select.setParameterFromString("USERID", userID);
        select.setParameterFromString("SUBTOPICID", subTopicID);
        select.execute();
        int numrecs = select.getNumRows();
        if (numrecs <= 0) {
            //throw new PermissionNotFoundException("No permission were found.");
            return allPermissions;
        }

        select.firstRow();
        for (int i = 0; i < numrecs; i++) {
            String tmpPermissionID =
                (String) select.getColumnValueToString("USERPERMISSIONS.PERMISSIONID");
            allPermissions.addElement(tmpPermissionID);
            select.nextRow();
        }

        return allPermissions;
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }

}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 18:19:31)
 * @return ru.optima.ildar.passportization.policy.molel.Permission.PermissionPK
 */
public ru.optima.ildar.passportization.policy.molel.Permission.PermissionPK getPermission_id() {
	return permission_id;
}
/**
 * Return the PermissionDelete property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getPermissionDelete() {
	if (ivjPermissionDelete == null) {
		try {
			ivjPermissionDelete = new com.ibm.ivj.db.uibeans.Modify();
			ivjPermissionDelete.setAction(new com.ibm.ivj.db.uibeans.Query(ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(), ru.optima.ildar.passportization.policy.molel.PermissionDAB.DeletePermission()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPermissionDelete;
}
/**
 * Return the PermissionInsert property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getPermissionInsert() {
	if (ivjPermissionInsert == null) {
		try {
			ivjPermissionInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjPermissionInsert.setAction(new com.ibm.ivj.db.uibeans.Query(ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(), ru.optima.ildar.passportization.policy.molel.PermissionDAB.InsertPermission()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPermissionInsert;
}
/**
 * Return the PermissionSelect property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getPermissionSelect() {
	if (ivjPermissionSelect == null) {
		try {
			ivjPermissionSelect = new com.ibm.ivj.db.uibeans.Select();
			ivjPermissionSelect.setQuery(new com.ibm.ivj.db.uibeans.Query(ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(), ru.optima.ildar.passportization.policy.molel.PermissionDAB.SelectPermission()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPermissionSelect;
}
/**
 * Return the PermissionSelectAll property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getPermissionSelectAll() {
	if (ivjPermissionSelectAll == null) {
		try {
			ivjPermissionSelectAll = new com.ibm.ivj.db.uibeans.Select();
			ivjPermissionSelectAll.setQuery(new com.ibm.ivj.db.uibeans.Query(ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(), ru.optima.ildar.passportization.policy.molel.PermissionDAB.SelectPermissionAll()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPermissionSelectAll;
}
/**
 * Return the PermissionUpdate property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getPermissionUpdate() {
	if (ivjPermissionUpdate == null) {
		try {
			ivjPermissionUpdate = new com.ibm.ivj.db.uibeans.Modify();
			ivjPermissionUpdate.setAction(new com.ibm.ivj.db.uibeans.Query(ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(), ru.optima.ildar.passportization.policy.molel.PermissionDAB.UpdatePermission()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjPermissionUpdate;
}
/**
 * Return the UserPermDelete property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getUserPermDelete() {
	if (ivjUserPermDelete == null) {
		try {
			ivjUserPermDelete = new com.ibm.ivj.db.uibeans.Modify();
			ivjUserPermDelete.setAction(new com.ibm.ivj.db.uibeans.Query(ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(), ru.optima.ildar.passportization.policy.molel.PermissionDAB.DeleteUserPerm()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjUserPermDelete;
}
/**
 * Return the UserPermInsert property value.
 * @return com.ibm.ivj.db.uibeans.Modify
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Modify getUserPermInsert() {
	if (ivjUserPermInsert == null) {
		try {
			ivjUserPermInsert = new com.ibm.ivj.db.uibeans.Modify();
			ivjUserPermInsert.setAction(new com.ibm.ivj.db.uibeans.Query(ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(), ru.optima.ildar.passportization.policy.molel.PermissionDAB.InsertUserPerm()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjUserPermInsert;
}
/**
 * Return the UserPermSelectForSubTopic property value.
 * @return com.ibm.ivj.db.uibeans.Select
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private com.ibm.ivj.db.uibeans.Select getUserPermSelectForSubTopic() {
	if (ivjUserPermSelectForSubTopic == null) {
		try {
			ivjUserPermSelectForSubTopic = new com.ibm.ivj.db.uibeans.Select();
			ivjUserPermSelectForSubTopic.setQuery(new com.ibm.ivj.db.uibeans.Query(ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(), ru.optima.ildar.passportization.policy.molel.PermissionDAB.SelectUserPermForSubTopic()));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjUserPermSelectForSubTopic;
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
    Permission tempPermission;
    try {
        System.out.println("Main() started at: " + new java.util.Date());
        System.out.println("Doing simple create/find test.\n");
        String newPermissionIDstr = "1"; // определите newPermissionIDstr !!!
        System.out.println("Make new Permission with key " + newPermissionIDstr + "\n");
        tempPermission =
            new Permission(
                new Permission.PermissionPK(newPermissionIDstr),
                new java.sql.Date(System.currentTimeMillis()),
                "Caption" + newPermissionIDstr);
        tempPermission.store(); //ћожет убить существующую запись в базе!!!
        System.out.println(tempPermission);
        System.out.println("______________________________________");
        System.out.println();
        ////////////////////////////////////////////////////////////////
        String getPermissionIDstr = "1";
        System.out.println("Find Permission with key " + getPermissionIDstr + ".\n");
        tempPermission = findWithPermissionPK(getPermissionIDstr);
        System.out.println(tempPermission);
        System.out.println("______________________________________");
        System.out.println();
        ///////////////////////////////////////////////////////////////
        System.out.println("Make new Permission with unique key  \n");
        tempPermission =
            new Permission(
                new Permission.PermissionPK(),
                new java.sql.Date(System.currentTimeMillis()),
                "Caption" + newPermissionIDstr);
        System.out.println("заранее уникальный :" + tempPermission.getPermission_id());
        tempPermission.store();
        System.out.println(tempPermission);
        System.out.println("______________________________________");
        System.out.println();
        ////////////////////////////////////////////////////////////////
        System.out.println("Find Permission with unique key " + tempPermission.getPermission_id() + ".\n");
        tempPermission = findWithPermissionPK(tempPermission.getPermission_id().getIdAsString());
        System.out.println(tempPermission);
        System.out.println("______________________________________");
        System.out.println();
        ////////////////////////////////////////////////////////////////
        System.out.println("Find all Permission: ");
        Vector list = Permission.getListOfAllPermissions();
        for (int i = 0; i < list.size(); i++) {
            Permission tempP = (Permission) list.elementAt(i);
            System.out.println(tempP);
        }
        /////////////////////////////////////////////////////////////////
        System.out.println(
            "Delete Permission with unique key " + tempPermission.getPermission_id() + ".\n");
        Permission.deleteWithPermissionPK(tempPermission.getPermission_id());
        System.out.println("Find all Permission: ");
        list = Permission.getListOfAllPermissions();
        for (int i = 0; i < list.size(); i++) {
            Permission tempP = (Permission) list.elementAt(i);
            System.out.println(tempP);
        }
        ////////////////////////////////////////////////////////////////
        String groupID = "1";
        String subTopicID = "1";
        String userID = "1";
        String permID = "1";
        System.out.println(
            "Add GroupPerm with :"
                + " grID:"
                + groupID
                + " sID :"
                + subTopicID
                + " permID: "
                + permID
                + ".\n");
        //Permission.addGroupPerm(groupID, subTopicID, permID);
        System.out.println(
            "Add serPerm with :"
                + " userID:"
                + userID
                + " sID :"
                + subTopicID
                + " permID: "
                + permID
                + ".\n");
        Permission.addUserPerm(userID, subTopicID, permID);
        ////////////////////////////////////////////////////////////
        System.out.println("Find all GroupPerm for groupID: " + groupID + " sT:" + subTopicID);
        list = Permission.getListGroupPermForSubTopic(groupID, subTopicID);
        for (int i = 0; i < list.size(); i++) {
            String tempP = (String) list.elementAt(i);
            System.out.println(tempP);
        }
        System.out.println("Find all UserPerm for userID: " + userID + " sT:" + subTopicID);
        list = Permission.getListUserPermForSubTopic(userID, subTopicID);
        for (int i = 0; i < list.size(); i++) {
            String tempP = (String) list.elementAt(i);
            System.out.println(tempP);
        }
        /////////////////////////////////////////////////////////////
        System.out.println(
            "Delete Permission with :"
                + " grID:"
                + groupID
                + " sID :"
                + subTopicID
                + " permID: "
                + permID
                + ".\n");
        //Permission.deleteGroupPerm(groupID, subTopicID, permID);
        System.out.println(
            "Delete Permission with :"
                + " grID:"
                + groupID
                + " sID :"
                + subTopicID
                + " permID: "
                + permID
                + ".\n");
        //Permission.deleteUserPerm(userID, subTopicID, permID);
        ////////////////////////////////////////////////////////////
        System.out.println("Find all GroupPerm for groupID: " + groupID + " sT:" + subTopicID);
        list = Permission.getListGroupPermForSubTopic(groupID, subTopicID);
        for (int i = 0; i < list.size(); i++) {
            String tempP = (String) list.elementAt(i);
            System.out.println(tempP);
        }
        System.out.println("Find all UserPerm for userID: " + userID + " sT:" + subTopicID);
        list = Permission.getListUserPermForSubTopic(userID, subTopicID);
        for (int i = 0; i < list.size(); i++) {
            String tempP = (String) list.elementAt(i);
            System.out.println(tempP);
        }
        /////////////////////////////////////////////////////////////

    }
    catch (Throwable exception) {
        System.err.println("Exception occurred in main() of java.lang.Object");
        exception.printStackTrace(System.out);
    }
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 18:19:31)
 * @param newCaption java.lang.String
 */
public void setCaption(java.lang.String newCaption) {
	caption = newCaption;
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 18:19:31)
 * @param newFd java.sql.Date
 */
public void setFd(java.sql.Date newFd) {
	fd = newFd;
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 19:12:38)
 */
public void store() throws PersistenceException {
    com.ibm.ivj.db.uibeans.Modify modify = null;
    try {
        if (exists()) {
            modify = getPermissionUpdate();
            modify.setParameterFromString("PERMISSION_ID", this.getPermission_id().getIdAsString());

        }
        else {
            //record doesn't exist.
            modify = getPermissionInsert();
        }

        modify.setParameterFromString("PERMISSIONID", this.getPermission_id().getIdAsString());
        modify.setParameter("FD", getFd());
        modify.setParameter("CAPTION", getCaption());

        modify.execute();
    }
    catch (com.ibm.db.DataException exp) {
        throw new PersistenceException(exp.toString());
    }
}
/**
 * Insert the method's description here.
 * Creation date: (11.11.2003 19:14:17)
 */
public String toString() {
	//return "Permission(" + permission_id + "):" + caption;
	return caption;
}
}
