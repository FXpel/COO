package fil.coo;

import static org.junit.Assert.*;

import java.util.*;

import java.util.List;
import java.util.ArrayList;

import fil.coo.resource.Resource;


import org.junit.Test;

import fil.coo.action.Action;
import fil.coo.action.ActionState;
import fil.coo.action.Scheduler;

public abstract class SchedulerTest extends ActionTest{
	protected List<Action> actions;

	protected abstract Scheduler createScheduler();
	protected Action createAction() {
		return this.createScheduler();
	}
	
	
	/*
	@Test
	public void testStopCondition() throws ActionFinishedException {
		Action a = this.createAction();
		while(!a.stopCondition()) {
			a.doStep();
		}
		assertTrue(a.stopCondition());
	}*/


/*
	@Test
	public void testAddAction() {
		this.actions = new ArrayList<Action>();
		Action a = createAction();
		this.actions.add(a);
		this.addAction(a);
		assertTrue(actions.contains(a));
	}

*/


}
