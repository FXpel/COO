package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.action.FairScheduler;
import fil.coo.action.Swimmer;
import fil.coo.pool.BasketPool;
import fil.coo.pool.CubiclePool;

public class swimmerTest {

	@Test
	public void test() throws ActionFinishedException, SchedulerStartedException {
		BasketPool baskets = new BasketPool(6);
		CubiclePool cubicles = new CubiclePool(3);
		FairScheduler s = new FairScheduler();
		Swimmer Camille = new Swimmer("Camille", baskets, cubicles, 6, 4, 8);
		s.addAction(Camille);
		assertFalse(s.isEmpty());
		int nbSteps = 0;
		while (!s.isFinished()) {
			nbSteps++;
			s.doStep();
			System.out.println(nbSteps);
		}
		System.out.println("Finished in " + nbSteps + " steps");
		}
	}


