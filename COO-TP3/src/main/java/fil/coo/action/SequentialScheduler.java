package fil.coo.action;

import fil.coo.ActionFinishedException;

/**
 * @author pelage
 *
 */
public class SequentialScheduler extends Scheduler {
	
	/**
	 * Create a sequential scheduler action
	 */
	public SequentialScheduler(){
		super();
	}
	@Override
	protected void stepEffect()throws ActionFinishedException{
		try{
			nextAction().doStep();
		}
		catch(ActionFinishedException e){
			throw new ActionFinishedException();
		}

	}

	@Override
	public Action nextAction() {
		if(this.actions.get(0).isFinished()) {
			this.actions.remove(0);
		}
		return this.actions.get(0);
	}
}
