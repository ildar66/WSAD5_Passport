package ru.optima.ildar.passportization.policy.molel;

import java.util.Vector;
/**
* Insert the type's description here.
* Creation date: (10.11.2003 18:34:19)
* @author: Shafigullin Ildar
*/
public class Topic {

	public static class TopicPK extends PrimaryKey {
		public TopicPK(String anId) {
			super(anId);
		}
		public TopicPK() {
			super();
		}
	}
	private Topic.TopicPK topic_id;
	private java.sql.Date fd;
	private String caption;
	//private java.util.Vector subTopics;
	private com.ibm.ivj.db.uibeans.Select ivjTopicSelect = null;
	private com.ibm.ivj.db.uibeans.Select ivjTopicSelectAll = null;
	private com.ibm.ivj.db.uibeans.Modify ivjTopicInsert = null;
	private com.ibm.ivj.db.uibeans.Modify ivjTopicUpdate = null;
	private com.ibm.ivj.db.uibeans.Modify ivjTopicDelete = null;
	/**
	 * Topic constructor comment.
	 */
	public Topic() {
		super();
		initialize();
	}
	/**
	 * Topic constructor comment.
	 */
	public Topic(Topic.TopicPK anId, java.sql.Date newFD, String newCaption)
		throws PersistenceException {
		topic_id = anId;
		setFd(newFD);
		setCaption(newCaption);
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 19:17:49)
	 * @param anIdStr java.lang.String
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static void deleteWithTopicPK(String anIdStr) throws PersistenceException {
		deleteWithTopicPK(new TopicPK(anIdStr));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 19:18:58)
	 * @param anId ru.optima.ildar.passportization.policy.molel.Topic.TopicPK
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static void deleteWithTopicPK(TopicPK anId) throws PersistenceException {
		com.ibm.ivj.db.uibeans.Modify modify = null;
		try {
			Topic tempTopic = new Topic();
			modify = tempTopic.getTopicDelete();
			modify.setParameterFromString("TOPICID", anId.getIdAsString());
			modify.execute();
		} catch (Exception exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 19:22:45)
	 * @return boolean
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	private boolean exists() throws PersistenceException {
		try {
			com.ibm.ivj.db.uibeans.Select select = getTopicSelect();

			select.setParameterFromString("TOPICID", getTopic_id().getIdAsString());
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
	 * Creation date: (10.11.2003 19:23:57)
	 * @return ru.optima.ildar.passportization.policy.molel.Topic
	 * @param anIdStr java.lang.String
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static Topic findWithTopicPK(String anIdStr) throws PersistenceException {
		return findWithTopicPK(new TopicPK(anIdStr));
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 19:25:22)
	 */
	public static Topic findWithTopicPK(TopicPK anId) throws PersistenceException {
		try {
			Topic tempTopic = new Topic();
			com.ibm.ivj.db.uibeans.Select select = tempTopic.getTopicSelect();

			select.setParameterFromString("TOPICID", anId.getIdAsString());

			select.execute();

			if (select.getRowCount() <= 0) {
				throw new TopicNotFoundException(
					"The Topic with primary key " + anId.getIdAsString() + " was not found.");
			}

			select.firstRow();
			String tmpTOPICID = (String) select.getColumnValueToString("TOPICS.TOPICID");
			java.sql.Date tmpFD = (java.sql.Date) select.getColumnValue("TOPICS.FD");
			String tmpCAPTION = (String) select.getColumnValue("TOPICS.CAPTION");

			tempTopic = new Topic((new Topic.TopicPK(tmpTOPICID)), tmpFD, tmpCAPTION);

			return tempTopic;
		} catch (Exception exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 18:49:57)
	 * @return java.lang.String
	 */
	public java.lang.String getCaption() {
		return caption;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 18:49:57)
	 * @return java.sql.Date
	 */
	public java.sql.Date getFd() {
		return fd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 19:28:27)
	 * @return java.util.Vector
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public static java.util.Vector getListOfAllTopics() throws PersistenceException {
		try {
			Vector allTopics = new Vector(0);
			Topic tempTopic = new Topic();

			com.ibm.ivj.db.uibeans.Select select = tempTopic.getTopicSelectAll();

			select.execute();
			int numrecs = select.getNumRows();
			if (numrecs <= 0) {
				throw new TopicNotFoundException("No groups were found.");
			}

			select.firstRow();
			for (int i = 0; i < numrecs; i++) {
				String tmpTOPICID = (String) select.getColumnValueToString("TOPICS.TOPICID");
				java.sql.Date tmpFD = (java.sql.Date) select.getColumnValue("TOPICS.FD");
				String tmpCAPTION = (String) select.getColumnValue("TOPICS.CAPTION");

				tempTopic = new Topic((new Topic.TopicPK(tmpTOPICID)), tmpFD, tmpCAPTION);

				allTopics.addElement(tempTopic);
				select.nextRow();
			}

			return allTopics;
		} catch (com.ibm.db.DataException exp) {
			throw new PersistenceException(exp.toString());
		}

	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 18:51:04)
	 * @return ru.optima.ildar.passportization.policy.molel.Topic.TopicPK
	 */
	public ru.optima.ildar.passportization.policy.molel.Topic.TopicPK getTopic_id() {
		return topic_id;
	}
	/**
	 * Return the TopicDelete property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getTopicDelete() {
		if (ivjTopicDelete == null) {
			try {
				ivjTopicDelete = new com.ibm.ivj.db.uibeans.Modify();
				ivjTopicDelete.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.TopicDAB.DeleteTopic()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTopicDelete;
	}
	/**
	 * Return the InsertTopic property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getTopicInsert() {
		if (ivjTopicInsert == null) {
			try {
				ivjTopicInsert = new com.ibm.ivj.db.uibeans.Modify();
				ivjTopicInsert.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.TopicDAB.InsertTopic()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTopicInsert;
	}
	/**
	 * Return the SelectTopic property value.
	 * @return com.ibm.ivj.db.uibeans.Select
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Select getTopicSelect() {
		if (ivjTopicSelect == null) {
			try {
				ivjTopicSelect = new com.ibm.ivj.db.uibeans.Select();
				ivjTopicSelect.setQuery(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.TopicDAB.SelectTopic()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTopicSelect;
	}
	/**
	 * Return the SelectAllTopics property value.
	 * @return com.ibm.ivj.db.uibeans.Select
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Select getTopicSelectAll() {
		if (ivjTopicSelectAll == null) {
			try {
				ivjTopicSelectAll = new com.ibm.ivj.db.uibeans.Select();
				ivjTopicSelectAll.setQuery(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.TopicDAB.SelectTopicAll()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTopicSelectAll;
	}
	/**
	 * Return the TopicUpdate property value.
	 * @return com.ibm.ivj.db.uibeans.Modify
	 */
	/* WARNING: THIS METHOD WILL BE REGENERATED. */
	private com.ibm.ivj.db.uibeans.Modify getTopicUpdate() {
		if (ivjTopicUpdate == null) {
			try {
				ivjTopicUpdate = new com.ibm.ivj.db.uibeans.Modify();
				ivjTopicUpdate.setAction(
					new com.ibm.ivj.db.uibeans.Query(
						ru.optima.ildar.passportization.policy.molel.ConnectionDAB.connToPassport(),
						ru.optima.ildar.passportization.policy.molel.TopicDAB.UpdateTopic()));
				// user code begin {1}
				// user code end
			} catch (java.lang.Throwable ivjExc) {
				// user code begin {2}
				// user code end
				handleException(ivjExc);
			}
		}
		return ivjTopicUpdate;
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
		Topic tempTopic;
		try {
			System.out.println("Main() started at: " + new java.util.Date());
			System.out.println("Doing simple create/find test.\n");
			String newTopicIDstr = "1"; // определите newTopicIDstr !!!
			System.out.println("Make new Topic with key " + newTopicIDstr + "\n");
			tempTopic =
				new Topic(
					new Topic.TopicPK(newTopicIDstr),
					new java.sql.Date(System.currentTimeMillis()),
					"Caption" + newTopicIDstr);
			tempTopic.store(); //ћожет убить существующую запись в базе!!!
			System.out.println(tempTopic);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			String getTopicIDstr = "1";
			System.out.println("Find Topic with key " + getTopicIDstr + ".\n");
			tempTopic = findWithTopicPK(getTopicIDstr);
			System.out.println(tempTopic);
			System.out.println("______________________________________");
			System.out.println();
			///////////////////////////////////////////////////////////////
			System.out.println("Make new Topic with unique key  \n");
			tempTopic =
				new Topic(
					new Topic.TopicPK(),
					new java.sql.Date(System.currentTimeMillis()),
					"Caption" + newTopicIDstr);
			System.out.println("заранее уникальный :" + tempTopic.getTopic_id());
			tempTopic.store();
			System.out.println(tempTopic);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			System.out.println("Find Topic with unique key " + tempTopic.getTopic_id() + ".\n");
			tempTopic = findWithTopicPK(tempTopic.getTopic_id().getIdAsString());
			System.out.println(tempTopic);
			System.out.println("______________________________________");
			System.out.println();
			////////////////////////////////////////////////////////////////
			System.out.println("Find all Topic: ");
			Vector list = Topic.getListOfAllTopics();
			for (int i = 0; i < list.size(); i++) {
				Topic tempUG = (Topic) list.elementAt(i);
				System.out.println(tempUG);
			}
			/////////////////////////////////////////////////////////////////
			System.out.println("Delete Topic with unique key " + tempTopic.getTopic_id() + ".\n");
			Topic.deleteWithTopicPK(tempTopic.getTopic_id());
			////////////////////////////////////////////////////////////////
			System.out.println("Find all Topic: ");
			list = Topic.getListOfAllTopics();
			for (int i = 0; i < list.size(); i++) {
				Topic tempTop = (Topic) list.elementAt(i);
				System.out.println(tempTop);
			}
		} catch (Throwable exception) {
			System.err.println("Exception occurred in main() of java.lang.Object");
			exception.printStackTrace(System.out);
		}
		System.out.println("Main() ended at: " + new java.util.Date());
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 18:49:57)
	 * @param newCaption java.lang.String
	 */
	public void setCaption(java.lang.String newCaption) {
		caption = newCaption;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 18:49:57)
	 * @param newFd java.sql.Date
	 */
	public void setFd(java.sql.Date newFd) {
		fd = newFd;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 19:43:34)
	 * @exception ru.optima.ildar.passportization.policy.molel.PersistenceException The exception description.
	 */
	public void store() throws PersistenceException {
		com.ibm.ivj.db.uibeans.Modify modify = null;
		try {
			if (exists()) {
				modify = getTopicUpdate();
				modify.setParameterFromString("TOPIC_ID", this.getTopic_id().getIdAsString());

			} else {
				//record doesn't exist.
				modify = getTopicInsert();
			}

			modify.setParameterFromString("TOPICID", this.getTopic_id().getIdAsString());
			modify.setParameter("FD", getFd());
			modify.setParameter("CAPTION", getCaption());

			modify.execute();
		} catch (com.ibm.db.DataException exp) {
			throw new PersistenceException(exp.toString());
		}
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 19:42:29)
	 */
	public String toString() {
		//return "Topic(" + topic_id + "):" + caption;
		return caption;
	}
	public boolean equals(Object anObject) {
		try {
			return caption.equals(((Topic) anObject).caption);
		} catch (ClassCastException ex) {
			return false;
		}
	}
}
