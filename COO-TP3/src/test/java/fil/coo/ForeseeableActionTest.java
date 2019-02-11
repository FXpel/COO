package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.action.Action;
import fil.coo.action.ActionState;
import fil.coo.action.ForeseeableAction;
import fil.coo.action.Scheduler;
import fil.coo.action.SequentialScheduler;

public class ForeseeableActionTest extends ActionTest{
	protected ForeseeableAction createAction() {
		return new ForeseeableAction(2);
	}
	
	@Test
	public void testStopCondition() throws ActionFinishedException {
		ForeseeableAction f = this.createAction();
		f.doStep();
		f.doStep();
		assertTrue(f.stopCondition());
	}

	@Test
	public void testStepEffect() throws ActionFinishedException {
		ForeseeableAction f = this.createAction();
		f.doStep();
		assertEquals(ActionState.IN_PROGRESS,f.getState());
	}
	
	@Test(expected = ActionFinishedException.class)
	public void BadtestStepEffect() throws ActionFinishedException {
		ForeseeableAction f = this.createAction();
		f.doStep();
		f.doStep();
		assertEquals(ActionState.FINISHED,f.getState());
		f.doStep();
		
	}




}
