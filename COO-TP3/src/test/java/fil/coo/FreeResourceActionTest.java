package fil.coo;

import static org.junit.Assert.*;

import org.junit.Test;

import fil.coo.pool.BasketPool;
import fil.coo.pool.CubiclePool;
import fil.coo.pool.ResourcePool;
import fil.coo.resource.Basket;
import fil.coo.resource.Cubicle;
import fil.coo.resource.ResourceUser;
import fil.coo.action.FairScheduler;
import fil.coo.action.FreeResourceAction;
import fil.coo.action.TakeResourceAction;
public class FreeResourceActionTest {

	@Test
	public void stopConditiontest() throws ActionFinishedException, SchedulerStartedException {
		BasketPool baskets = new BasketPool(2);
		CubiclePool cubicles = new CubiclePool(2);
		ResourceUser<Basket> basketUser = new ResourceUser<Basket>("Basket");
		ResourceUser<Cubicle> cubicleUser = new ResourceUser<Cubicle>("Cubicle");
		TakeResourceAction<Basket> tb = new TakeResourceAction<Basket>(baskets,basketUser);
		TakeResourceAction<Cubicle> tc = new TakeResourceAction<Cubicle>(cubicles,cubicleUser);
		FreeResourceAction<Basket> fb = new FreeResourceAction<Basket>(baskets,basketUser);
		FreeResourceAction<Cubicle> fc = new FreeResourceAction<Cubicle>(cubicles,cubicleUser);
		assertFalse(tb.stopCondition());
		assertFalse(tc.stopCondition());
		FairScheduler s = new FairScheduler();
		s.addAction(fb);
		s.addAction(fc);
		s.addAction(tb);
		s.addAction(tc);
		assertFalse(s.isEmpty());
		while (!s.isFinished()) {
			s.doStep();
		}
		assertTrue(tb.stopCondition());
		assertTrue(tc.stopCondition());
	}

	@Test
	public void stepEffectTest() throws ActionFinishedException, SchedulerStartedException {
		BasketPool baskets = new BasketPool(2);
		CubiclePool cubicles = new CubiclePool(2);
		ResourceUser<Basket> basketUser = new ResourceUser<Basket>("Basket");
		ResourceUser<Cubicle> cubicleUser = new ResourceUser<Cubicle>("Cubicle");
		assertEquals(null,cubicleUser.getResource());
		assertEquals(null,basketUser.getResource());
		TakeResourceAction<Basket> tb = new TakeResourceAction<Basket>(baskets,basketUser);
		TakeResourceAction<Cubicle> tc = new TakeResourceAction<Cubicle>(cubicles,cubicleUser);
		FreeResourceAction<Basket> fb = new FreeResourceAction<Basket>(baskets,basketUser);
		FreeResourceAction<Cubicle> fc = new FreeResourceAction<Cubicle>(cubicles,cubicleUser);
		assertFalse(cubicleUser.getResource()!=null);
		assertFalse(basketUser.getResource()!=null);
		FairScheduler s = new FairScheduler();
		s.addAction(tb);
		s.addAction(tc);
		s.addAction(fb);
		s.addAction(fc);
		assertFalse(s.isEmpty());
		while (!s.isFinished()) {
			s.doStep();
		}
		
		assertTrue(fb.stopCondition());
		assertTrue(fc.stopCondition());
		assertEquals(null,cubicleUser.getResource());
		assertEquals(null,basketUser.getResource());
	}
}
