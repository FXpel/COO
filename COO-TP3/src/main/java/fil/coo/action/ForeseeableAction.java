package fil.coo.action;

import fil.coo.ActionFinishedException;

/**
 * @author pelage
 * a Forseeable action
 */
public class ForeseeableAction extends Action {
	protected int totalTime;
	protected int remainingTime;
	protected String description;
	
	/**
	 * @param totalTime
	 */
	public ForeseeableAction(int totalTime){
		super();
		this.totalTime= totalTime;
		this.remainingTime = totalTime;
		
	}
	
	
	@Override
	public boolean stopCondition() {
		return remainingTime==0;
	}

	@Override
	protected void stepEffect() throws ActionFinishedException {
		this.remainingTime--;
		System.out.println(this.description +" "+ (this.totalTime-this.remainingTime)+"/" + this.totalTime);
	}

}
