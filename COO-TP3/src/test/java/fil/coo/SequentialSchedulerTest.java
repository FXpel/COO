package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;


import fil.coo.action.Action;
import fil.coo.action.ActionState;
import fil.coo.action.Scheduler;
import fil.coo.action.SequentialScheduler;

public class SequentialSchedulerTest extends SchedulerTest {
	protected Scheduler createScheduler() {
		return new SequentialScheduler();
	}
	private class MockScheduler extends Action{
		public int Totaltime =2;
		@Override
		public boolean stopCondition() {
			return Totaltime == 0;
		}

		@Override
		protected void stepEffect() throws ActionFinishedException {
			Totaltime--;
		}
		
	
	}
	
	@Test
	public void doStepTest() throws ActionFinishedException, SchedulerStartedException {
		MockScheduler m1 = new MockScheduler();
		MockScheduler m2= new MockScheduler();
		MockScheduler m3= new MockScheduler();
		SequentialScheduler s = (SequentialScheduler) this.createScheduler();
		s.addAction(m1);
		s.addAction(m2);
		s.addAction(m3);
		//on test progressivemnt les états des actions
		assertEquals(ActionState.READY,m1.getState());
		assertEquals(ActionState.READY,m2.getState());
		assertEquals(ActionState.READY,m3.getState());
		s.doStep();
		assertEquals(ActionState.IN_PROGRESS,m1.getState());
		assertEquals(ActionState.READY,m2.getState());
		assertEquals(ActionState.READY,m3.getState());
		s.doStep();
		assertEquals(ActionState.FINISHED,m1.getState());
		assertEquals(ActionState.READY,m2.getState());
		assertEquals(ActionState.READY,m3.getState());
		s.doStep();
		assertEquals(ActionState.FINISHED,m1.getState());
		assertEquals(ActionState.IN_PROGRESS,m2.getState());
		assertEquals(ActionState.READY,m3.getState());
		s.doStep();
		assertEquals(ActionState.FINISHED,m1.getState());
		assertEquals(ActionState.FINISHED,m2.getState());
		assertEquals(ActionState.READY,m3.getState());
		s.doStep();
		assertEquals(ActionState.FINISHED,m1.getState());
		assertEquals(ActionState.FINISHED,m2.getState());
		assertEquals(ActionState.IN_PROGRESS,m3.getState());
		s.doStep();
		assertEquals(ActionState.FINISHED,m1.getState());
		assertEquals(ActionState.FINISHED,m2.getState());
		assertEquals(ActionState.FINISHED,m3.getState());
		assertTrue(s.stopCondition());
	}
		
}

