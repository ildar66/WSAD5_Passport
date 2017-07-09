package ru.optima.ildar.passportization.policy.molel;

import java.util.Vector;
/**
* Insert the type's description here.
* Creation date: (10.11.2003 20:09:18)
* @author: Shafigullin Ildar
*/
public class SubTopic  {

	public static class SubTopicPK extends PrimaryKey {
		public SubTopicPK(String anId) {
			super(anId);
		}
		public SubTopicPK() {
			super();
		}
	}
	private SubTopic.SubTopicPK subTopic_id;
	private java.sql.Date fd;
	private String caption;
	private Integer topicID;
	private com.ibm.ivj.db.uibeans.Select ivjSubTopicSelect = null;
	private com.ibm.ivj.db.uibeans.Select ivjSubTopicSelectForTopic = null;
	private com.ibm.ivj.db.uibeans.Modify ivjSubTopicInsert = null;
	private com.ibm.ivj.db.uibeans.Modify ivjSubTopicUpdate = null;
	private com.ibm.ivj.db.uibeans.Modify ivjSubTopicDelete = null;
	/**
	 * Constructor
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	public SubTopic() {
		super();
		initialize();
	}
	/**
	 * SubTopic constructor comment.
	 */
	public SubTopic(SubTopic.SubTopicPK aId, java.sql.Date aFD, Integer aTopicId, String aName) {
		subTopic_id = aId;
		setFd(aFD);
		setTopicID(aTopicId);
		setCaption(aName);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:37:26)
	 * @param anIdStr java.lang.String
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static void deleteWithSubTopicPK(String anIdStr) throws PersistenceException {
		deleteWithSubTopicPK(new SubTopicPK(anIdStr));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:38:19)
	 * @param anId ru.optima.ildar.passportization.policy.molel.SubTopic.SubTopicPK
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static void deleteWithSubTopicPK(SubTopic.SubTopicPK anId) throws PersistenceException {
		com.ibm.ivj.db.uibeans.Modify modify = null;
		try {
			SubTopic tempSubTopic = new SubTopic();
			modify = tempSubTopic.getSubTopicDelete();
			modify.setParameterFromString("SUBTOPICID", anId.getIdAsString());
			modify.execute();
		} catch (Exception exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:41:01)
	 * @return boolean
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	private boolean exists() throws PersistenceException {
		try {
			com.ibm.ivj.db.uibeans.Select select = getSubTopicSelect();

			select.setParameterFromString("SUBTOPICID", getSubTopic_id().getIdAsString());
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
	 * Creation date: (10.11.2003 20:42:47)
	 * @return ru.optima.ildar.passportization.policy.molel.SubTopic
	 * @param anIdStr java.lang.String
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static SubTopic findWithSubTopicPK(String anIdStr) throws PersistenceException {
		return findWithSubTopicPK(new SubTopicPK(anIdStr));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:43:50)
	 * @return ru.optima.ildar.passportization.policy.molel.SubTopic
	 * @param anId ru.optima.ildar.passportization.policy.molel.SubTopic.SubTopicPK
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static SubTopic findWithSubTopicPK(SubTopicPK anId) throws PersistenceException {
		try {
			SubTopic tempSubTopic = new SubTopic();
			com.ibm.ivj.db.uibeans.Select select = tempSubTopic.getSubTopicSelect();

			//Vector tempAccountsV = new Vector()
			select.setParameterFromString("SUBTOPICID", anId.getIdAsString());

			select.execute();

			if (select.getRowCount() <= 0) {
				throw new SubTopicNotFoundException(
					"The SubTopic with primary key " + anId.getIdAsString() + " was not found.");
			}

			select.firstRow();

			String tmpID = (String) select.getColumnValueToString("SUBTOPICS.SUBTOPICID");
			java.sql.Date tmpFD = (java.sql.Date) select.getColumnValue("SUBTOPICS.FD");
			String tmpCAPTION = (String) select.getColumnValue("SUBTOPICS.CAPTION");
			Integer tmpTOPICID = (Integer) select.getColumnValue("SUBTOPICS.TOPICID");

			tempSubTopic = new SubTopic((new SubTopic.SubTopicPK(tmpID)), tmpFD, tmpTOPICID, tmpCAPTION);

			return tempSubTopic;
		} catch (Exception exp) {
			throw new PersistenceException(exp.toString());
		}

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:57:53)
	 * @return java.lang.String
	 */
	public java.lang.String getCaption() {
		return caption;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:16:30)
	 * @return java.sql.Date
	 */
	public java.sql.Date getFd() {
		return fd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:59:39)
	 * @return java.util.Vector
	 * @param aTopicID java.lang.String
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static Vector getListSubTopicsForTopic(String aTopicID) throws PersistenceException {
		try {
			Vector allSubTopics = new Vector(0);
			SubTopic tempSubTopic = new SubTopic();

			com.ibm.ivj.db.uibeans.Select select = tempSubTopic.getSubTopicSelectForTopic();
			select.setParameterFromString("TOPICID", aTopicID);

			select.execute();
			int numrecs = select.getNumRows();
			if (numrecs <= 0) {
				throw new SubTopicNotFoundException("No groups were found.");
			}

			select.firstRow();
			for (int i = 0; i < numrecs; i++) {
				String tmpID = (String) select.getColumnValueToString("SUBTOPICS.SUBTOPICID");
				java.sql.Date tmpFD = (java.sql.Date) select.getColumnValue("SUBTOPICS.FD");
				String tmpCAPTION = (String) select.getColumnValue("SUBTOPICS.CAPTION");
				Integer tmpTOPICID = (Integer) select.getColumnValue("SUBTOPICS.TOPICID");

				tempSubTopic = new SubTopic((new SubTopic.SubTopicPK(tmpID)), tmpFD, tmpTOPICID, tmpCAPTION);
				allSubTopics.addElement(tempSubTopic);
				select.nextRow();
			}

			return allSubTopics;
		} catch (com.ibm.db.DataException exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:16:30)
	 * @return ru.optima.ildar.passportization.policy.molel.SubTopic.SubTopicPK
	 */
	public ru.optima.ildar.passportization.policy.molel.SubTopic.SubTopicPK getSubTopic_id() {
		return subTopic_id;
	}
	/**
	 * Return the SubTopicDelete property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getSubTopicDelete() {
		if (ivjSubTopicDelete == null) {
			try {
				ivjSubTopicDelete = new com.ibm.ivj.db.uibeans.Modify();
				ivjSubTopicDelete.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.SubTopicDAB.DeleteSubTopic()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjSubTopicDelete;
	}
	/**
	 * Return the SubTopicInsert property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getSubTopicInsert() {
		if (ivjSubTopicInsert == null) {
			try {
				ivjSubTopicInsert = new com.ibm.ivj.db.uibeans.Modify();
				ivjSubTopicInsert.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.SubTopicDAB.InsertSubTopic()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjSubTopicInsert;
	}
	/**
	 * Return the SubTopicSelect property value.
	 * @return com.ibm.ivj.db.uibeans.Select
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Select getSubTopicSelect() {
		if (ivjSubTopicSelect == null) {
			try {
				ivjSubTopicSelect = new com.ibm.ivj.db.uibeans.Select();
				ivjSubTopicSelect.setQuery(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.SubTopicDAB.SelectSubTopic()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjSubTopicSelect;
	}
	/**
	 * Return the SubTopicSelectForTopic property value.
	 * @return com.ibm.ivj.db.uibeans.Select
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Select getSubTopicSelectForTopic() {
		if (ivjSubTopicSelectForTopic == null) {
			try {
				ivjSubTopicSelectForTopic = new com.ibm.ivj.db.uibeans.Select();
				ivjSubTopicSelectForTopic.setQuery(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru
							.optima
							.ildar
							.passportization
							.policy
							.molel
							.SubTopicDAB
							.SelectSubTopicForTopic()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjSubTopicSelectForTopic;
	}
	/**
	 * Return the SubTopicUpdate property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getSubTopicUpdate() {
		if (ivjSubTopicUpdate == null) {
			try {
				ivjSubTopicUpdate = new com.ibm.ivj.db.uibeans.Modify();
				ivjSubTopicUpdate.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.SubTopicDAB.UpdateSubTopic()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjSubTopicUpdate;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:17:52)
	 * @return java.lang.Integer
	 */
	public java.lang.Integer getTopicID() {
		return topicID;
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
		SubTopic tempSubTopic;
		String topicID = "1";
		try {
			System.out.println("Main() started at: " + new java.util.Date());
			System.out.println("Doing simple create/find test.\n");
			String newSubTopicIDstr = "1"; // определите newSubTopicIDstr !!!
			System.out.println("Make new SubTopic with key " + newSubTopicIDstr + "\n");
			tempSubTopic =
				new SubTopic(
					new SubTopic.SubTopicPK(newSubTopicIDstr),
					new java.sql.Date(System.currentTimeMillis()),
					new Integer(topicID), "name");
			tempSubTopic.store();
			System.out.println(tempSubTopic);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			String getSubTopicIDstr = "1";
			System.out.println("Find SubTopic with key " + getSubTopicIDstr + ".\n");
			tempSubTopic = findWithSubTopicPK(getSubTopicIDstr);
			System.out.println(tempSubTopic);
			System.out.println("______________________________________");
			System.out.println();
			///////////////////////////////////////////////////////////////
			System.out.println("Make new SubTopic with unique key  \n");
			tempSubTopic =
				new SubTopic(
					new SubTopic.SubTopicPK(),
					new java.sql.Date(System.currentTimeMillis()),
					new Integer(topicID), "name");
			System.out.println("заранее уникальный :" + tempSubTopic.getSubTopic_id());
			tempSubTopic.store();
			System.out.println(tempSubTopic);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			System.out.println(
				"Find SubTopic with unique key " + tempSubTopic.getSubTopic_id() + ".\n");
			tempSubTopic = findWithSubTopicPK(tempSubTopic.getSubTopic_id().getIdAsString());
			System.out.println(tempSubTopic);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			System.out.println("Find all SubTopic for Topic: " + topicID);
			Vector list = SubTopic.getListSubTopicsForTopic(topicID);
			for (int i = 0; i < list.size(); i++) {
				SubTopic tempST = (SubTopic) list.elementAt(i);
				System.out.println(tempST);
			}
			/////////////////////////////////////////////////////////////////
			System.out.println(
				"Delete SubTopic with unique key " + tempSubTopic.getSubTopic_id() + ".\n");
			SubTopic.deleteWithSubTopicPK(tempSubTopic.getSubTopic_id());
			///////////////////////////////////////////////////////////////
			System.out.println("Find all SubTopic for Topic: " + topicID);
			list = SubTopic.getListSubTopicsForTopic(topicID);
			for (int i = 0; i < list.size(); i++) {
				SubTopic tempST = (SubTopic) list.elementAt(i);
				System.out.println(tempST);
			}
		} catch (Throwable exception) {
			System.err.println("Exception occurred in main() of java.lang.Object");
			exception.printStackTrace(System.out);
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:57:53)
	 * @param newCaption java.lang.String
	 */
	public void setCaption(java.lang.String newCaption) {
		caption = newCaption;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:16:30)
	 * @param newFd java.sql.Date
	 */
	public void setFd(java.sql.Date newFd) {
		fd = newFd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:17:52)
	 * @param newTopicID java.lang.Integer
	 */
	public void setTopicID(java.lang.Integer newTopicID) {
		topicID = newTopicID;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:53:00)
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public void store() throws PersistenceException {
		com.ibm.ivj.db.uibeans.Modify modify = null;
		try {
			if (exists()) {
				modify = getSubTopicUpdate();
				modify.setParameterFromString("SUBTOPIC_ID", this.getSubTopic_id().getIdAsString());

			} else {
				//record doesn't exist.
				modify = getSubTopicInsert();
			}

			modify.setParameterFromString("SUBTOPICID", this.getSubTopic_id().getIdAsString());
			modify.setParameter("FD", getFd());
			modify.setParameter("CAPTION", getCaption());
			modify.setParameter("TOPICID", getTopicID());

			modify.execute();
		} catch (com.ibm.db.DataException exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 20:52:00)
	 */
	public String toString() {
		//return "SubTopic(" + subTopic_id + "):" + caption;
		return caption;
	}
	public boolean equals(Object anObject) {
		try {
			return caption.equals(((SubTopic) anObject).caption);
		} catch (ClassCastException ex) {
			return false;
		}
	}
}
