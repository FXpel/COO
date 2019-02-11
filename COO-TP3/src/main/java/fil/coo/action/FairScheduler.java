package fil.coo.action;

import fil.coo.ActionFinishedException;

/**
 * @author pelage
 *
 */
public class FairScheduler extends Scheduler {
	private int currentAction;
	private boolean firstTime;
	/**
	 * Create a sequential scheduler action
	 */
	public FairScheduler(){
		super();
		this.firstTime = true;
		this.currentAction = 0;
	}
	@Override
	protected void stepEffect() throws ActionFinishedException{
		try {
		this.nextAction().doStep();
		}
		catch(ActionFinishedException e) {
			
		}
	}

	@Override
	public Action nextAction() {
		if (this.firstTime) {
			this.firstTime = false;
			return this.actions.get(currentAction);
		}
		if(this.currentAction >= (this.actions.size()-1)){
			this.currentAction = 0;
		}
		else{
			this.currentAction ++;
		}
		while(this.actions.get(currentAction).isFinished()){
			if(this.currentAction >= (this.actions.size()-1)){
				this.currentAction = 0;
			}
			else{
				this.currentAction ++;
			}
		}
		return this.actions.get(currentAction);

	}
	


}
