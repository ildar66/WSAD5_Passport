package ru.optima.ildar.passportization.policy.molel;

/**
 * Insert the type's description here.
 * Creation date: (09.11.2003 18:05:48)
 * @author: Shafigullin Ildar
 */
public class UserName {
	private String lastName;
	private String middleName;
	private String firstName;
	/**
	 * UserName constructor comment.
	 */
	public UserName(String aLASTNAME, String aMIDDLENAME, String aFIRSTNAME) {
		lastName = aLASTNAME;
		middleName = aMIDDLENAME;
		firstName = aFIRSTNAME;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:09:40)
	 * @return java.lang.String
	 */
	public java.lang.String getFirstName() {
		return firstName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:09:40)
	 * @return java.lang.String
	 */
	public java.lang.String getLastName() {
		return lastName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:09:40)
	 * @return java.lang.String
	 */
	public java.lang.String getMiddleName() {
		return middleName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:09:40)
	 * @param newFirstName java.lang.String
	 */
	public void setFirstName(java.lang.String newFirstName) {
		firstName = newFirstName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:09:40)
	 * @param newLastName java.lang.String
	 */
	public void setLastName(java.lang.String newLastName) {
		lastName = newLastName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (09.11.2003 18:09:40)
	 * @param newMiddleName java.lang.String
	 */
	public void setMiddleName(java.lang.String newMiddleName) {
		middleName = newMiddleName;
	}
	/**
	 * Insert the method's description here.
	 * Creation date: (10.11.2003 18:35:29)
	 * @return java.lang.String
	 */
	public String toString() {
		return lastName + " " + firstName + " " + middleName;
	}
	public boolean equals(Object anObject) {
		try {
			UserName other = (UserName) anObject;
			return lastName.equals(other.lastName)
				&& middleName.equals(other.middleName)
				&& firstName.equals(other.firstName);
		} catch (ClassCastException ex) {
			return false;
		}
	}
}
