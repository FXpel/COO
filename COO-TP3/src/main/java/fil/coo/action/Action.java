package fil.coo.action;

import fil.coo.ActionFinishedException;

/**
 * @author pelage
 * The Action class
 *
 */
public abstract class Action {
	protected ActionState state;
	
	
	/**
	 * Create an action
	 */
	public Action(){
		this.state = ActionState.READY;
	}
	
	/**
	 * 
	 * @return true if the action is finished
	 */
	public boolean isFinished(){
		return this.state == ActionState.FINISHED;
	}
	
	/**
	 * 
	 * @return true if the action is in progress
	 */
	public boolean isInProgress(){
		return this.state == ActionState.IN_PROGRESS;
	}
	
	/**
	 * 
	 * @return true if the action is ready
	 */
	public boolean isReady(){
		return this.state == ActionState.READY;
	}
	
	/**
	 * do a step
	 * @throws ActionFinishedException 
	 */
	public final void doStep() throws ActionFinishedException {
		if (this.stopCondition()) {
			this.state = ActionState.FINISHED;
		}
		if (this.state == ActionState.FINISHED) {
			throw new ActionFinishedException();
		}
		if (this.state == ActionState.READY) {
			this.state = ActionState.IN_PROGRESS;
		}
		this.stepEffect();
		if (this.stopCondition()) {
			this.state = ActionState.FINISHED;
		}
	}
	/**
	 * 
	 * @return true if this is a condition where the action should stop
	 */
	public abstract boolean stopCondition();
	
	/**
	 * 
	 * @return the state of the action
	 */
	public ActionState getState(){
		return this.state;
	}
	
	/**
	 * the effect of the Step
	 * @throws ActionFinishedException 
	 *
	 */
	protected abstract void stepEffect() throws ActionFinishedException;
	
}
