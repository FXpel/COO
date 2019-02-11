package fil.coo.action;
import java.util.List;

import fil.coo.ActionFinishedException;
import fil.coo.SchedulerStartedException;

import java.util.ArrayList;

/**
 * @author pelage
 * Scheduler class
 */
public abstract class Scheduler extends Action {
	protected List<Action> actions;
	
	
	/**
	 * Create an scheduler action
	 */
	public Scheduler(){
		super();
		this.actions = new ArrayList<Action>();
		
	}

	@Override
	public boolean stopCondition() {
		boolean b;
		b=true;
		if (this.actions.isEmpty()) {
			return b;
		}
		for (Action a : this.actions) {
			if (!a.isFinished()) {
				
				b = false;
				return b;
			}
		}
		return b;


	}
	public void addAction(Action a)throws ActionFinishedException, SchedulerStartedException  {
		if (this.state != ActionState.READY) {
				throw new SchedulerStartedException();
			}
		if (a.isFinished()) {
			throw new ActionFinishedException();
		} else {
			this.actions.add(a);
			}
	}
	
	/**
	 * 
	 * @return  true if the list of action is empty
	 */
	public boolean isEmpty(){
		return actions.size() == 0;
	}
	/**
	 * make the effect of one step
	 */
	protected abstract void stepEffect() throws ActionFinishedException;

		
	/**
	 * make the next action
	 * @return the next action
	 */
	public abstract Action nextAction();

}
