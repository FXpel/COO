package fil.coo.action;

/**
 * @author pelage
 * The states of the actions
 */
public enum ActionState {
	/**
	 * the action is about to start
	 */
	READY,
	/**
	 * the action is in progress
	 */
	IN_PROGRESS,
	/**
	 * the action is finished
	 */
	FINISHED;
}
