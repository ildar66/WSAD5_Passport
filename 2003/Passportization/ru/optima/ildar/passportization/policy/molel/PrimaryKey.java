package ru.optima.ildar.passportization.policy.molel;

/**
 * Models identifiers for all objects in this package.
 * The class is based on the String class.
 * It also uses its implementations for hashing.
 * Class will be used as base for derived innerclasses
 * of the respective classes.
 * Creation date: (04.09.2002 18:02:28)
 * @author: Shafigullin Ildar
 */
public class PrimaryKey 
{
   
   /**
    * The class is based on the String class.
    */
   private String id;
/**
 * Construct a new primary key.
 * This implementation uses the time on the computer to
 * create a new 'unique' id. 
 * NOTE: This is not bullet proof !
 * @roseuid 3E0041B70020
 */
public PrimaryKey() {
    String str = Long.toString( (new java.util.Date()).getTime() );
    id = str.substring(0,10);
}
   /**
    * @param anId
    * @roseuid 3E0041B7002A
    */
   public PrimaryKey(String anId) 
   {
		id = anId;    
   }
   /**
    * Uses the equals implementation of the underlying String.
    * Needed for use in HashMap.
    * Creation date: (04.09.2002 18:09:48)
    * @return boolean
    * @param anObject java.lang.Object@return boolean
    * @roseuid 3E0041B7003E
    */
   public boolean equals(Object anObject) 
   {
    try {
        return id.equals(((PrimaryKey) anObject).id);
    }
    catch (ClassCastException ex) {
        return false;
    }    
   }
   /**
    * Return the ID.
    * Creation date: (04.09.2002 18:12:58)
    * @return java.lang.String
    * @roseuid 3E0041B70052
    */
   public String getIdAsString() 
   {
    return id;    
   }
   /**
    * Uses the hashCode of the underlying String.
    * Needed for use in HashMap.
    * Creation date: (04.09.2002 18:14:14)
    * @return int
    * @roseuid 3E0041B70066
    */
   public int hashCode() 
   {
	return id.hashCode();    
   }
   /**
    * Gives standard representation of an instance.
    * Creation date: (04.09.2002 18:17:46)
    * @return java.lang.String
    * @roseuid 3E0041B70070
    */
   public String toString() 
   {
    return ("PK = " + id);    
   }
}
