package fil.coo;

/**
 * @author pelage & Karti
 *
 */
public class SchedulerStartedException extends Exception {
	/**
	 * the exception if the action is added when in progress or finished
	 */
	public SchedulerStartedException(){
		super("Can’t add when scheduler is in progress or has finished");
	}
}
