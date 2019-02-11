package fil.coo;

/**
 * @author pelage & Karti
 *
 */
public class ActionFinishedException extends Exception {
	/**
	 * the exception if the action is finished
	 */
	public ActionFinishedException()         
	  {  
	    super("Cannot doStep when finished.");        
	  }
}